package com.techsocialist.utilities.exporter.database.file;

import com.techsocialist.utilities.exporter.database.Database;
import com.techsocialist.utilities.exporter.database.mysql.factory.MySqlDatabaseFactory;

import java.io.*;
import java.sql.SQLException;

public class AsOracleSqlFile extends AsMySqlFile {

    public AsOracleSqlFile() {
        super();
    }

    public AsOracleSqlFile(String host, String port, String database,
                           String userName, String password) {
        super(host, port, database, userName, password);
        this.mysqlDB = MySqlDatabaseFactory.getInstance(Database.MYSQL_AS_ORACLE);
    }

    @Override
    public void export() {
        String url = "jdbc:mysql://" + this.host + ":" + this.port + "/"
                + this.databaseName;
        try {
            this.mysqlDB.open(url, this.username, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String fileToCreateAndUpdate = this.location + "database-"
                + this.databaseName + "-for-oracle.sql";

        File file = new File(fileToCreateAndUpdate);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            String contentToWrite = this.mysqlDB.exportAsSql(true);
            try {
                OutputStream outputStream = new FileOutputStream(file);
                try {
                    outputStream.write(contentToWrite.getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.mysqlDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
