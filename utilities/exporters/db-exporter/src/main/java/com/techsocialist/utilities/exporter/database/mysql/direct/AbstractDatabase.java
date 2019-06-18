package com.techsocialist.utilities.exporter.database.mysql.direct;

import com.techsocialist.utilities.exporter.database.Connection;

public abstract class AbstractDatabase implements Connection {

	protected String host;

	protected String databaseName;

	protected String username;

	protected String password;

	public AbstractDatabase() {

	}

	public AbstractDatabase(String host, String databaseName,
			String username, String password) {
		setHost(host);
		setDatabaseName(databaseName);
		setUsername(username);
		setPassword(password);
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return this.host;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
}
