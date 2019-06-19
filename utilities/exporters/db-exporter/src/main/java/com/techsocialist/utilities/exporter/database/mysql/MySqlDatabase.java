package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Formatter;
import com.techsocialist.utilities.exporter.database.*;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableCellAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableRowAsSqlComment;

import java.sql.Connection;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlDatabase implements Database {

	protected Connection connection;

	protected String dbName;

	private Map<String, Table> nameTableMap = new HashMap<String, Table>();

	public MySqlDatabase() {

	}

	private Connection getConnection(String url, String user, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}

	public void open(String url, String user, String password)
			throws SQLException, ClassNotFoundException {
		this.connection = getConnection(url, user, password);
		this.dbName = url.substring(url.lastIndexOf("/") + 1, url.length());
	}

	public void open(String url, String port, String dbName, String user,
			String password) throws SQLException, ClassNotFoundException {
		url = url.endsWith("/") ? url.substring(0, url.lastIndexOf("/")) + ":"
				+ port : (url + ":" + port + "/");
		url += dbName;
		this.connection = this.getConnection(url, user, password);
		this.dbName = dbName;
	}

	protected String exportTable(List<Table> parentTables, boolean withData)
			throws SQLException {
		StringBuffer buffer = new StringBuffer();
		if (null != parentTables) {
			Iterator<Table> tableItr = parentTables.iterator();
			while (tableItr.hasNext()) {
				Table table = (Table) tableItr.next();
				if (!table.isEvaluated()) {
					buffer.append(getTableStructure(table.getName()));
					buffer.append(getTableDropStatement(table.getName()));
					buffer.append(getTableCreateStatement(table.getName()));
					if (withData) {
						buffer.append(getInsertStatements(table.getName()));
					}
					buffer.append("\n");
					table.setEvaluated(true);
				}
			}
		}
		return buffer.toString();
	}

	public String exportAsSql(boolean withData) throws SQLException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SET NAMES utf8;").append("\n");
		buffer.append("SET SQL_MODE='';").append("\n");
		buffer.append(
				"SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;")
				.append("\n");
		buffer.append(
				"SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';")
				.append("\n\n");

		buffer.append(getDatabaseDropStatement());
		buffer.append(getDatabaseCreateStatement());
		buffer.append("USE `").append(getDatabaseName()).append("`;\n")
				.append("\n");

		List<Table> tables = getTables();

		if (null != tables) {
			Iterator<Table> tableItr = tables.iterator();
			while (tableItr.hasNext()) {
				Table table = (Table) tableItr.next();
				String type = table.getType().trim();
				if (type.equals(Table.BASE_TABLE)) {
					List<Table> parentTables = getParentTables(table.getName());
					buffer.append(exportTable(parentTables, withData));
					if (!table.isEvaluated()) {
						buffer.append(getTableStructure(table.getName()));
						buffer.append(getTableDropStatement(table.getName()));
						buffer.append(getTableCreateStatement(table.getName()));
						if (withData) {
							buffer.append("\n");
							buffer.append(getInsertStatements(table.getName()));
						}
						buffer.append("\n");
						table.setEvaluated(true);
					}
				} else {
					buffer.append(getTableStructure(table.getName()));
					buffer.append(getViewDropStatement(table.getName()));
					buffer.append(getViewCreateStatement(table.getName()));
				}
			}
		}

		List<Procedure> procedures = getStoredProcedures();
		if (null != procedures) {
			buffer.append("\n\n")
					.append("/********************* Stored Procedures *********************/")
					.append("\n\n");
			Iterator<Procedure> procedureItr = procedures.iterator();
			while (procedureItr.hasNext()) {
				Procedure procedure = procedureItr.next();
				buffer.append(getStoredProcedureDropStatement(procedure
						.getName()));
				buffer.append(getStoredProcedureCreateStatement(procedure
						.getName()));
				buffer.append("\n");
			}
		}

		List<Function> functions = getFunctions();
		if (null != functions) {
			buffer.append("\n")
                    .append("/********************* Functions *********************/")
                    .append("\n\n");
            Iterator<Function> functionItr = functions.iterator();
            while (functionItr.hasNext()) {
                Function function = functionItr.next();
                buffer.append(getFunctionDropStatement(function.getName()));
                buffer.append(getFunctionCreateStatement(function.getName()));
                buffer.append("\n");
            }
		}

		List<Trigger> triggers = getTriggers();
		if (null != triggers) {
			buffer.append("\n")
					.append("/********************* Triggers *********************/")
					.append("\n\n");
			Iterator<Trigger> triggerItr = triggers.iterator();
			while (triggerItr.hasNext()) {
				Trigger trigger = triggerItr.next();
				buffer.append(getTriggerDropStatement(trigger.getName()));
				buffer.append(getTriggerCreateStatement(trigger.getName()));
			}
		}

		buffer.append("\n\n").append("SET SQL_MODE=@OLD_SQL_MODE;")
				.append("\n");
		buffer.append("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;")
				.append("\n");
		return buffer.toString();
	}

	public void close() throws SQLException {
		if (null != this.connection) {
			this.connection.close();
		}
	}

	public List<Table> getTables() throws SQLException {
		Statement statement = null;
		statement = this.connection.createStatement();

		if (statement != null) {
			ResultSet resultSet = statement.executeQuery("SHOW FULL TABLES");
			if (resultSet != null) {
				List<Table> tableColl = new ArrayList<Table>();
				while (resultSet.next()) {
					String tableName = resultSet.getString("Tables_in_"
							+ this.dbName);
					String tableType = resultSet.getString("Table_type");
					Table table = new MySqlTable(tableName, tableType);
					this.nameTableMap.put(table.getName(), table);
					tableColl.add(table);
				}
				return tableColl.size() > 0 ? tableColl : null;
			}
		}
		return null;
	}

	public boolean isOpen() throws SQLException {
		return this.connection != null && !this.connection.isClosed();
	}

	public String getTableDropStatement(String table) {
		return "DROP TABLE IF EXISTS `" + table + "`;\n";
	}

	public String getInsertStatements(String table) throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement.executeQuery("SELECT * FROM "
					+ table);
			if (resultSet != null) {
				StringBuffer buffer = new StringBuffer();
				while (resultSet.next()) {
					ResultSetMetaData resultSetMetaData = null;
					resultSetMetaData = resultSet.getMetaData();
					if (resultSetMetaData != null) {
						int columnCount = resultSetMetaData.getColumnCount();
						buffer.append("INSERT INTO ").append(table).append("(");
						for (int i = 1; i <= columnCount; i++) {
							buffer.append(resultSetMetaData.getColumnLabel(i));
							if (i < columnCount) {
								buffer.append(", ");
							} else {
								buffer.append(") VALUES (");
							}
						}
						for (int i = 1; i <= columnCount; i++) {
							Object type = resultSetMetaData
									.getColumnClassName(i);
							Object colValue = resultSet
									.getObject(resultSetMetaData
											.getColumnName(i));
							if (type.getClass().getName()
									.equals(String.class.getName())
									|| type.getClass().getName()
											.equals(Timestamp.class.getName())) {
								buffer.append("'").append(colValue.toString())
										.append("'");
							} else {
								buffer.append(colValue.toString());
							}
							if (i < columnCount) {
								buffer.append(", ");
							} else {
								buffer.append(");\n");
							}
						}
					}
				}
				return buffer.toString();
			}
		}
		return "";
	}

	public String getTableCreateStatement(String table) throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement.executeQuery("SHOW CREATE TABLE "
					+ table);
			if (resultSet != null) {
				if (resultSet.next()) {
					return resultSet.getString("Create Table") + ";\n";
				}
			}
		}
		return null;
	}

	public String getDatabaseName() {
		return this.dbName;
	}

	public String getDatabaseCreateStatement() {
		return "CREATE DATABASE `" + this.dbName + "`;\n";
	}

	public String getDatabaseDropStatement() {
		return "DROP DATABASE IF EXISTS `" + this.dbName + "`;\n";
	}

	public String getTableStructure(String table) throws SQLException {
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("DESC " + table);
		TableCatalog tableCatalog = new MySqlTableAsSqlComment();
		while (resultSet.next()) {
			TableRow tableRow = new MySqlTableRowAsSqlComment();
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Field")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Type")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Null")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Key")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Default")));
			tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
					.getString("Extra")));
			tableCatalog.addRow(tableRow);
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("/*\n").append(tableCatalog.getHeader())
				.append(((Formatter) tableCatalog).asFormattedString())
				.append(tableCatalog.getFooter()).append("*/").append("\n");

		return buffer.toString();
	}

	public List<Table> getParentTables(String table) throws SQLException {
		List<Table> parentTables = new ArrayList<Table>();
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement
					.executeQuery("SELECT DISTINCT REFERENCED_TABLE_NAME, TABLE_TYPE FROM information_schema.KEY_COLUMN_USAGE AS a, information_schema.TABLES as b  WHERE a.table_schema = '"
							+ this.dbName
							+ "' AND a.table_name = '"
							+ table
							+ "'AND a.CONSTRAINT_NAME != 'PRIMARY' AND b.TABLE_TYPE = 'BASE TABLE';");
			if (resultSet != null) {
				while (resultSet.next()) {
					String name = resultSet.getString("REFERENCED_TABLE_NAME");
					Table table2 = this.nameTableMap.get(name);
					if (null == table2) {
						table2 = new MySqlTable();
						table2.setName(name);
						table2.setType(resultSet.getString("TABLE_TYPE"));
						this.nameTableMap.put(name, table2);
					}
					parentTables.add(table2);
				}
			}
		}
		return parentTables.size() > 0 ? parentTables : null;
	}

	public String getViewCreateStatement(String view) throws SQLException {
		Statement statement = this.connection.createStatement();
        if (null != statement) {
            ResultSet resultSet = statement.executeQuery("SHOW CREATE VIEW "
                    + view);
            if (resultSet != null) {
                if (resultSet.next()) {

                    String viewCreate = resultSet.getString("Create View");
                    Pattern pattern = Pattern.compile("view",
                            Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(viewCreate);
                    matcher.find();
                    String part = viewCreate
                            .substring(matcher.end(), viewCreate.length())
                            .replace("`", "").trim();
                    return "CREATE VIEW " + part + ";\n";
                }
            }
        }
        return null;
	}

	public String getViewDropStatement(String view) {
		return "DROP VIEW IF EXISTS `" + view + "`;\n";
	}

	public List<Procedure> getStoredProcedures() throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement
					.executeQuery(String.format("SHOW PROCEDURE STATUS WHERE DB = '%s'", this.getDatabaseName()));
			if (null != resultSet) {
				List<Procedure> procedures = new ArrayList<Procedure>();

				while (resultSet.next()) {
					String name = resultSet.getString("Name");
					String type = resultSet.getString("Type");
					String definer = resultSet.getString("Definer");
					String modified = resultSet.getString("Modified");
					String created = resultSet.getString("Created");
					String securityType = resultSet.getString("Security_type");
					String comment = resultSet.getString("Comment");

					Procedure procedure = new MySqlProcedure();
					procedure.setName(name);
					procedure.setType(type);
					procedure.setDefiner(definer);
					procedure.setModifiedDate(modified);
					procedure.setCreatedDate(created);
					procedure.setSecurityType(securityType);
					procedure.setComment(comment);

					procedures.add(procedure);
				}

				return procedures;
			}
		}
		return null;
	}

	public String getStoredProcedureDropStatement(String storedProcedure) {
		return "DROP PROCEDURE IF EXISTS `" + storedProcedure + "`;\n";
	}

	public String getStoredProcedureCreateStatement(String storedProcedure)
			throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement
					.executeQuery("SHOW CREATE PROCEDURE " + storedProcedure);
			if (null != resultSet) {
				if (resultSet.next()) {
					StringBuffer buffer = new StringBuffer();
					buffer.append("DELIMITER $$").append("\n")
							.append(resultSet.getString("Create Procedure"))
							.append("$$\n").append("DELIMITER ;").append("\n");
					return buffer.toString();
				}
			}
		}
		return null;
	}

	public List<Function> getFunctions() throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement
					.executeQuery(String.format("SHOW FUNCTION STATUS WHERE DB = '%s'", this.getDatabaseName()));
			if (null != resultSet) {
				List<Function> functions = new ArrayList<Function>();

				while (resultSet.next()) {
					String name = resultSet.getString("Name");
					String type = resultSet.getString("Type");
					String definer = resultSet.getString("Definer");
					String modified = resultSet.getString("Modified");
					String created = resultSet.getString("Created");
					String securityType = resultSet.getString("Security_type");
					String comment = resultSet.getString("Comment");

					Function function = new MySqlFunction();
					function.setName(name);
					function.setType(type);
					function.setDefiner(definer);
					function.setModifiedDate(modified);
					function.setCreatedDate(created);
					function.setSecurityType(securityType);
					function.setComment(comment);

					functions.add(function);
				}

				return functions;
			}
		}
		return null;
	}

	public String getFunctionDropStatement(String function) {
		return "DROP FUNCTION IF EXISTS `" + function + "`;\n";
	}

	public String getFunctionCreateStatement(String function)
			throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement
					.executeQuery("SHOW CREATE FUNCTION " + function);
			if (null != resultSet) {
				if (resultSet.next()) {
					StringBuffer buffer = new StringBuffer();
					buffer.append("DELIMITER $$").append("\n")
							.append(resultSet.getString("Create Function"))
							.append("$$\n").append("DELIMITER ;").append("\n");
					return buffer.toString();
				}
			}
		}
		return null;
	}

	public String getTriggerDropStatement(String trigger) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELIMITER $$").append("\n")
				.append("DROP TRIGGER IF EXISTS `" + trigger + "`$$")
				.append("\n").append("DELIMITER ;").append("\n");
		return buffer.toString();
	}

	public String getTriggerCreateStatement(String trigger) throws SQLException {
		StringBuffer buffer = new StringBuffer();
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement.executeQuery("SHOW TRIGGERS");
			if (null != resultSet) {
				while (resultSet.next()) {
					String name = resultSet.getString("Trigger");
					if (trigger.equals(name)) {
						buffer.append("DELIMITER $$").append("\n")
								.append("CREATE TRIGGER").append(" `");
						buffer.append(name).append("` ")
								.append(resultSet.getString("Timing"))
								.append(" ")
								.append(resultSet.getString("Event"))
								.append(" ON `")
								.append(resultSet.getString("Table"))
								.append("`\n").append("FOR EACH ROW")
								.append("\n")
								.append(resultSet.getString("Statement"))
								.append("$$").append("\n")
								.append("DELIMITER ;").append("\n");
					}
				}
			}
		}
		return buffer.toString();
	}

	public List<Trigger> getTriggers() throws SQLException {
		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement.executeQuery("SHOW TRIGGERS");
			if (null != resultSet) {
				List<Trigger> triggers = new ArrayList<Trigger>();

				while (resultSet.next()) {
					String name = resultSet.getString("Trigger");
					String event = resultSet.getString("Event");
					String table = resultSet.getString("Table");
					String stmt = resultSet.getString("Statement");
					String timing = resultSet.getString("Timing");
					String created = resultSet.getString("Created");
					String sqlMode = resultSet.getString("sql_mode");
					String definer = resultSet.getString("Definer");

					Trigger trigger = new MySqlTrigger();
					trigger.setName(name);
					trigger.setEvent(event);
					trigger.setTable(table);
					trigger.setStatement(stmt);
					trigger.setCreated(created);
					trigger.setTiming(timing);
					trigger.setSqlMode(sqlMode);
					trigger.setDefiner(definer);

					triggers.add(trigger);
				}
				return triggers;
			}
		}
		return null;
	}

	public List<KeyColumnUsage> getKeyColumnUsage(String table)
			throws SQLException {

		Statement statement = this.connection.createStatement();
		if (null != statement) {
			ResultSet resultSet = statement
					.executeQuery("SELECT TABLE_NAME, CONSTRAINT_NAME, COLUMN_NAME, REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE table_schema = '"
							+ this.dbName
							+ "' AND table_name = '"
							+ table
							+ "'");
			if (null != resultSet) {
				List<KeyColumnUsage> columnUsages = new ArrayList<KeyColumnUsage>();
				while (resultSet.next()) {
					String tableName = resultSet.getString("TABLE_NAME");
					String constraintName = resultSet
							.getString("CONSTRAINT_NAME");
					String columnName = resultSet.getString("COLUMN_NAME");
					String refTableName = resultSet
							.getString("REFERENCED_TABLE_NAME");
					String refColumnName = resultSet
							.getString("REFERENCED_COLUMN_NAME");

					KeyColumnUsage columnUsage = new MySqlKeyColumnUsage();

					columnUsage.setTableName(tableName);
					columnUsage.setConstraintName(constraintName);
					columnUsage.setColumnName(columnName);
					columnUsage.setReferencedTableName(refTableName);
					columnUsage.setReferencedColumnName(refColumnName);

					columnUsages.add(columnUsage);
				}

				return columnUsages.size() > 0 ? columnUsages : null;
			}
		}

		return null;
	}
}
