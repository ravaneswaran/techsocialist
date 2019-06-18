package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySqlDatabaseAsOracleDatabase implements Database {
	
	protected Connection connection;

	protected String dbName;

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

	public void close() throws SQLException {
		// TODO Auto-generated method stub

	}

	public List<Table> getTables() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOpen() throws SQLException {
		return this.connection != null && !this.connection.isClosed();
	}

	public String getTableDropStatement(String table) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInsertStatements(String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTableCreateStatement(String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDatabaseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDatabaseCreateStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDatabaseDropStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public String exportAsSql(boolean withData) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Table> getParentTables(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTableStructure(String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getViewCreateStatement(String view) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getViewDropStatement(String view) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Procedure> getStoredProcedures() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStoredProcedureDropStatement(String storedProcedure) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStoredProcedureCreateStatement(String storedProcedure)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Function> getFunctions() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFunctionDropStatement(String function) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFunctionCreateStatement(String function)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTriggerDropStatement(String trigger) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTriggerCreateStatement(String trigger) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Trigger> getTriggers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<KeyColumnUsage> getKeyColumnUsage(String table)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
