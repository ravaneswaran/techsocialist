package com.techsocialist.utilities.exporters.database.mysql.file;

import com.techsocialist.utilities.exporters.database.api.Database;
import com.techsocialist.utilities.exporters.database.mysql.factory.MySqlDatabaseFactory;

import java.io.*;
import java.sql.SQLException;

public class AsPostgreSqlFile extends AsMySqlFile {


    public AsPostgreSqlFile() {
        super();
    }

    public AsPostgreSqlFile(String host, String port, String database, String userName, String password) {
        super(host, port, database, userName, password);
        this.mysqlDB = MySqlDatabaseFactory.getInstance(Database.MYSQL_AS_POSTGRES);
    }

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
                + this.databaseName + "-for-postgres.sql";

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