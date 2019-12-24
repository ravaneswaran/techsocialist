package com.techsocialist.utilities.exporters.database.factory.mapper.datatype;

import com.techsocialist.utilities.exporters.database.api.DataTypeMapper;
import com.techsocialist.utilities.exporters.database.api.Database;
import com.techsocialist.utilities.exporters.database.mysql.factory.MySqlDataTypeMapperFactory;
import junit.framework.TestCase;

public class TestMySqlDataTypeMapperFactory extends TestCase {

    public void testDataTypeMapperFactoryInst() {
        MySqlDataTypeMapperFactory dataTypeMapperFactory = new MySqlDataTypeMapperFactory();
        assertTrue(dataTypeMapperFactory != null);
    }

    public void testMySqlToMSSql2005DataTypeMapper() {
        int mapper = Database.MYSQL_AS_MSSQL_2005;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToMSSql2005DataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToMSSql2008DataTypeMapper() {
        int mapper = Database.MYSQL_AS_MSSQL_2008;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToMSSql2008DataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToOracleDataTypeMapper() {
        int mapper = Database.MYSQL_AS_ORACLE;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToOracleDataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToSQLLiteDataTypeMapper() {
        int mapper = Database.MYSQL_AS_SQL_LITE;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToSQLiteDataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToPostgreDataTypeMapper() {
        int mapper = Database.MYSQL_AS_POSTGRES;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToPostgreSqlDataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToIngresDataTypeMapper() {
        int mapper = Database.MYSQL_AS_INGRES;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.datatype.mapper.MySqlToIngreslDataTypeMapper", mapperInst.getClass().getName());
    }

}
