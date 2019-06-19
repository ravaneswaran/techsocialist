package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Database;
import junit.framework.TestCase;

public class TestMySqlDatabaseAsMSSqlDatabase extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMySqlDatabaseAsMSSqlDatabaseInst() {
		MySqlDatabaseAsMSSqlDatabase inst = new MySqlDatabaseAsMSSqlDatabase();
		assertTrue(inst instanceof Database);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
