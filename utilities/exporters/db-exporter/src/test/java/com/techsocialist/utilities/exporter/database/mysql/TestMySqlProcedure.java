package com.techsocialist.utilities.exporter.database.mysql;

import com.congruent.db.Procedure;
import junit.framework.TestCase;

public class TestMySqlProcedure extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testMySqlProcedure(){
		MySqlProcedure procedure = new MySqlProcedure();
		assertTrue(procedure instanceof Procedure);
	}
	
	public void testSetGetName(){
		Procedure procedure = new MySqlProcedure();
		String name = "";
		procedure.setName(name);
		String name2 = procedure.getName();
		assertEquals(name, name2);
	}
	
	public void testSetGetType(){
		Procedure procedure = new MySqlProcedure();
		String type = "";
		procedure.setType(type);
		String type2 = procedure.getType();
		assertEquals(type, type2);
	}
	
	public void testSetGetDefiner(){
		Procedure procedure = new MySqlProcedure();
		String definer = "";
		procedure.setDefiner(definer);
		String definer2 = procedure.getDefiner();
		assertEquals(definer, definer2);
	}
	
	public void testSetGetCreatedDate(){
		Procedure procedure = new MySqlProcedure();
		String createdDate = "";
		procedure.setCreatedDate(createdDate);
		String createdDate2 = procedure.getCreatedDate();
		assertEquals(createdDate, createdDate2);
	}
	
	public void testSetGetModified(){
		Procedure procedure = new MySqlProcedure();
		String modifiedDate = "";
		procedure.setModifiedDate(modifiedDate);
		String modifiedDate2 = procedure.getModifiedDate();
		assertEquals(modifiedDate, modifiedDate2);
	}
	
	public void testSetGetSecurityType(){
		Procedure procedure = new MySqlProcedure();
		String securityType = "";
		procedure.setSecurityType(securityType);
		String securityType2 = procedure.getSecurityType();
		assertEquals(securityType, securityType2);
	}
	
	public void testSetGetComment(){
		Procedure procedure = new MySqlProcedure();
		String comment = "";
		procedure.setComment(comment);
		String comment2 = procedure.getComment();
		assertEquals(comment, comment2);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
