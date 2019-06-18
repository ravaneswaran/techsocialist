package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.techsocialist.utilities.exporter.database.DataTypeMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlToPostgreSqlDataTypeMapper implements DataTypeMapper {

    @Override
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

    @Override
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("TINYINT".toLowerCase(), "SMALLINT");
        map.put("TINYINT(X)".toLowerCase(), "SMALLINT");
        map.put("SMALLINT".toLowerCase(), "SMALLINT");
        map.put("MEDIUMINT".toLowerCase(), "INTEGER");
        map.put("INT".toLowerCase(), "INTEGER");
        map.put("INT(X)".toLowerCase(), "INTEGER");
        map.put("BIGINT".toLowerCase(), "BIGINT");
        map.put("DECIMAL(X,Y)".toLowerCase(), "DECIMAL");
        map.put("FLOAT(X)".toLowerCase(), "REAL");
        map.put("FLOAT(X,Y)".toLowerCase(), "REAL");
        map.put("DOUBLE(X,Y)".toLowerCase(), "DOUBLE PRECISION");
        map.put("REAL(X,Y)".toLowerCase(), "REAL");
        map.put("DATETIME".toLowerCase(), "TIMESTAMP");
        map.put("DATE".toLowerCase(), "date");
        map.put("TIME".toLowerCase(), "TIME");
        map.put("TIMESTAMP".toLowerCase(), "TIMESTAMP DEFAULT");
        map.put("YEAR".toLowerCase(), "SMALLINT");
        map.put("CHAR".toLowerCase(), "CHAR");
        map.put("VARCHAR".toLowerCase(), "VARCHAR");
        map.put("VARCHAR(X)".toLowerCase(), "VARCHAR");
        map.put("TINYTEXT".toLowerCase(), "TEXT");
        map.put("TEXT".toLowerCase(), "TEXT");
        map.put("TEXT(X)".toLowerCase(), "TEXT");
        map.put("MEDIUMTEXT".toLowerCase(), "TEXT");
        map.put("LONGTEXT".toLowerCase(), "TEXT");
        map.put("BINARY".toLowerCase(), "BYTEA");
        map.put("BINARY(X)".toLowerCase(), "BYTEA");
        map.put("VARBINARY".toLowerCase(), "BYTEA");
        map.put("VARBINARY(X)".toLowerCase(), "BYTEA");
        map.put("TINYBLOB".toLowerCase(), "BYTEA");
        map.put("TINYBLOB(x)".toLowerCase(), "BYTEA");
        map.put("BLOB".toLowerCase(), "BYTEA");
        map.put("BLOB(x)".toLowerCase(), "BYTEA");
        map.put("MEDIUMBLOB".toLowerCase(), "BYTEA");
        map.put("MEDIUMBLOB(x)".toLowerCase(), "BYTEA");
        map.put("LONGBLOB".toLowerCase(), "BYTEA");
        map.put("LONGBLOB(x)".toLowerCase(), "BYTEA");

        return map;
    }
}
