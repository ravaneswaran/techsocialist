package com.techsocialist.utilities.exporter.database.mysql.datatype.mapper;

import com.congruent.db.mapper.Mapper;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/30/12
 * Time: 12:36 PM
 */
public class TestMySqlToSQLiteDataTypeMapper extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testMySqlToMSSqlDataTypeMapperInst(){
        MySqlToSQLiteDataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        assertTrue(mapper instanceof Mapper);
        assertTrue(mapper instanceof DataTypeMapper);
    }

    public void testGetMap(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        Map<String, String> map = mapper.getMap();
        assertNotNull(map);
    }

    public void testGetToDataType(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String fromDataType = "";
        String toDataType = mapper.getToDataType(fromDataType);
        assertNull(toDataType);
    }

    public void testTinyInt(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("tinyint");
        assertEquals("TINYINT", toDataType);
    }

    public void testSmallInt(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("smallint");
        assertEquals("SMALLINT", toDataType);
    }

    public void testMediumInt(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMINT");
        assertEquals("MEDIUMINT", toDataType);
    }

    public void testInt(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("INT");
        assertEquals("INT", toDataType);
    }

    public void testBigInt(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("BIGINT");
        assertEquals("BIGINT", toDataType);
    }

    public void testDecimal(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("decimal(10,10)");
        assertEquals("DECIMAL(10,10)", toDataType);
    }

    public void testFloat(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10)");
        assertEquals("FLOAT", toDataType);
    }

    public void testFloatXY(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("FLOAT(10, 5)");
        assertEquals("FLOAT", toDataType);
    }

    public void testDoubleXY(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("DOUBLE(10,5)");
        assertEquals("DOUBLE", toDataType);
    }

    public void testRealXY(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("REAL(10, 5)");
        assertEquals("REAL", toDataType);
    }

    public void testDateTime(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("datetime");
        assertEquals("DATETIME", toDataType);
    }

    public void testTime(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("time");
        assertEquals("DATETIME", toDataType);
    }

    public void testTimeStamp(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("TIMESTAMP");
        assertEquals("DATETIME", toDataType);
    }

    public void testYear(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("YEAR");
        assertEquals("TEXT", toDataType);
    }

    public void testChar(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("char");
        assertEquals("CHARACTER", toDataType);
    }

    public void testVarchar(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar");
        assertEquals("VARCHAR", toDataType);
    }

    public void testVarcharX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("varchar(500)");
        assertEquals("VARCHAR(500)", toDataType);
    }

    public void testTinyText(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYTEXT");
        assertEquals("TEXT", toDataType);
    }

    public void testText(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT");
        assertEquals("TEXT", toDataType);
    }

    public void testTextX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("TEXT(400)");
        assertEquals("TEXT", toDataType);
    }

    public void testMediumText(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMTEXT");
        assertEquals("TEXT", toDataType);
    }

    public void testLongText(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("longtext");
        assertEquals("TEXT", toDataType);
    }

    public void testBinary(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("binary");
        assertEquals("TEXT", toDataType);
    }

    public void testBinaryX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("binary(1000)");
        assertEquals("TEXT", toDataType);
    }

    public void testVarbinary(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY");
        assertEquals("TEXT", toDataType);
    }

    public void testVarbinaryX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("VARBINARY(100)");
        assertEquals("TEXT", toDataType);
    }

    public void testTinyBlob(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB");
        assertEquals("BLOB", toDataType);
    }

    public void testTinyBlobX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("TINYBLOB(300)");
        assertEquals("BLOB", toDataType);
    }

    public void testBlob(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB");
        assertEquals("BLOB", toDataType);
    }

    public void testBlobX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("BLOB(300)");
        assertEquals("BLOB", toDataType);
    }

    public void testMediumBlob(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB");
        assertEquals("BLOB", toDataType);
    }

    public void testMediumBlobX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("MEDIUMBLOB(300)");
        assertEquals("BLOB", toDataType);
    }

    public void testLongBlob(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB");
        assertEquals("BLOB", toDataType);
    }

    public void testLongBlobX(){
        DataTypeMapper mapper = new MySqlToSQLiteDataTypeMapper();
        String toDataType = mapper.getToDataType("LONGBLOB(300)");
        assertEquals("BLOB", toDataType);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
