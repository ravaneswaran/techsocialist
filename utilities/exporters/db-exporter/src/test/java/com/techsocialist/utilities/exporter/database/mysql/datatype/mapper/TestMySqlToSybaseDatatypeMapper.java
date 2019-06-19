package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.techsocialist.utilities.exporter.database.DataTypeMapper;
import com.techsocialist.utilities.exporter.database.Mapper;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravaneswaran
 * Date: 2/11/12
 * Time: 12:36 AM
 */
public class TestMySqlToSybaseDatatypeMapper extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testMySqlToMSSqlDataTypeMapperInst(){
        MySqlToSybaselDataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        assertTrue(mapper instanceof Mapper);
        assertTrue(mapper instanceof DataTypeMapper);
    }

    public void testGetMap(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        Map<String, String> map = mapper.getMap();
        assertNotNull(map);
    }

    public void testGetToDataType(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String fromDataType = "";
        String toDataType = mapper.getToDataType(fromDataType);
        assertNull(toDataType);
    }

    public void testTinyInt(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint");
        assertEquals("TINYINT", toDataType);
    }

    public void testTinyIntX(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint(x)");
        assertEquals("TINYINT", toDataType);
    }

    public void testSmallInt(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("smallint");
        assertEquals("UNSIGNED SMALLINT", toDataType);
    }

    public void testMediumInt(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMINT");
        assertEquals("INTEGER", toDataType);
    }

    public void testInt(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("INT");
        assertEquals("INTEGER", toDataType);
    }

    public void testBigInt(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("BIGINT");
        assertEquals("BIGINT", toDataType);
    }

    public void testDecimal(){
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("decimal(10,10)");
        assertEquals("DECIMAL(10,10)", toDataType);
    }

    public void testFloat() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10)");
        assertEquals("FLOAT", toDataType);
    }

    public void testFloatXY() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10, 5)");
        assertEquals("FLOAT4", toDataType);
    }

    public void testDoubleXY() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("DOUBLE(10, 5)");
        assertEquals("FLOAT", toDataType);
    }

    public void testDateTime() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("datetime");
        assertEquals("INGRESDATE", toDataType);
    }

    public void testTime() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("time");
        assertEquals("TIME", toDataType);
    }

    public void testTimeStamp() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("TIMESTAMP");
        assertEquals("TIMESTAMP", toDataType);
    }

    public void testYear() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("YEAR");
        assertEquals("ANSIDATE", toDataType);
    }

    public void testChar() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("char");
        assertEquals("CHAR", toDataType);
    }

    public void testVarchar() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar");
        assertEquals("VARCHAR", toDataType);
    }

    public void testVarcharX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar(500)");
        assertEquals("VARCHAR(500)", toDataType);
    }

    public void testTinyText() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYTEXT");
        assertEquals("VARCHAR", toDataType);
    }

    public void testText() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT");
        assertEquals("LONG VARCHAR", toDataType);
    }

    public void testTextX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT(400)");
        assertEquals("LONG VARCHAR(400)", toDataType);
    }

    public void testMediumText() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMTEXT");
        assertEquals("LONG VARCHAR", toDataType);
    }

    public void testLongText() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("longtext");
        assertEquals("LONG VARCHAR", toDataType);
    }

    public void testBinary() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("binary");
        assertEquals("BYTE", toDataType);
    }

    public void testBinaryX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("binary(1000)");
        assertEquals("BYTE(1000)", toDataType);
    }

    public void testVarbinary() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY");
        assertEquals("BYTE", toDataType);
    }

    public void testVarbinaryX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY(100)");
        assertEquals("BYTE", toDataType);
    }

    public void testTinyBlob() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB");
        assertEquals("BYTE VARYING", toDataType);
    }

    public void testTinyBlobX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB(300)");
        assertEquals("BYTE VARYING(300)", toDataType);
    }

    public void testBlob() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB");
        assertEquals("LONG BYTE", toDataType);
    }


    public void testBlobX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB(300)");
        assertEquals("LONG BYTE(300)", toDataType);
    }

    public void testMediumBlob() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB");
        assertEquals("LONG BYTE", toDataType);
    }

    public void testMediumBlobX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB(300)");
        assertEquals("LONG BYTE(300)", toDataType);
    }

    public void testLongBlob() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB");
        assertEquals("LONG BYTE", toDataType);
    }

    public void testLongBlobX() {
        DataTypeMapper mapper = new MySqlToSybaselDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB(300)");
        assertEquals("LONG BYTE(300)", toDataType);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
