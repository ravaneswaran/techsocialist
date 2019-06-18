package com.techsocialist.utilities.exporter.database.mysql.factory;

import com.techsocialist.utilities.exporter.database.Database;
import com.techsocialist.utilities.exporter.database.mysql.*;

public class MySqlDatabaseFactory {

    public static Database getInstance(int database) {

        Database databaseInst = null;

        switch (database) {
            case Database.MYSQL:
                databaseInst = new MySqlDatabase();
                break;
            case Database.MYSQL_AS_MSSQL_2005:
                databaseInst = new MySqlDatabaseAsMSSql2005Database();
                break;
            case Database.MYSQL_AS_MSSQL_2008:
                databaseInst = new MySqlDatabaseAsMSSql2008Database();
                break;
            case Database.MYSQL_AS_ORACLE:
                databaseInst = new MySqlDatabaseAsOracleDatabase();
                break;
            case Database.MYSQL_AS_SQL_LITE:
                databaseInst = new MySqlDatabaseAsSQLiteDatabase();
                break;
            case Database.MYSQL_AS_POSTGRES:
                databaseInst = new MySqlDatabaseAsPostgreSqlDatabase();
                break;
            case Database.MYSQL_AS_INGRES:
                databaseInst = new MySqlDatabaseAsIngresDatabase();
                break;
        }

        return databaseInst;
    }
}