package com.techsocialist.utilities.exporter.database.mysql.exporter.file.mysql;

import com.techsocialist.utilities.exporter.database.FileExporter;
import com.techsocialist.utilities.exporter.database.file.AsOracleSqlFile;
import junit.framework.TestCase;

public class TestAsOracleSqlFile extends TestCase{

    public void testAsOracleSqlFileInst(){
        AsOracleSqlFile export = new  AsOracleSqlFile();
        assertTrue(export instanceof FileExporter);
    }
}
