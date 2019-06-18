package com.techsocialist.utilities.exporter.database.mysql.exporter.file.mysql;

import com.congruent.db.exporter.file.FileExporter;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class TestAsMSSql2008SqlFile extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testAsMSSql2008SqlFileInst() {
		AsMSSql2008SqlFile export = new AsMSSql2008SqlFile();
		assertTrue(export instanceof FileExporter);
	}

	public void testAsMSSql2008SqlFileInst2() {
		String database = "training";
		String host = "";
		String port = "";
		String userName = "";
		String password = "";

		AsMSSql2008SqlFile export = new AsMSSql2008SqlFile(host,
				port, database, userName, password);
		assertTrue(export instanceof FileExporter);
	}

	public void testSetAndGetLocation() {
		FileExporter export = new AsMSSql2005SqlFile();
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

		FileExporter exporter = new AsMSSql2008SqlFile(host, port,
				database, userName, password);
		exporter.setLocation("");
		exporter.export();
        File file = new File("database-" + database + "-for-mssql2008.sql");
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
