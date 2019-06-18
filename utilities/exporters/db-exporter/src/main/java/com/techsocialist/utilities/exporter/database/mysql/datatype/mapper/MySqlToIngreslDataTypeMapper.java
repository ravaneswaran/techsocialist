package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.techsocialist.utilities.exporter.database.DataTypeMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlToIngreslDataTypeMapper implements DataTypeMapper {

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

        map.put("TINYINT".toLowerCase(), "TINYINT");
        map.put("TINYINT(X)".toLowerCase(), "TINYINT");
        map.put("SMALLINT".toLowerCase(), "SMALLINT");
        map.put("MEDIUMINT".toLowerCase(), "INTEGER");
        map.put("INT".toLowerCase(), "INTEGER");
        map.put("INT(X)".toLowerCase(), "INTEGER");
        map.put("BIGINT".toLowerCase(), "BIGINT");
        map.put("DECIMAL(X,Y)".toLowerCase(), "DECIMAL(x,y)");
        map.put("FLOAT(X)".toLowerCase(), "FLOAT");
        map.put("FLOAT(X,Y)".toLowerCase(), "FLOAT4");
        map.put("DOUBLE(X,Y)".toLowerCase(), "FLOAT");
        //map.put("REAL(X,Y)".toLowerCase(), "float(x)");
        map.put("DATETIME".toLowerCase(), "INGRESDATE");
        map.put("DATE".toLowerCase(), "INGRESDATE");
        map.put("TIME".toLowerCase(), "TIME");
        map.put("TIMESTAMP".toLowerCase(), "TIMESTAMP");
        map.put("YEAR".toLowerCase(), "ANSIDATE");
        map.put("CHAR".toLowerCase(), "CHAR");
        map.put("VARCHAR".toLowerCase(), "VARCHAR");
        map.put("VARCHAR(X)".toLowerCase(), "VARCHAR(x)");
        map.put("TINYTEXT".toLowerCase(), "VARCHAR");
        map.put("TEXT".toLowerCase(), "LONG VARCHAR");
        map.put("TEXT(X)".toLowerCase(), "LONG VARCHAR(x)");
        map.put("MEDIUMTEXT".toLowerCase(), "LONG VARCHAR");
        map.put("LONGTEXT".toLowerCase(), "LONG VARCHAR");
        map.put("BINARY".toLowerCase(), "BYTE");
        map.put("BINARY(X)".toLowerCase(), "BYTE(x)");
        map.put("VARBINARY".toLowerCase(), "BYTE");
        map.put("VARBINARY(X)".toLowerCase(), "BYTE");
        map.put("TINYBLOB".toLowerCase(), "BYTE VARYING");
        map.put("TINYBLOB(X)".toLowerCase(), "BYTE VARYING(x)");
        map.put("BLOB".toLowerCase(), "LONG BYTE");
        map.put("BLOB(X)".toLowerCase(), "LONG BYTE(x)");
        map.put("MEDIUMBLOB".toLowerCase(), "LONG BYTE");
        map.put("MEDIUMBLOB(X)".toLowerCase(), "LONG BYTE(x)");
        map.put("LONGBLOB".toLowerCase(), "LONG BYTE");
        map.put("LONGBLOB(X)".toLowerCase(), "LONG BYTE(x)");

        return map;
    }
}
