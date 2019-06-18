package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.techsocialist.utilities.exporter.database.DataTypeMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySqlToSQLiteDataTypeMapper implements DataTypeMapper {


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
                        String actualDataType = datatype + "(-x,-y)";

                        returnVal = getMap().get(actualDataType);
                        returnVal = returnVal.replace("-x", xAndY[0]/* x */);
                        returnVal = returnVal.replace("-y", xAndY[1]/* y */);
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
                        String actualDataType = datatype + "(-x)";

                        String tempVal = getMap().get(actualDataType);
                        if(tempVal != null){
                            returnVal = tempVal.replace("-x", x);
                        }
                    } else {
                        // do nothing here...
                    }
                }
            }
        }
        return returnVal != null ? returnVal.toUpperCase() : null;
    }

    @Override
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("TINYINT".toLowerCase(), "TINYINT".toLowerCase());
        map.put("TINYINT(-X)".toLowerCase(), "TINYINT".toLowerCase());
        map.put("SMALLINT".toLowerCase(), "SMALLINT".toLowerCase());
        map.put("MEDIUMINT".toLowerCase(), "MEDIUMINT".toLowerCase());
        map.put("INT".toLowerCase(), "INT".toLowerCase());
        map.put("INT(-X)".toLowerCase(), "INT".toLowerCase());
        map.put("BIGINT".toLowerCase(), "BIGINT".toLowerCase());
        map.put("DECIMAL(-X,-Y)".toLowerCase(), "DECIMAL(-X,-Y)".toLowerCase());
        map.put("FLOAT(-X)".toLowerCase(), "FLOAT".toLowerCase());
        map.put("FLOAT(-X,-Y)".toLowerCase(), "FLOAT".toLowerCase());
        map.put("DOUBLE(-X,-Y)".toLowerCase(), "DOUBLE".toLowerCase());
        map.put("REAL(-X,-Y)".toLowerCase(), "REAL".toLowerCase());
        map.put("DATETIME".toLowerCase(), "DATETIME".toLowerCase());
        map.put("DATE".toLowerCase(), "DATE".toLowerCase());
        map.put("TIME".toLowerCase(), "DATETIME".toLowerCase());
        map.put("TIMESTAMP".toLowerCase(), "DATETIME".toLowerCase());
        map.put("YEAR".toLowerCase(), "TEXT".toLowerCase());
        map.put("CHAR".toLowerCase(), "CHARACTER".toLowerCase());
        map.put("VARCHAR".toLowerCase(), "VARCHAR".toLowerCase());
        map.put("VARCHAR(-X)".toLowerCase(), "VARCHAR(-X)".toLowerCase());
        map.put("TINYTEXT".toLowerCase(), "TEXT".toLowerCase());
        map.put("TEXT".toLowerCase(), "TEXT".toLowerCase());
        map.put("TEXT(-X)".toLowerCase(), "TEXT".toLowerCase());
        map.put("MEDIUMTEXT".toLowerCase(), "TEXT".toLowerCase());
        map.put("LONGTEXT".toLowerCase(), "TEXT".toLowerCase());
        map.put("BINARY".toLowerCase(), "TEXT".toLowerCase());
        map.put("BINARY(-X)".toLowerCase(), "TEXT".toLowerCase());
        map.put("VARBINARY".toLowerCase(), "TEXT".toLowerCase());
        map.put("VARBINARY(-X)".toLowerCase(), "TEXT".toLowerCase());
        map.put("TINYBLOB".toLowerCase(), "BLOB".toLowerCase());
        map.put("TINYBLOB(-X)".toLowerCase(), "BLOB".toLowerCase());
        map.put("BLOB".toLowerCase(), "BLOB".toLowerCase());
        map.put("BLOB(-X)".toLowerCase(), "BLOB".toLowerCase());
        map.put("MEDIUMBLOB".toLowerCase(), "BLOB".toLowerCase());
        map.put("MEDIUMBLOB(-X)".toLowerCase(), "BLOB".toLowerCase());
        map.put("LONGBLOB".toLowerCase(), "BLOB".toLowerCase());
        map.put("LONGBLOB(-X)".toLowerCase(), "BLOB".toLowerCase());

        return map;
    }
}
