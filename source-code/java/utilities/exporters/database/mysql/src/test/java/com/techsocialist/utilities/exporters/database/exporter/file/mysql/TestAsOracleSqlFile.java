package com.techsocialist.utilities.exporters.database.exporter.file.mysql;

import com.techsocialist.utilities.exporters.database.api.FileExporter;
import com.techsocialist.utilities.exporters.database.mysql.file.AsOracleSqlFile;
import junit.framework.TestCase;

public class TestAsOracleSqlFile extends TestCase{

    public void testAsOracleSqlFileInst(){
        AsOracleSqlFile export = new  AsOracleSqlFile();
        assertTrue(export instanceof FileExporter);
    }
}
