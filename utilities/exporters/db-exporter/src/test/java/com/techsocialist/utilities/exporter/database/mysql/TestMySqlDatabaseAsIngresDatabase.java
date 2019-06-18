package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Database;
import com.techsocialist.utilities.exporter.database.Table;
import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.List;

public class TestMySqlDatabaseAsIngresDatabase extends TestCase{

    private MySqlDatabaseAsIngresDatabase db;

    private String url = "jdbc:mysql://localhost:3306/training";

    private String user = "root";

    private String password = "admin";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.db = new MySqlDatabaseAsIngresDatabase();
    }

    public void testMySqlDatabaseAsMSSqlDatabaseInst() {
        MySqlDatabaseAsIngresDatabase inst = new MySqlDatabaseAsIngresDatabase();
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
        String dbName = "training";
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

    public void testGetTableDropStatement() {
        Database database = this.db;
        String table = "test";
        String query = database.getTableDropStatement(table);
        assertEquals("DROP TABLE IF EXISTS " + table , query);
    }

    public void testGetDataBaseDropStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String dbName = url.substring(url.lastIndexOf("/") + 1, url.length());
        String st = database.getDatabaseDropStatement();
        assertEquals("destroydb " + dbName, st);
    }

    public void testGetViewDropStatement() {
        Database database = this.db;
        String view = "test";
        String query = database.getViewDropStatement(view);
        assertEquals("DROP VIEW IF EXISTS " + view, query);
    }

    public void testGetTableCreateStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String table = "promotion";
        String query = database.getTableCreateStatement(table);
        assertNotNull(query);
    }

    public void testGetDatabaseCreateStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String dbName = url.substring(url.lastIndexOf("/") + 1, url.length());
        String st = database.getDatabaseCreateStatement();
        assertEquals("createdb " + dbName, st);
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

    public void testGetTableStructure() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String table = "promotion";
        String structure = database.getTableStructure(table);
        assertNotNull(structure);
    }

    public void testExportAsSqlMethod() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String sql = database.exportAsSql(true);
        System.out.println(sql);
        assertNotNull(sql);
    }

    @Override
    protected void tearDown() throws Exception {
        this.db.close();
        this.db = null;
        super.tearDown();
    }

}
