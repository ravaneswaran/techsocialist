package com.techsocialist.utilities.exporter.database.mysql;

import junit.framework.TestCase;

public class TestMySqlKeyColumnUsage extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testMySqlKeyColumnUsageInst(){
		MySqlKeyColumnUsage inst = new MySqlKeyColumnUsage();
		assertTrue(inst instanceof KeyColumnUsage);
	}
	
	public void testSetGetTableName(){
		KeyColumnUsage inst = new MySqlKeyColumnUsage();
		String tableName = "";
		inst.setTableName(tableName);
		String tableName2 = inst.getTableName();
		assertEquals(tableName, tableName2);
	}
	
	public void testSetGetConstraintName(){
		KeyColumnUsage inst = new MySqlKeyColumnUsage();
		String constraintName = "";
		inst.setConstraintName(constraintName);
		String constraintName2 = inst.getConstraintName();
		assertEquals(constraintName, constraintName2);
	}
	
	public void testSetGetColumnName(){
		KeyColumnUsage inst = new MySqlKeyColumnUsage();
		String columnName = "";
		inst.setColumnName(columnName);
		String columnName2 = inst.getColumnName();
		assertEquals(columnName, columnName2);
	}
	
	public void testSetGetReferencedTableName(){
		KeyColumnUsage inst = new MySqlKeyColumnUsage();
		String referencedTableName = "";
		inst.setReferencedTableName(referencedTableName);
		String referencedTableName2 = inst.getReferencedTableName();
		assertEquals(referencedTableName, referencedTableName2);
	}
	
	public void testSetGetReferencedColumnName(){
		KeyColumnUsage inst = new MySqlKeyColumnUsage();
		String referencedColumnName = "";
		inst.setReferencedColumnName(referencedColumnName);
		String referencedColumnName2 = inst.getReferencedColumnName();
		assertEquals(referencedColumnName, referencedColumnName2);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
