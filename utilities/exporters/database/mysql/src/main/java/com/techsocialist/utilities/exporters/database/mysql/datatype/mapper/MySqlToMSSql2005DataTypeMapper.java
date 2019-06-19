package com.techsocialist.utilities.exporters.database.mysql.datatype.mapper;

import com.techsocialist.utilities.exporters.database.api.DataTypeMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlToMSSql2005DataTypeMapper implements DataTypeMapper {

	// http://www.mssqltips.com/sqlservertutorial/2203/mysql-to-sql-server-data-type-comparisons/

	public Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();

		map.put("TINYINT".toLowerCase(), "tinyint");
		map.put("TINYINT(X)".toLowerCase(), "tinyint");
		map.put("SMALLINT".toLowerCase(), "smallint");
		map.put("MEDIUMINT".toLowerCase(), "int");
		map.put("INT".toLowerCase(), "int");
		map.put("INT(X)".toLowerCase(), "int");
		map.put("BIGINT".toLowerCase(), "bigint");
		map.put("DECIMAL(X,Y)".toLowerCase(), "decimal(x,y)");
		map.put("FLOAT(X)".toLowerCase(), "float(x)");
		map.put("FLOAT(X,Y)".toLowerCase(), "float(x)");
		map.put("DOUBLE(X,Y)".toLowerCase(), "float(x)");
		map.put("REAL(X,Y)".toLowerCase(), "float(x)");
		map.put("DATETIME".toLowerCase(), "datetime2");
		map.put("DATE".toLowerCase(), "date");
		map.put("TIME".toLowerCase(), "time");
		map.put("TIMESTAMP".toLowerCase(), "smalldatetime");
		map.put("YEAR".toLowerCase(), "smallint");
		map.put("CHAR".toLowerCase(), "nchar(200)");
		map.put("VARCHAR".toLowerCase(), "nvarchar(200)");
		map.put("VARCHAR(X)".toLowerCase(), "nvarchar(x)");
		map.put("TINYTEXT".toLowerCase(), "nvarchar(200)");
		map.put("TEXT".toLowerCase(), "nvarchar(200)");
		map.put("TEXT(X)".toLowerCase(), "nvarchar(x)");
		map.put("MEDIUMTEXT".toLowerCase(), "nvarchar(200)");
		map.put("LONGTEXT".toLowerCase(), "nvarchar(200)");
		map.put("BINARY".toLowerCase(), "binary(200)");
		map.put("BINARY(X)".toLowerCase(), "binary(x)");
		map.put("VARBINARY".toLowerCase(), "varbinary(200)");
		map.put("VARBINARY(X)".toLowerCase(), "varbinary(x)");
		map.put("TINYBLOB".toLowerCase(), "varbinary(200)");
		map.put("TINYBLOB(x)".toLowerCase(), "varbinary(x)");
		map.put("BLOB".toLowerCase(), "varbinary(200)");
		map.put("BLOB(x)".toLowerCase(), "varbinary(x)");
		map.put("MEDIUMBLOB".toLowerCase(), "varbinary(200)");
		map.put("MEDIUMBLOB(x)".toLowerCase(), "varbinary(x)");
		map.put("LONGBLOB".toLowerCase(), "varbinary(200)");
		map.put("LONGBLOB(x)".toLowerCase(), "varbinary(x)");

		return map;
	}

	public String getToDataType(String fromDataType) {
		String returnVal = null;
		String toLowerCase = fromDataType.toLowerCase();
		returnVal = getMap().get(toLowerCase);
		if (null == returnVal) {
			boolean containsParanthesesPair = toLowerCase.contains("(")
					&& toLowerCase.contains(")");
			if (containsParanthesesPair) {
				boolean containsComma = toLowerCase.contains(",");
				if (containsComma) {
					Pattern pattern = Pattern.compile("([0-9]*,[ ]*[0-9]*)");
					Matcher matcher = pattern.matcher(toLowerCase);
					if (matcher.find()) {
						int start = matcher.start();
						int end = matcher.end();
						String[] xAndY = toLowerCase.substring(start, end)
								.split(",");
						String datatype = toLowerCase.substring(0, start - 1);
						String actualDataType = datatype + "(x,y)";

						returnVal = getMap().get(actualDataType);
						returnVal = returnVal.replace("x", xAndY[0]/* x */);
						returnVal = returnVal.replace("y", xAndY[1]/* y */);
					} else {
						// do nothing here...
					}
				} else {
					Pattern pattern = Pattern.compile("\\([0-9]*\\)");
					Matcher matcher = pattern.matcher(toLowerCase);
					if (matcher.find()) {
						int start = matcher.start();
						int end = matcher.end();

						String x = toLowerCase.substring(start + 1, end - 1);
						String datatype = toLowerCase.substring(0, start);
						String actualDataType = datatype + "(x)";

						String tempVal = getMap().get(actualDataType);
						if(tempVal != null){
							returnVal = tempVal.replace("x", x);
						}
					} else {
						// do nothing here...
					}
				}
			}
		}
		return returnVal;
	}
}
