package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.*;
import com.techsocialist.utilities.exporter.database.mysql.factory.MySqlDataTypeMapperFactory;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableCellAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableRowAsSqlComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MySqlDatabaseAsSQLiteDatabase extends MySqlDatabase {

    public String exportAsSql(boolean withData) throws SQLException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("BEGIN TRANSACTION;").append("\n\n");
        /*buffer.append(getDatabaseDropStatement());
        buffer.append(getDatabaseCreateStatement());
        buffer.append("USE `").append(getDatabaseName()).append("`;\n")
                .append("\n");*/

        List<Table> tables = getTables();

        if (null != tables) {
            Iterator<Table> tableItr = tables.iterator();
            while (tableItr.hasNext()) {
                Table table = tableItr.next();
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

        /*List<Procedure> procedures = getStoredProcedures();
        if (null != procedures) {
            buffer.append("\n\n")
                    .append("*//********************* Stored Procedures *********************//*")
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
        }*/

        /*List<Function> functions = getFunctions();
        if (null != functions) {
            buffer.append("\n")
                    .append("*//********************* Functions *********************//*")
                    .append("\n\n");
            Iterator<Function> functionItr = functions.iterator();
            while (functionItr.hasNext()) {
                Function function = functionItr.next();
                buffer.append(getFunctionDropStatement(function.getName()));
                buffer.append(getFunctionCreateStatement(function.getName()));
                buffer.append("\n");
            }
        }*/

        /*List<Trigger> triggers = getTriggers();
        if (null != triggers) {
            buffer.append("\n")
                    .append("*//********************* Triggers *********************//*")
                    .append("\n\n");
            Iterator<Trigger> triggerItr = triggers.iterator();
            while (triggerItr.hasNext()) {
                Trigger trigger = triggerItr.next();
                buffer.append(getTriggerDropStatement(trigger.getName()));
                buffer.append(getTriggerCreateStatement(trigger.getName()));
            }
        }*/

        buffer.append("\n\n").append("COMMIT;");

        return buffer.toString();
    }

    @Override
    public String getViewDropStatement(String view) {
        return "DROP VIEW IF EXISTS " + view + ";\n";
    }

    @Override
    public String getTableDropStatement(String table) {
        return "DROP TABLE IF EXISTS " + table + ";\n";
    }

    @Override
    public String getTableCreateStatement(String table) throws SQLException {
        StringBuffer buffer = new StringBuffer();

        List<KeyColumnUsage> columnUsages = getKeyColumnUsage(table);

        DataTypeMapper mapper = MySqlDataTypeMapperFactory.getInstance(Database.MYSQL_AS_SQL_LITE);
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("DESC " + table);
        if (null != resultSet) {
            buffer.append("CREATE TABLE ").append(table).append("(")
                    .append("\n");
            while (resultSet.next()) {
                buffer.append("\t");
                String field = resultSet.getString("Field");
                String type = resultSet.getString("Type");
                String _null = resultSet.getString("Null");
                String key = resultSet.getString("Key");
                String _default = resultSet.getString("Default");
                String extra = resultSet.getString("Extra");
                _null = _null.equals("NO") ? "not null" : _null.equals("") ? ""
                        : "null";

                buffer.append(field).append(" ")
                        .append(mapper.getToDataType(type)).append(" ");
                buffer.append(_null).append(",").append("\n");
            }

            StringBuffer primaryKeyBuffer = new StringBuffer();
            StringBuffer foreignKeyBuffer = new StringBuffer();

            if (null != columnUsages) {
                for (KeyColumnUsage keyColumnUsage : columnUsages) {
                    String constraintName = keyColumnUsage.getConstraintName();
                    if (constraintName.equals("PRIMARY")
                            || constraintName.equals("primary")) {
                        primaryKeyBuffer.append("\t").append("PRIMARY KEY")
                                .append(" (")
                                .append(keyColumnUsage.getColumnName())
                                .append("),\n");
                    } else {
                        foreignKeyBuffer
                                .append("\t")
                                .append("FOREIGN KEY")
                                .append(" (")
                                .append(keyColumnUsage.getColumnName())
                                .append(") ")
                                .append("REFERENCES")
                                .append(" ")
                                .append(keyColumnUsage.getReferencedTableName())
                                .append(" (")
                                .append(keyColumnUsage
                                        .getReferencedColumnName())
                                .append("),\n");
                    }
                }
            }
            buffer.append(primaryKeyBuffer.toString());
            buffer.append(foreignKeyBuffer.toString());

            buffer.append(")");

            String returnVal = buffer.toString().replace(",\n)", "\n);\n");

            return returnVal;

        }

        return null;
    }

    @Override
    public String getTableStructure(String table) throws SQLException {
        Statement statement = this.connection.createStatement();
        DataTypeMapper mapper = MySqlDataTypeMapperFactory.getInstance(Database.MYSQL_AS_SQL_LITE);
        ResultSet resultSet = statement.executeQuery("DESC " + table);
        TableCatalog tableCatalog = new MySqlTableAsSqlComment();
        while (resultSet.next()) {
            TableRow tableRow = new MySqlTableRowAsSqlComment();
            tableRow.addCell(new MySqlTableCellAsSqlComment(resultSet
                    .getString("Field")));
            tableRow.addCell(new MySqlTableCellAsSqlComment(mapper
                    .getToDataType(resultSet.getString("Type"))));
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

    public List<Procedure> getStoredProcedures() throws SQLException {
        return null;
    }

    public String getStoredProcedureDropStatement(String storedProcedure) {
        return null;
    }

    public String getStoredProcedureCreateStatement(String storedProcedure)
            throws SQLException {
        return null;
    }

    public List<Function> getFunctions() throws SQLException {
        return null;
    }

    public String getFunctionDropStatement(String function) {
        return null;
    }

    public String getFunctionCreateStatement(String function)
            throws SQLException {
        return null;
    }
}
