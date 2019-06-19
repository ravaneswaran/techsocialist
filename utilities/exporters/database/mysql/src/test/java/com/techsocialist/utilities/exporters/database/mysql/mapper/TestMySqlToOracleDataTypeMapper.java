package com.techsocialist.utilities.exporters.database.mysql.mapper;

import com.techsocialist.utilities.exporters.database.api.DataTypeMapper;
import com.techsocialist.utilities.exporters.database.api.Mapper;
import com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToOracleDataTypeMapper;
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
