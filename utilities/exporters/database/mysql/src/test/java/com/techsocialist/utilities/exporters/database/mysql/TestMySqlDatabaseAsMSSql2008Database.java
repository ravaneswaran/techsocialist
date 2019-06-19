package com.techsocialist.utilities.exporters.database.mysql;

import com.techsocialist.utilities.exporters.database.api.Database;

public class TestMySqlDatabaseAsMSSql2008Database extends TestMySqlDatabaseAsMSSql2005Database{
	
	public void testMySqlDatabaseAsMSSqlDatabaseInst() {
		MySqlDatabaseAsMSSql2008Database inst = new MySqlDatabaseAsMSSql2008Database();
		assertTrue(inst instanceof Database);
	}

}
