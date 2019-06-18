package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.congruent.db.mapper.Mapper;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 11/1/12
 * Time: 1:13 PM
 */
public class TestMySqlToPostgreSqlDataTypeMapper extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testMySqlToMSSqlDataTypeMapperInst(){
        MySqlToPostgreSqlDataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        assertTrue(mapper instanceof Mapper);
        assertTrue(mapper instanceof DataTypeMapper);
    }

    public void testGetMap(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        Map<String, String> map = mapper.getMap();
        assertNotNull(map);
    }

    public void testGetToDataType(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String fromDataType = "";
        String toDataType = mapper.getToDataType(fromDataType);
        assertNull(toDataType);
    }

    public void testTinyInt(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint");
        assertEquals("SMALLINT", toDataType);
    }

    public void testSmallInt(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("smallint");
        assertEquals("SMALLINT", toDataType);
    }

    public void testMediumInt(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMINT");
        assertEquals("INTEGER", toDataType);
    }

    public void testInt(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("INT");
        assertEquals("INTEGER", toDataType);
    }

    public void testBigInt(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("BIGINT");
        assertEquals("BIGINT", toDataType);
    }

    public void testDecimal(){
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("decimal(10,10)");
        assertEquals("DECIMAL", toDataType);
    }

    public void testFloat() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10)");
        assertEquals("REAL", toDataType);
    }

    public void testFloatXY() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10, 5)");
        assertEquals("REAL", toDataType);
    }

    public void testDoubleXY() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("DOUBLE(10, 5)");
        assertEquals("DOUBLE PRECISION", toDataType);
    }

    public void testDateTime() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("datetime");
        assertEquals("TIMESTAMP", toDataType);
    }

    public void testTime() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("time");
        assertEquals("TIME", toDataType);
    }

    public void testTimeStamp() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("TIMESTAMP");
        assertEquals("TIMESTAMP DEFAULT", toDataType);
    }

    public void testYear() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("YEAR");
        assertEquals("SMALLINT", toDataType);
    }

    public void testChar() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("char");
        assertEquals("CHAR", toDataType);
    }

    public void testVarchar() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar");
        assertEquals("VARCHAR", toDataType);
    }

    public void testVarcharX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar(500)");
        assertEquals("VARCHAR", toDataType);
    }

    public void testTinyText() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYTEXT");
        assertEquals("TEXT", toDataType);
    }

    public void testText() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT");
        assertEquals("TEXT", toDataType);
    }

    public void testTextX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT(400)");
        assertEquals("TEXT", toDataType);
    }

    public void testMediumText() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMTEXT");
        assertEquals("TEXT", toDataType);
    }

    public void testLongText() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("longtext");
        assertEquals("TEXT", toDataType);
    }

    public void testBinary() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("binary");
        assertEquals("BYTEA", toDataType);
    }

    public void testBinaryX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("binary(1000)");
        assertEquals("BYTEA", toDataType);
    }

    public void testVarbinary() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY");
        assertEquals("BYTEA", toDataType);
    }

    public void testVarbinaryX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY(100)");
        assertEquals("BYTEA", toDataType);
    }

    public void testTinyBlob() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB");
        assertEquals("BYTEA", toDataType);
    }

    public void testTinyBlobX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB(300)");
        assertEquals("BYTEA", toDataType);
    }

    public void testBlob() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB");
        assertEquals("BYTEA", toDataType);
    }


    public void testBlobX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB(300)");
        assertEquals("BYTEA", toDataType);
    }

    public void testMediumBlob() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB");
        assertEquals("BYTEA", toDataType);
    }

    public void testMediumBlobX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB(300)");
        assertEquals("BYTEA", toDataType);
    }

    public void testLongBlob() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB");
        assertEquals("BYTEA", toDataType);
    }

    public void testLongBlobX() {
        DataTypeMapper mapper = new MySqlToPostgreSqlDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB(300)");
        assertEquals("BYTEA", toDataType);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
