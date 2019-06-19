package com.techsocialist.utilities.exporter.database.file;

import com.techsocialist.utilities.exporter.database.AbstractExIm;
import com.techsocialist.utilities.exporter.database.Database;
import com.techsocialist.utilities.exporter.database.FileExporter;
import com.techsocialist.utilities.exporter.database.mysql.factory.MySqlDatabaseFactory;

import java.io.*;
import java.sql.SQLException;

public class AsMySqlFile extends AbstractExIm implements FileExporter {

	protected String location;

	protected Database mysqlDB;

	public AsMySqlFile() {

	}

	public AsMySqlFile(String host, String port, String database,
			String userName, String password) {
		this.host = host;
		this.port = port;
		this.databaseName = database;
		this.username = userName;
		this.password = password;
		this.mysqlDB = MySqlDatabaseFactory.getInstance(Database.MYSQL);
	}

	public void setLocation(String path) {
		this.location = path;
	}

	public String getLocation() {
		return this.location;
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
				+ this.databaseName + "-for-mysql.sql";

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
