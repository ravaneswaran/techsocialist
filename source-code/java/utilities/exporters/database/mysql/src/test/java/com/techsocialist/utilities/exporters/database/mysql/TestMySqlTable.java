package com.techsocialist.utilities.exporters.database.mysql;

import com.techsocialist.utilities.exporters.database.api.Table;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestMySqlTable extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMySqlTableInst() {
		MySqlTable inst = new MySqlTable();
		assertTrue(inst instanceof Table);
	}
	
	public void testSettersAndGetters(){
		Table table = new MySqlTable();
		String name = "";
		String type = "";
		table.setName(name);
		table.setType(type);
		name = table.getName();
		type = table.getType();
		assertEquals("", name);
		assertEquals("", type);
	}
	
	public void testSettersAndGetters2(){
		Table table = new MySqlTable("","");
		String name = table.getName();
		String type = table.getType();
		assertEquals("", name);
		assertEquals("", type);
	}
	
	public void testSetAndGetParentTables(){
		Table table = new MySqlTable("","");
		List<Table> tables = new ArrayList<Table>();
		table.setParentTables(tables);
		assertNotNull(tables);
		tables = table.getParentTables();
		assertNotNull(tables);
	}
	
	public void testSetAndGetEvaluated(){
		Table table = new MySqlTable("","");
		boolean evaluated = true;
		table.setEvaluated(evaluated);
		boolean eval = table.isEvaluated();
		assertTrue(eval);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
