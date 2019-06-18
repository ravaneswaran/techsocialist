package com.techsocialist.utilities.exporter.database;

import java.sql.SQLException;
import java.util.List;

public interface Database {

    public int MYSQL = 1;

    public int MYSQL_AS_MSSQL_2005 = 2;

    public int MYSQL_AS_MSSQL_2008 = 4;

    public int MYSQL_AS_ORACLE = 8;

    public int MYSQL_AS_SQL_LITE = 16;

    public int MYSQL_AS_POSTGRES = 32;

    public int MYSQL_AS_INGRES = 64;

    public void open(String url, String user, String password)
            throws SQLException, ClassNotFoundException;

    public void open(String url, String port, String dbName, String user,
                     String password) throws SQLException, ClassNotFoundException;

    public void close() throws SQLException;

    public List<Table> getTables() throws SQLException;

    public boolean isOpen() throws SQLException;

    public String getTableDropStatement(String table);

    public String getInsertStatements(String table) throws SQLException;

    public String getTableCreateStatement(String table) throws SQLException;

    public String getDatabaseName();

    public String getDatabaseCreateStatement();

    public String getDatabaseDropStatement();

    public String exportAsSql(boolean withData) throws SQLException;

    public List<Table> getParentTables(String table) throws SQLException;

    public String getTableStructure(String table) throws SQLException;

    public String getViewCreateStatement(String view) throws SQLException;

    public String getViewDropStatement(String view);

    public List<Procedure> getStoredProcedures() throws SQLException;

    public String getStoredProcedureDropStatement(String storedProcedure);

    public String getStoredProcedureCreateStatement(String storedProcedure)
            throws SQLException;

    public List<Function> getFunctions() throws SQLException;

    public String getFunctionDropStatement(String function);

    public String getFunctionCreateStatement(String function)
            throws SQLException;

    public String getTriggerDropStatement(String trigger);

    public String getTriggerCreateStatement(String trigger) throws SQLException;

    public List<Trigger> getTriggers() throws SQLException;

    public List<KeyColumnUsage> getKeyColumnUsage(String table) throws SQLException;

}
