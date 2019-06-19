package com.techsocialist.utilities.exporter.database.mysql.exporter.file.mysql;

import com.techsocialist.utilities.exporter.database.FileExporter;
import com.techsocialist.utilities.exporter.database.file.AsMySqlFile;
import com.techsocialist.utilities.exporter.database.mysql.factory.FileExporterFactory;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class TestAsMySqlFile extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testAsMySqlFileInst() {
		AsMySqlFile export = new AsMySqlFile();
		assertTrue(export instanceof FileExporter);
	}

	public void testAsMySqllFileInst2() {
		String database = "tech_socialist";
		String host = "";
		String port = "";
		String userName = "";
		String password = "";

		AsMySqlFile export = new AsMySqlFile(host, port, database,
				userName, password);
		assertTrue(export instanceof FileExporter);
	}

	public void testSetAndGetLocation() {
		FileExporter export = FileExporterFactory.getInstance(FileExporter.AS_MYSQL_FILE);
		String path = "";
		export.setLocation(path);
		String location = export.getLocation();
		assertTrue(path.equals(location));
	}

	@Ignore
	@Test
	public void testExport() throws IOException, SQLException,
			ClassNotFoundException {
		String database = "tech_socialist";
		String host = "localhost";
		String port = "3306";
		String userName = "root";
		String password = "admin";

		FileExporter exporter = new AsMySqlFile(host, port, database,
                userName, password);
        exporter.setLocation("");
        exporter.export();
        File file = new File("database-" + database
                + "-for-mysql.sql");
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
