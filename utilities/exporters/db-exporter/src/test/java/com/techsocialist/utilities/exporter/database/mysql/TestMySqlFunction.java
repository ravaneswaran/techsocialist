package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Function;
import com.techsocialist.utilities.exporter.database.Procedure;
import junit.framework.TestCase;

public class TestMySqlFunction extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testMySqlFunctionInst(){
		MySqlFunction function = new MySqlFunction();
		assertTrue(function instanceof Function);
		assertTrue(function instanceof Procedure);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
