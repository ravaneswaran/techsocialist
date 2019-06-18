package com.techsocialist.utilities.exporter.database.mysql.factory.mapper.datatype;

import com.congruent.db.Database;
import com.congruent.db.mapper.datatype.DataTypeMapper;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/29/12
 * Time: 12:29 PM
 */
public class TestMySqlDataTypeMapperFactory extends TestCase {

    public void testDataTypeMapperFactoryInst() {
        MySqlDataTypeMapperFactory dataTypeMapperFactory = new MySqlDataTypeMapperFactory();
        assertTrue(dataTypeMapperFactory != null);
    }

    public void testMySqlToMSSql2005DataTypeMapper() {
        int mapper = Database.MYSQL_AS_MSSQL_2005;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.congruent.db.mapper.datatype.MySqlToMSSql2005DataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToMSSql2008DataTypeMapper() {
        int mapper = Database.MYSQL_AS_MSSQL_2008;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.congruent.db.mapper.datatype.MySqlToMSSql2008DataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToOracleDataTypeMapper() {
        int mapper = Database.MYSQL_AS_ORACLE;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.congruent.db.mapper.datatype.MySqlToOracleDataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToSQLLiteDataTypeMapper() {
        int mapper = Database.MYSQL_AS_SQL_LITE;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.congruent.db.mapper.datatype.MySqlToSQLiteDataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToPostgreDataTypeMapper() {
        int mapper = Database.MYSQL_AS_POSTGRES;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.congruent.db.mapper.datatype.MySqlToPostgreSqlDataTypeMapper", mapperInst.getClass().getName());
    }

    public void testMySqlToIngresDataTypeMapper() {
        int mapper = Database.MYSQL_AS_INGRES;
        DataTypeMapper mapperInst = MySqlDataTypeMapperFactory.getInstance(mapper);
        assertTrue(mapperInst != null);
        assertEquals("com.congruent.db.mapper.datatype.MySqlToIngreslDataTypeMapper", mapperInst.getClass().getName());
    }

}
