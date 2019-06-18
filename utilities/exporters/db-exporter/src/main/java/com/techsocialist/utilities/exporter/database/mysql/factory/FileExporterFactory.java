package com.techsocialist.utilities.exporter.database.mysql.factory;

import com.techsocialist.utilities.exporter.database.ExIm;
import com.techsocialist.utilities.exporter.database.FileExporter;
import com.techsocialist.utilities.exporter.database.mysql.file.mysql.*;

public class FileExporterFactory {


    public static FileExporter getInstance(int fileExporter) {
        FileExporter exporter = null;
        switch (fileExporter) {
            case FileExporter.AS_MYSQL_FILE:
                exporter = new AsMySqlFile();
                break;
            case FileExporter.AS_MSSQL2005_FILE:
                exporter = new AsMSSql2005SqlFile();
                break;
            case FileExporter.AS_MSSQL2008_FILE:
                exporter = new AsMSSql2008SqlFile();
                break;
            case FileExporter.AS_ORACLE_FILE:
                exporter = new AsOracleSqlFile();
                break;
            case FileExporter.AS_POSTGRESQL_FILE:
                exporter = new AsPostgreSqlFile();
                break;
            case FileExporter.AS_SQLITE_FILE:
                exporter = new AsSQLiteSqlFile();
                break;

            case FileExporter.AS_INGRES_FILE:
                exporter = new AsIngresSqlFile();
                break;
        }
        return exporter;
    }

    public static FileExporter getInstance(int fileExporter, String host, String port, String database, String userName, String password) {
        FileExporter exporter = getInstance(fileExporter);

        if(exporter != null){
            ExIm exIm = (ExIm)exporter;
            exIm.setHost(host);
            exIm.setPort(port);
            exIm.setDatabaseName(database);
            exIm.setUsername(userName);
            exIm.setPassword(password);
        }

        return exporter;
    }
}
