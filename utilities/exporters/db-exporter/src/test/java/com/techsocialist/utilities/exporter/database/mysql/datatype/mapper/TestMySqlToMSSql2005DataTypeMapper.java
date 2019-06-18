package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.congruent.db.mapper.Mapper;
import junit.framework.TestCase;

import java.util.Map;

public class TestMySqlToMSSql2005DataTypeMapper extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testMySqlToMSSqlDataTypeMapperInst() {
        MySqlToMSSql2005DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        assertTrue(mapper instanceof Mapper);
        assertTrue(mapper instanceof DataTypeMapper);
    }

    public void testGetMap() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        Map<String, String> map = mapper.getMap();
        assertNotNull(map);
    }

    public void testGetToDataType() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String fromDataType = "";
        String toDataType = mapper.getToDataType(fromDataType);
        assertNull(toDataType);
    }

    public void testTinyInt() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint");
        assertEquals("tinyint", toDataType);
    }

    public void testSmallInt() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("smallint");
        assertEquals("smallint", toDataType);
    }

    public void testMediumInt() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMINT");
        assertEquals("int", toDataType);
    }

    public void testInt() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("INT");
        assertEquals("int", toDataType);
    }

    public void testBigInt() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("BIGINT");
        assertEquals("bigint", toDataType);
    }

    public void testDecimal() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("decimal(10,10)");
        assertEquals("decimal(10,10)", toDataType);
    }

    public void testFloat() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10)");
        assertEquals("FLOAT(10)".toLowerCase(), toDataType);
    }

    public void testFloatXY() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10, 5)");
        assertEquals("FLOAT(10)".toLowerCase(), toDataType);
    }

    public void testDoubleXY() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("DOUBLE(10, 5)");
        assertEquals("FLOAT(10)".toLowerCase(), toDataType);
    }

    public void testRealXY() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("REAL(10, 5)");
        assertEquals("FLOAT(10)".toLowerCase(), toDataType);
    }

    public void testDateTime() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("datetime");
        assertEquals("datetime2".toLowerCase(), toDataType);
    }

    public void testTime() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("time");
        assertEquals("time".toLowerCase(), toDataType);
    }

    public void testTimeStamp() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("TIMESTAMP");
        assertEquals("smalldatetime".toLowerCase(), toDataType);
    }

    public void testYear() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("YEAR");
        assertEquals("smallint".toLowerCase(), toDataType);
    }

    public void testChar() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("char");
        assertEquals("nchar(200)".toLowerCase(), toDataType);
    }

    public void testVarchar() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("varchar");
        assertEquals("nvarchar(200)".toLowerCase(), toDataType);
    }

    public void testVarcharX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("varchar(500)");
        assertEquals("nvarchar(500)".toLowerCase(), toDataType);
    }

    public void testTinyText() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("TINYTEXT");
        assertEquals("nvarchar(200)".toLowerCase(), toDataType);
    }

    public void testText() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT");
        assertEquals("nvarchar(200)".toLowerCase(), toDataType);
    }

    public void testTextX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT(400)");
        assertEquals("nvarchar(400)".toLowerCase(), toDataType);
    }

    public void testMediumText() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMTEXT");
        assertEquals("nvarchar(200)".toLowerCase(), toDataType);
    }

    public void testLongText() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("longtext");
        assertEquals("nvarchar(200)".toLowerCase(), toDataType);
    }

    public void testBinary() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("binary");
        assertEquals("binary(200)".toLowerCase(), toDataType);
    }

    public void testBinaryX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("binary(1000)");
        assertEquals("binary(1000)".toLowerCase(), toDataType);
    }

    public void testVarbinary() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY");
        assertEquals("varbinary(200)".toLowerCase(), toDataType);
    }

    public void testVarbinaryX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY(100)");
        assertEquals("varbinary(100)".toLowerCase(), toDataType);
    }

    public void testTinyBlob() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB");
        assertEquals("varbinary(200)".toLowerCase(), toDataType);
    }

    public void testTinyBlobX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB(300)");
        assertEquals("varbinary(300)".toLowerCase(), toDataType);
    }

    public void testBlob() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB");
        assertEquals("varbinary(200)".toLowerCase(), toDataType);
    }

    public void testBlobX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB(300)");
        assertEquals("varbinary(300)".toLowerCase(), toDataType);
    }

    public void testMediumBlob() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB");
        assertEquals("varbinary(200)".toLowerCase(), toDataType);
    }

    public void testMediumBlobX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB(300)");
        assertEquals("varbinary(300)".toLowerCase(), toDataType);
    }

    public void testLongBlob() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB");
        assertEquals("varbinary(200)".toLowerCase(), toDataType);
    }

    public void testLongBlobX() {
        DataTypeMapper mapper = new MySqlToMSSql2005DataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB(300)");
        assertEquals("varbinary(300)".toLowerCase(), toDataType);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
