package com.techsocialist.utilities.exporters.database.exporter.file.mysql;

import com.techsocialist.utilities.exporters.database.api.FileExporter;
import com.techsocialist.utilities.exporters.database.mysql.file.AsSQLiteSqlFile;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

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
        String database = "tech_socialist";
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
        String database = "tech_socialist";
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
