package com.techsocialist.utilities.exporter.database.mysql;

import com.congruent.db.Trigger;
import junit.framework.TestCase;

public class TestMySqlTrigger extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testMySqlTriggerInst(){
		MySqlTrigger trigger = new MySqlTrigger();
		assertTrue(trigger instanceof Trigger);
	}
	
	public void testSetGetName(){
		Trigger trigger = new MySqlTrigger();
		String name = "";
		trigger.setName(name);
		String name2 = trigger.getName();
		assertEquals(name, name2);
	}
	
	public void testSetGetEvent(){
		Trigger trigger = new MySqlTrigger();
		String event = "";
		trigger.setEvent(event);
		String event2 = trigger.getEvent();
		assertEquals(event, event2);
	}
	
	public void testSetGetTable(){
		Trigger trigger = new MySqlTrigger();
		String table = "";
		trigger.setTable(table);
		String table2 = trigger.getTable();
		assertEquals(table, table2);
	}
	
	public void testSetGetStatement(){
		Trigger trigger = new MySqlTrigger();
		String statement = "";
		trigger.setStatement(statement);
		String statement2 = trigger.getStatement();
		assertEquals(statement, statement2);
	}
	
	public void testSetGetTiming(){
		Trigger trigger = new MySqlTrigger();
		String timing = "";
		trigger.setTiming(timing);
		String timing2 = trigger.getTiming();
		assertEquals(timing, timing2);
	}
	
	public void testSetGetCreated(){
		Trigger trigger = new MySqlTrigger();
		String created = "";
		trigger.setCreated(created);
		String created2 = trigger.getCreated();
		assertEquals(created, created2);
	}
	
	public void testSetGetSqlMode(){
		Trigger trigger = new MySqlTrigger();
		String sqlMode = "";
		trigger.setSqlMode(sqlMode);
		String sqlMode2 = trigger.getSqlMode();
		assertEquals(sqlMode, sqlMode2);
	}
	
	public void testSetGetDefiner(){
		Trigger trigger = new MySqlTrigger();
		String definer = "";
		trigger.setDefiner(definer);
		String definer2 = trigger.getDefiner();
		assertEquals(definer, definer2);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
