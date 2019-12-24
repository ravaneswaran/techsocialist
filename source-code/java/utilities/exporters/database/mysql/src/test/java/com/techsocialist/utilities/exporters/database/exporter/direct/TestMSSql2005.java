package com.techsocialist.utilities.exporters.database.exporter.direct;

import com.techsocialist.utilities.exporters.database.api.ExIm;
import com.techsocialist.utilities.exporters.database.mysql.direct.MSSql2005;
import junit.framework.TestCase;

public class TestMSSql2005 extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMSSqlDataBaseInst() {
		MSSql2005 database = new MSSql2005();
		assertTrue(database instanceof ExIm);
	}
	
	public void testSetGetHost(){
		ExIm database = new MSSql2005();
        String host = "";
        database.setHost(host);
        String host2 = database.getHost();
		
		assertEquals(host, host2);
	}
	
	public void testSetGetDatabaseName(){
        ExIm database = new MSSql2005();
		String databaseName = "";
		database.setDatabaseName(databaseName);
		String databaseName2 = database.getDatabaseName();
		
		assertEquals(databaseName, databaseName2);
	}
	
	public void testSetGetUsername(){
        ExIm database = new MSSql2005();
		String username = "";
		database.setUsername(username);
		String username2 = database.getUsername();
		
		assertEquals(username, username2);
	}
	
	public void testSetGetPassword(){
        ExIm database = new MSSql2005();
		String password = "";
		database.setPassword(password);
		String password2 = database.getPassword();
		
		assertEquals(password, password2);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
