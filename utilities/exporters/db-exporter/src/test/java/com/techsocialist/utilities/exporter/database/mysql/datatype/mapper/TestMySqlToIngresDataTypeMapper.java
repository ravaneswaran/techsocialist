package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.congruent.db.mapper.Mapper;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 11/1/12
 * Time: 6:33 PM
 */
public class TestMySqlToIngresDataTypeMapper extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testMySqlToMSSqlDataTypeMapperInst(){
        MySqlToIngreslDataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        assertTrue(mapper instanceof Mapper);
        assertTrue(mapper instanceof DataTypeMapper);
    }

    public void testGetMap(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        Map<String, String> map = mapper.getMap();
        assertNotNull(map);
    }

    public void testGetToDataType(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String fromDataType = "";
        String toDataType = mapper.getToDataType(fromDataType);
        assertNull(toDataType);
    }

    public void testTinyInt(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint");
        assertEquals("TINYINT", toDataType);
    }

    public void testTinyIntX(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint(x)");
        assertEquals("TINYINT", toDataType);
    }

    public void testSmallInt(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("smallint");
        assertEquals("SMALLINT", toDataType);
    }

    public void testMediumInt(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMINT");
        assertEquals("INTEGER", toDataType);
    }

    public void testInt(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("INT");
        assertEquals("INTEGER", toDataType);
    }

    public void testBigInt(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("BIGINT");
        assertEquals("BIGINT", toDataType);
    }

    public void testDecimal(){
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("decimal(10,10)");
        assertEquals("DECIMAL(10,10)", toDataType);
    }

    public void testFloat() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10)");
        assertEquals("FLOAT", toDataType);
    }

    public void testFloatXY() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10, 5)");
        assertEquals("FLOAT4", toDataType);
    }

    public void testDoubleXY() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("DOUBLE(10, 5)");
        assertEquals("FLOAT", toDataType);
    }

    public void testDateTime() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("datetime");
        assertEquals("INGRESDATE", toDataType);
    }

    public void testTime() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("time");
        assertEquals("TIME", toDataType);
    }

    public void testTimeStamp() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("TIMESTAMP");
        assertEquals("TIMESTAMP", toDataType);
    }

    public void testYear() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("YEAR");
        assertEquals("ANSIDATE", toDataType);
    }

    public void testChar() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("char");
        assertEquals("CHAR", toDataType);
    }

    public void testVarchar() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar");
        assertEquals("VARCHAR", toDataType);
    }

    public void testVarcharX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar(500)");
        assertEquals("VARCHAR(500)", toDataType);
    }

    public void testTinyText() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYTEXT");
        assertEquals("VARCHAR", toDataType);
    }

    public void testText() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT");
        assertEquals("LONG VARCHAR", toDataType);
    }

    public void testTextX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT(400)");
        assertEquals("LONG VARCHAR(400)", toDataType);
    }

    public void testMediumText() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMTEXT");
        assertEquals("LONG VARCHAR", toDataType);
    }

    public void testLongText() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("longtext");
        assertEquals("LONG VARCHAR", toDataType);
    }

    public void testBinary() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("binary");
        assertEquals("BYTE", toDataType);
    }

    public void testBinaryX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("binary(1000)");
        assertEquals("BYTE(1000)", toDataType);
    }

    public void testVarbinary() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY");
        assertEquals("BYTE", toDataType);
    }

    public void testVarbinaryX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY(100)");
        assertEquals("BYTE", toDataType);
    }

    public void testTinyBlob() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB");
        assertEquals("BYTE VARYING", toDataType);
    }

    public void testTinyBlobX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB(300)");
        assertEquals("BYTE VARYING(300)", toDataType);
    }

    public void testBlob() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB");
        assertEquals("LONG BYTE", toDataType);
    }


    public void testBlobX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB(300)");
        assertEquals("LONG BYTE(300)", toDataType);
    }

    public void testMediumBlob() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB");
        assertEquals("LONG BYTE", toDataType);
    }

    public void testMediumBlobX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB(300)");
        assertEquals("LONG BYTE(300)", toDataType);
    }

    public void testLongBlob() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB");
        assertEquals("LONG BYTE", toDataType);
    }

    public void testLongBlobX() {
        DataTypeMapper mapper = new MySqlToIngreslDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB(300)");
        assertEquals("LONG BYTE(300)", toDataType);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
