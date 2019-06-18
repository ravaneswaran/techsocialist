package com.techsocialist.utilities.exporter.database.mysql.exporter.file.mysql;

import com.congruent.db.exporter.file.FileExporter;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/26/12
 * Time: 3:29 PM
 */
public class TestAsOracleSqlFile extends TestCase{

    public void testAsOracleSqlFileInst(){
        AsOracleSqlFile export = new  AsOracleSqlFile();
        assertTrue(export instanceof FileExporter);
    }
}
