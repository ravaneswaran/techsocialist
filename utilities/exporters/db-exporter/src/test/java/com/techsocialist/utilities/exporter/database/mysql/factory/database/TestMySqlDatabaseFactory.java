package com.techsocialist.utilities.exporter.database.mysql.factory.database;

import com.congruent.db.Database;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/29/12
 * Time: 11:38 AM
 */
public class TestMySqlDatabaseFactory extends TestCase {

    public void testMySqlDatabase() {
        int database = Database.MYSQL;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsMSSql2005Database() {
        int database = Database.MYSQL_AS_MSSQL_2005;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabaseAsMSSql2005Database",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsMSSql2008Database() {
        int database = Database.MYSQL_AS_MSSQL_2008;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabaseAsMSSql2008Database",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsOracleDatabase() {
        int database = Database.MYSQL_AS_ORACLE;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabaseAsOracleDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsSQLiteDatabase() {
        int database = Database.MYSQL_AS_SQL_LITE;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabaseAsSQLiteDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsPostgreSqlDatabase() {
        int database = Database.MYSQL_AS_POSTGRES;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabaseAsPostgreSqlDatabase",databaseInst.getClass().getName());
    }

    public void testMySqlDatabaseAsIngresDatabase() {
        int database = Database.MYSQL_AS_INGRES;
        Database databaseInst = MySqlDatabaseFactory.getInstance(database);
        assertTrue(databaseInst != null);
        assertEquals("com.congruent.db.mysql.MySqlDatabaseAsIngresDatabase",databaseInst.getClass().getName());
    }

}
