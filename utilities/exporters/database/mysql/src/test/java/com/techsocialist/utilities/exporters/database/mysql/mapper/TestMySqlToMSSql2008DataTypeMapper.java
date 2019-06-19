package com.techsocialist.utilities.exporters.database.mysql.mapper;

import com.techsocialist.utilities.exporters.database.api.DataTypeMapper;
import com.techsocialist.utilities.exporters.database.api.Mapper;
import com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToMSSql2008DataTypeMapper;

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
