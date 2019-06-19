package com.techsocialist.utilities.exporter.database.mysql.factory.exporter;

import com.techsocialist.utilities.exporter.database.FileExporter;
import com.techsocialist.utilities.exporter.database.mysql.factory.FileExporterFactory;
import junit.framework.TestCase;

public class TestFileExporterFactory extends TestCase {

    public void testFileExporterForMySql() {
        int fileExporter = FileExporter.AS_MYSQL_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsMySqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForMySql2() {

        String database = "tech_socialist";
        String host = "localhost";
        String port = "3306";
        String userName = "root";
        String password = "admin";

        int fileExporter = FileExporter.AS_MYSQL_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter, host, port, database, userName, password);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsMySqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForMSSql2005() {
        int fileExporter = FileExporter.AS_MSSQL2005_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsMSSql2005SqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForMSSql2008() {
        int fileExporter = FileExporter.AS_MSSQL2008_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsMSSql2008SqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForOracle() {
        int fileExporter = FileExporter.AS_ORACLE_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsOracleSqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForPostgres() {
        int fileExporter = FileExporter.AS_POSTGRESQL_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsPostgreSqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForSQLite() {
        int fileExporter = FileExporter.AS_SQLITE_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsSQLiteSqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForIngres() {
        int fileExporter = FileExporter.AS_INGRES_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.techsocialist.utilities.exporter.database.file.AsIngresSqlFile",fileExporterInst.getClass().getName());
    }
}
