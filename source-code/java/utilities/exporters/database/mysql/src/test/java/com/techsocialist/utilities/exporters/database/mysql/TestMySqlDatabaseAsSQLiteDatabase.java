package com.techsocialist.utilities.exporters.database.mysql;

import com.techsocialist.utilities.exporters.database.api.*;
import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.List;

public class TestMySqlDatabaseAsSQLiteDatabase extends TestCase {

    private MySqlDatabaseAsSQLiteDatabase db;

    private String url = "jdbc:mysql://localhost:3306/tech_socialist";

    private String user = "root";

    private String password = "admin";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.db = new MySqlDatabaseAsSQLiteDatabase();
    }

    public void testMySqlDatabaseAsSQLLiteDatabaseInst() {
        MySqlDatabaseAsSQLiteDatabase inst = new MySqlDatabaseAsSQLiteDatabase();
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

        assertEquals("DROP TABLE IF EXISTS " + table + ";\n", query);
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

    public void testGetViewDropStatement() {
        Database database = this.db;
        String view = "test";
        String query = database.getViewDropStatement(view);
        assertEquals("DROP VIEW IF EXISTS " + view + ";\n", query);
    }

    public void testGetViewCreateStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String view = "promotion_view";
        String query = database.getViewCreateStatement(view);
        assertNotNull(query);
    }

    public void testGetStoredProcedures() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        List<Procedure> procedures = database.getStoredProcedures();
        assertNull(procedures);
    }

    public void testGetStoredProcedureDropStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String storedProcedure = "test";
        String st = database.getStoredProcedureDropStatement(storedProcedure);
        assertNull(st);
    }

    public void testGetStoredProcedureCreateStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String storedProcedure = "test";
        String st = database.getStoredProcedureCreateStatement(storedProcedure);
        assertNull(st);
    }

    public void testGetFunctions() throws SQLException, ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        List<Function> functions = database.getFunctions();
        assertNull(functions);
    }

    public void testGetFunctionDropStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String function = "test";
        String st = database.getFunctionDropStatement(function);
        assertNull(st);
    }

    public void testGetFunctionCreateStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String function = "test";
        String st = database.getFunctionCreateStatement(function);
        assertNull(st);
    }

    public void testGetTriggers() throws SQLException, ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        List<Trigger> triggers = database.getTriggers();
        assertNotNull(triggers);
    }

    public void testGetTriggerDropStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String trigger = "test";
        String st = database.getTriggerDropStatement(trigger);
        assertEquals("DELIMITER $$\nDROP TRIGGER IF EXISTS `" + trigger
                + "`$$\nDELIMITER ;\n", st);
    }

    public void testGetTriggerCreateStatement() throws SQLException,
            ClassNotFoundException {
        Database database = this.db;
        database.open(this.url, this.user, this.password);
        String trigger = "promotion_trigger";
        String st = database.getTriggerCreateStatement(trigger);
        assertNotNull(st);
    }


    @Override
    protected void tearDown() throws Exception {
        this.db.close();
        this.db = null;
        super.tearDown();
    }
}
