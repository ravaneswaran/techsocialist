package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Database;
import com.techsocialist.utilities.exporter.database.Table;
import junit.framework.TestCase;
import java.sql.SQLException;
import java.util.List;


public class TestMySqlDatabaseAsMSSql2005Database extends TestCase {

	private MySqlDatabaseAsMSSql2005Database db;

	private String url = "jdbc:mysql://localhost:3306/tech_socialist";

	private String user = "root";

	private String password = "admin";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.db = new MySqlDatabaseAsMSSql2005Database();
	}

	public void testMySqlDatabaseAsMSSqlDatabaseInst() {
		MySqlDatabaseAsMSSql2005Database inst = new MySqlDatabaseAsMSSql2005Database();
		assertTrue(inst instanceof Database);
	}

	public void testOpenMethod() throws SQLException, ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		assertTrue(database.isOpen());
	}

	public void testOpenMethod_2() throws SQLException, ClassNotFoundException {
		Database database = this.db;
		String url = "jdbc:mysql://localhost";
		String user = "root";
		String password = "admin";
		String port = "3306";
		String dbName = "tech_socialist";
		database.open(url, port, dbName, user, password);
		assertTrue(database.isOpen());
	}

	public void testCloseMethod() throws SQLException, ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		database.close();
		assertFalse(database.isOpen());
	}

	public void testGetTables() throws SQLException, ClassNotFoundException {
		Database database = this.db;
        database.open(this.url, this.user, this.password);
        List<Table> tables = database.getTables();
        assertNotNull(tables);
	}

	public void testIsOpen() throws SQLException {
		Database database = this.db;
		boolean open = database.isOpen();
		assertFalse(open);
	}

	public void testExportAsSqlMethod() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String sql = database.exportAsSql(true);
		System.out.println(sql);
		assertNotNull(sql);
	}

	public void testGetTableDropStatement() {
		Database database = this.db;
		String table = "test";
		String query = database.getTableDropStatement(table);
		StringBuffer buffer = new StringBuffer();

		buffer.append("IF OBJECT_ID('").append(table).append("') IS NOT NULL")
				.append("\n");
		buffer.append("DROP TABLE ").append(table).append("\n");
		buffer.append("GO").append("\n");

		assertEquals(buffer.toString(), query);
	}

	public void testGetTableCreateStatement() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String table = "promotion_category";
		String query = database.getTableCreateStatement(table);
		assertNotNull(query);
	}

	public void testGetTableStructure() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String table = "promotion";
		String structure = database.getTableStructure(table);
		assertNotNull(structure);
	}

	public void testGetDataBaseDropStatement() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String dbName = url.substring(url.lastIndexOf("/") + 1, url.length());
		String st = database.getDatabaseDropStatement();
		StringBuffer buffer = new StringBuffer();
		buffer.append("IF OBJECT_ID('").append(dbName).append("') IS NOT NULL")
				.append("\n");
		buffer.append("DROP DATABASE ").append(dbName).append("\n");
		buffer.append("GO").append("\n");

		assertEquals(buffer.toString(), st);
	}

	public void testGetDatabaseCreateStatement() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String dbName = url.substring(url.lastIndexOf("/") + 1, url.length());
		String st = database.getDatabaseCreateStatement();
		assertEquals("CREATE DATABASE " + dbName + "\nGO\n", st);
	}

	public void testGetViewDropStatement() {
		Database database = this.db;
		String view = "test";
		String query = database.getViewDropStatement(view);

		StringBuffer buffer = new StringBuffer();
		buffer.append("IF OBJECT_ID('").append(view).append("') IS NOT NULL")
				.append("\n");
		buffer.append("DROP VIEW ").append(view).append("\n");
		buffer.append("GO").append("\n");

		assertEquals(buffer.toString(), query);
	}

	public void testGetViewCreateStatement() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String view = "promotion_view";
		String query = database.getViewCreateStatement(view);
		assertNotNull(query);
	}

	public void testGetInsertStatements() throws SQLException,
			ClassNotFoundException {
		Database database = this.db;
		database.open(this.url, this.user, this.password);
		String table = "promotion";
		String query = database.getInsertStatements(table);
		assertNotNull(query);
		
	}

	@Override
	protected void tearDown() throws Exception {
		this.db.close();
		this.db = null;
		super.tearDown();
	}
}
