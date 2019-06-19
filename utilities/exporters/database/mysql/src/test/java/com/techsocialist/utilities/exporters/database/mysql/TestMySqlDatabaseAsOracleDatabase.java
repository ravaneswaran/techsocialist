package com.techsocialist.utilities.exporters.database.mysql;

import com.techsocialist.utilities.exporters.database.api.Database;
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
		this.db.open(this.url, this.user, this.password);
		assertTrue(this.db.isOpen());
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		this.db.close();
		super.tearDown();
	}

}
