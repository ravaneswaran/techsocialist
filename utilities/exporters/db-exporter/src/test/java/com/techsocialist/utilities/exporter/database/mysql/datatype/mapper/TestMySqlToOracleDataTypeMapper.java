package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.techsocialist.utilities.exporter.database.DataTypeMapper;
import com.techsocialist.utilities.exporter.database.Mapper;
import junit.framework.TestCase;

public class TestMySqlToOracleDataTypeMapper extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testMySqlToOracleDataTypeMapperInst(){
		MySqlToOracleDataTypeMapper mapper = new MySqlToOracleDataTypeMapper();
        assertTrue(mapper instanceof Mapper);
        assertTrue(mapper instanceof DataTypeMapper);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
