package com.techsocialist.utilities.exporters.database.mysql.datatype.mapper;

import java.util.Map;


public class MySqlToMSSql2008DataTypeMapper extends MySqlToMSSql2005DataTypeMapper{
	
	@Override
	public Map<String, String> getMap() {
		Map<String, String> map = super.getMap();
		map.put("DATETIME".toLowerCase(), "datetime");
		return map;
	}

}
