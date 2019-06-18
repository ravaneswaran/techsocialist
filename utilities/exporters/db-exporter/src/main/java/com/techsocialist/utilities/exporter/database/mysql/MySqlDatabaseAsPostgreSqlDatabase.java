package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.*;
import com.techsocialist.utilities.exporter.database.mysql.factory.MySqlDataTypeMapperFactory;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableCellAsSqlComment;
import com.techsocialist.utilities.exporter.database.mysql.formatter.comment.MySqlTableRowAsSqlComment;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlDatabaseAsPostgreSqlDatabase extends MySqlDatabase {

    public MySqlDatabaseAsPostgreSqlDatabase() {

    }

    @Override
    public String getTableDropStatement(String table) {
        return "DROP TABLE IF EXISTS " + table;
    }

    @Override
    public String getDatabaseDropStatement() {
        return "DROP DATABASE IF EXISTS " + this.dbName;
    }

    @Override
    public String getViewDropStatement(String view) {
        return "DROP VIEW " + view;
    }

    @Override
    public String getTableCreateStatement(String table) throws SQLException {
        StringBuffer buffer = new StringBuffer();

        List<KeyColumnUsage> columnUsages = getKeyColumnUsage(table);

        DataTypeMapper mapper = MySqlDataTypeMapperFactory.getInstance(Database.MYSQL_AS_POSTGRES);
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
                _null = _null.equals("NO") ? "NOT NULL" : _null.equals("") ? ""
                        : "NULL";

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
                                        /*.append("CONSTRAINT")
                                       .append(" ")
                                       .append(keyColumnUsage.getConstraintName())
                                       .append(" ")*/
                                .append("FOREIGN KEY")
                                .append(" (")
                                .append(keyColumnUsage.getColumnName())
                                .append(") ")
                                .append("REFERENCE")
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

            String returnVal = buffer.toString().replace(",\n)", "\n)");

            return returnVal;
        }

        return null;
    }

    @Override
    public String getDatabaseCreateStatement() {
        return "CREATE DATABASE " + this.dbName;
    }

    @Override
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
                    return "CREATE VIEW " + part;
                }
            }
        }
        return null;
    }

    @Override
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

    @Override
    protected String exportTable(List<Table> parentTables, boolean withData)
            throws SQLException {
        final String NEW_LINE = "\n";
        final String DELIMITER = ";";
        StringBuffer buffer = new StringBuffer();
        if (null != parentTables) {
            Iterator<Table> tableItr = parentTables.iterator();
            while (tableItr.hasNext()) {
                Table table = (Table) tableItr.next();
                if (!table.isEvaluated()) {
                    buffer.append(getTableStructure(table.getName()));
                    buffer.append(getTableDropStatement(table.getName()));
                    buffer.append(DELIMITER).append(NEW_LINE);
                    buffer.append(getTableCreateStatement(table.getName()));
                    buffer.append(DELIMITER).append(NEW_LINE);
                    if (withData) {
                        buffer.append(getInsertStatements(table.getName()));
                    }
                    table.setEvaluated(true);
                }
            }
        }
        return buffer.toString();
    }

    @Override
    public String exportAsSql(boolean withData) throws SQLException {
        final String NEW_LINE = "\n";
        final String DELIMITER = ";";

        StringBuffer buffer = new StringBuffer();

        /*buffer.append("SET ANSI_NULLS ON").append("\n");
        buffer.append("GO").append("\n");
        buffer.append("SET QUOTED_IDENTIFIER ON").append("\n");
        buffer.append("GO").append("\n\n");*/

        buffer.append(getDatabaseDropStatement());
        buffer.append(DELIMITER).append(NEW_LINE);
        buffer.append(getDatabaseCreateStatement());
        buffer.append(DELIMITER).append(NEW_LINE);

        /*buffer.append("USE").append(" [").append(this.dbName).append("] ")
                .append("\n");
        buffer.append("GO").append("\n\n");*/

        List<Table> tables = getTables();
        if (null != tables) {
            Iterator<Table> tableItr = tables.iterator();
            while (tableItr.hasNext()) {
                Table table = (Table) tableItr.next();
                if (!table.isEvaluated()) {
                    if (table.getType().equals(Table.BASE_TABLE)) {
                        List<Table> parentTables = getParentTables(table
                                .getName());
                        buffer.append(exportTable(parentTables, withData));
                        buffer.append(getTableStructure(table.getName()));
                        buffer.append(getTableDropStatement(table.getName()));
                        buffer.append(DELIMITER).append(NEW_LINE);
                        buffer.append(getTableCreateStatement(table.getName()));
                        buffer.append(DELIMITER).append(NEW_LINE);
                        buffer.append(getInsertStatements(table.getName()));
                        buffer.append(NEW_LINE);
                    }
                    table.setEvaluated(true);
                }
            }
        }

        List<Table> views = getTables();
        if (null != tables) {
            Iterator<Table> viewsItr = views.iterator();
            while (viewsItr.hasNext()) {
                Table table = viewsItr.next();
                if (table.getType().equals(Table.VIEW)) {
                    buffer.append(getTableStructure(table.getName()));
                    buffer.append(getViewDropStatement(table.getName()));
                    buffer.append(DELIMITER).append(NEW_LINE);
                    buffer.append(getViewCreateStatement(table.getName()));
                    buffer.append(DELIMITER).append(NEW_LINE);
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
        }

        List<Function> functions = getFunctions();
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
        }

        List<Trigger> triggers = getTriggers();
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

        return buffer.toString();
    }

    @Override
    public String getTableStructure(String table) throws SQLException {
        Statement statement = this.connection.createStatement();
        DataTypeMapper mapper = MySqlDataTypeMapperFactory.getInstance(Database.MYSQL_AS_POSTGRES);
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
        buffer.append("\n").append(tableCatalog.getHeader())
                .append(((Formatter) tableCatalog).asFormattedString())
                .append(tableCatalog.getFooter()).append("").append("\n");

        return buffer.toString();
    }
}
