package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Database;
import junit.framework.TestCase;

import java.sql.SQLException;

public class TestMySqlDatabaseAsOracleDatabase extends TestCase{

	private MySqlDatabaseAsOracleDatabase db;

	private String url = "jdbc:mysql://localhost:3306/tech_socialist";

	private String user = "root";

	private String password = "admin";
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.db = new MySqlDatabaseAsOracleDatabase();
	}
	
	public void testMySqlDatabaseAsOracleDatabaseInst(){
		MySqlDatabaseAsOracleDatabase inst = new MySqlDatabaseAsOracleDatabase();
		assertTrue(inst instanceof Database);
	}
	
	public void testOpenMethod() throws SQLException, ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		assertTrue(database.isOpen());
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		
	}

}
