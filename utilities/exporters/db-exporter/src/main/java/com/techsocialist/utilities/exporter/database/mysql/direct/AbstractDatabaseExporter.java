package com.techsocialist.utilities.exporter.database.mysql.direct;

import com.techsocialist.utilities.exporter.database.Connection;
import com.techsocialist.utilities.exporter.database.DatabaseExporter;

public abstract class AbstractDatabaseExporter implements DatabaseExporter {

	protected Connection source;
	
	protected Connection target;

	public void setSource(Connection source) {
		this.source = source;
	}

	public Connection getSource() {
		return this.source;
	}
	
	public void setTarget(Connection target) {
		this.target = target;
	}

	public Connection getTarget() {
		return this.target;
	}

}