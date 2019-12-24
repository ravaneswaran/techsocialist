package com.techsocialist.utilities.exporters.database.mysql.direct;

import com.techsocialist.utilities.exporters.database.api.Connection;
import com.techsocialist.utilities.exporters.database.api.DatabaseExporter;

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