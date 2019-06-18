package com.techsocialist.utilities.exporter.database.mysql.factory.exporter;

import com.congruent.db.exporter.file.FileExporter;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/26/12
 * Time: 11:54 AM
 */
public class TestFileExporterFactory extends TestCase {



    public void testFileExporterForMySql() {
        int fileExporter = FileExporter.AS_MYSQL_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsMySqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForMySql2() {

        String database = "training";
        String host = "localhost";
        String port = "3306";
        String userName = "root";
        String password = "admin";

        int fileExporter = FileExporter.AS_MYSQL_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter, host, port, database, userName, password);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsMySqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForMSSql2005() {
        int fileExporter = FileExporter.AS_MSSQL2005_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsMSSql2005SqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForMSSql2008() {
        int fileExporter = FileExporter.AS_MSSQL2008_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsMSSql2008SqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForOracle() {
        int fileExporter = FileExporter.AS_ORACLE_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsOracleSqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForPostgres() {
        int fileExporter = FileExporter.AS_POSTGRESQL_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsPostgreSqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForSQLite() {
        int fileExporter = FileExporter.AS_SQLITE_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsSQLiteSqlFile",fileExporterInst.getClass().getName());
    }

    public void testFileExporterForIngres() {
        int fileExporter = FileExporter.AS_INGRES_FILE;
        FileExporter fileExporterInst = FileExporterFactory.getInstance(fileExporter);
        assertTrue(fileExporterInst != null);
        assertEquals("com.congruent.db.exporter.file.mysql.AsIngresSqlFile",fileExporterInst.getClass().getName());
    }
}
