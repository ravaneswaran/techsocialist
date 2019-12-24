package com.techsocialist.utilities.exporters.database.exporter.direct;

import com.techsocialist.utilities.exporters.database.api.ExIm;
import com.techsocialist.utilities.exporters.database.mysql.direct.MySql;
import junit.framework.TestCase;

public class TestMySql extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMySqlDataBaseInst() {
		MySql exporter = new MySql();
		assertTrue(exporter instanceof ExIm);
	}

	public void testSetGetHost() {
		ExIm exporter = new MySql();
		String host = "";
		exporter.setHost(host);
		String host2 = exporter.getHost();

		assertEquals(host, host2);
	}

	public void testSetGetDatabaseName() {
        ExIm exporter = new MySql();
		String databaseName = "";
		exporter.setDatabaseName(databaseName);
		String databaseName2 = exporter.getDatabaseName();

		assertEquals(databaseName, databaseName2);
	}

	public void testSetGetUsername() {
        ExIm exporter = new MySql();
		String username = "";
		exporter.setUsername(username);
		String username2 = exporter.getUsername();

		assertEquals(username, username2);
	}

	public void testSetGetPassword() {
        ExIm exporter = new MySql();
		String password = "";
		exporter.setPassword(password);
		String password2 = exporter.getPassword();

		assertEquals(password, password2);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
