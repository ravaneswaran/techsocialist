package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.congruent.db.mapper.Mapper;



public class TestMySqlToMSSql2008DataTypeMapper extends TestMySqlToMSSql2005DataTypeMapper{
	
	public void testMySqlToMSSqlDataTypeMapperInst(){
		MySqlToMSSql2008DataTypeMapper mapper = new MySqlToMSSql2008DataTypeMapper();
		assertTrue(mapper instanceof Mapper);
		assertTrue(mapper instanceof DataTypeMapper);
	}
	
	public void testDateTime(){
		DataTypeMapper mapper = new MySqlToMSSql2008DataTypeMapper();
		String toDataType = mapper.getToDataType("datetime");
		assertEquals("datetime".toLowerCase(), toDataType);
	}

}
