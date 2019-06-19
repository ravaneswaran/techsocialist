package com.techsocialist.utilities.exporters.database.mysql.factory;

import com.techsocialist.utilities.exporters.database.api.DataTypeMapper;
import com.techsocialist.utilities.exporters.database.api.Database;
import com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.*;

public class MySqlDataTypeMapperFactory {

    public static DataTypeMapper getInstance(int mapper) {

        DataTypeMapper dataTypeMapper = null;

        switch (mapper){
            case Database.MYSQL_AS_MSSQL_2005:
                dataTypeMapper = new MySqlToMSSql2005DataTypeMapper();
                break;

            case Database.MYSQL_AS_MSSQL_2008:
                dataTypeMapper = new MySqlToMSSql2008DataTypeMapper();
                break;

            case Database.MYSQL_AS_ORACLE:
                dataTypeMapper = new MySqlToOracleDataTypeMapper();
                break;

            case Database.MYSQL_AS_SQL_LITE:
                dataTypeMapper = new MySqlToSQLiteDataTypeMapper();
                break;

            case Database.MYSQL_AS_POSTGRES:
                dataTypeMapper = new MySqlToPostgreSqlDataTypeMapper();
                break;

            case Database.MYSQL_AS_INGRES:
                dataTypeMapper = new MySqlToIngreslDataTypeMapper();
                break;
        }

       return dataTypeMapper;
    }
}
