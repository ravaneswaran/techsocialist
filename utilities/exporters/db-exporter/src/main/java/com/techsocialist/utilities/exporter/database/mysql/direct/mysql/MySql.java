package com.techsocialist.utilities.exporter.database.mysql.direct.mysql;

import com.techsocialist.utilities.exporter.database.mysql.direct.AbstractDatabase;

public class MySql extends AbstractDatabase {
	
	public MySql() {

	}

	public MySql(String host, String databaseName,
			String username, String password) {
		super(host, databaseName, username, password);
	}
	
}
