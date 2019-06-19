package com.techsocialist.utilities.exporters.database.factory.database;


import com.techsocialist.utilities.exporters.database.api.Database;
import com.techsocialist.utilities.exporters.database.mysql.factory.MySqlDatabaseFactory;
import junit.framework.TestCase;

public class TestMySqlDatabaseFactory extends TestCase {

    public void testMySqlDatabase() {
        int database = Database.MYSQL;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsMSSql2005Database() {
        int database = Database.MYSQL_AS_MSSQL_2005;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabaseAsMSSql2005Database",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsMSSql2008Database() {
        int database = Database.MYSQL_AS_MSSQL_2008;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabaseAsMSSql2008Database",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsOracleDatabase() {
        int database = Database.MYSQL_AS_ORACLE;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabaseAsOracleDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsSQLiteDatabase() {
        int database = Database.MYSQL_AS_SQL_LITE;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabaseAsSQLiteDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsPostgreSqlDatabase() {
        int database = Database.MYSQL_AS_POSTGRES;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabaseAsPostgreSqlDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsIngresDatabase() {
        int database = Database.MYSQL_AS_INGRES;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.techsocialist.utilities.exporters.database.mysql.MySqlDatabaseAsIngresDatabase",databaseInst.getClass().getName());
    }

}
