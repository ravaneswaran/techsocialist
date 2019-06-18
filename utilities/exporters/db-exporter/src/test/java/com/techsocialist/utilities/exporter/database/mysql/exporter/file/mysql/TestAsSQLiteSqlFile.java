package com.techsocialist.utilities.exporter.database.mysql.exporter.file.mysql;

import com.congruent.db.exporter.file.FileExporter;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/31/12
 * Time: 11:46 AM
 */
public class TestAsSQLiteSqlFile extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testAsSQLiteSqlFileInst() {
        AsSQLiteSqlFile export = new AsSQLiteSqlFile();
        assertTrue(export instanceof FileExporter);
    }

    public void testAsSQLiteSqlFileInst2() {
        String database = "training";
        String host = "";
        String port = "";
        String userName = "";
        String password = "";

        AsSQLiteSqlFile export = new AsSQLiteSqlFile(host,
                port, database, userName, password);
        assertTrue(export instanceof FileExporter);
    }

    public void testSetAndGetLocation() {
        FileExporter export = new AsSQLiteSqlFile();
        String path = "";
        export.setLocation(path);
        String location = export.getLocation();
        assertTrue(path.equals(location));
    }

    public void testExport() throws IOException, SQLException,
            ClassNotFoundException {
        String database = "training";
        String host = "localhost";
        String port = "3306";
        String userName = "root";
        String password = "admin";

        FileExporter exporter = new AsSQLiteSqlFile(host, port,
                database, userName, password);
        exporter.setLocation("");
        exporter.export();
        File file = new File("database-" + database + "-for-sqlite.sql");
        assertTrue(file.exists());

        InputStream inputStream = new FileInputStream(file);
        int available = inputStream.available();
        byte[] contents = new byte[available];
        inputStream.read(contents);
        inputStream.close();

        assertTrue(contents.length > 0);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
