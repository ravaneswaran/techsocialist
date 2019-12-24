package com.techsocialist.utilities.exporters.database.mysql;

import com.techsocialist.utilities.exporters.database.api.Trigger;

public class MySqlTrigger implements Trigger {
	
	private String name;
	
	private String event;
	
	private String table;
	
	private String statement;
	
	private String timing;
	
	private String created;
	
	private String sqlMode;
	
	private String definer;

	public void setName(String name) {
		this.name = name;		
	}

	public String getName() {
		return this.name;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEvent() {
		return this.event;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getTable() {
		return this.table;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getStatement() {
		return this.statement;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getTiming() {
		return this.timing;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getCreated() {
		return this.created;
	}

	public void setSqlMode(String sqlMode) {
		this.sqlMode = sqlMode;
	}

	public String getSqlMode() {
		return this.sqlMode;
	}

	public void setDefiner(String definer) {
		this.definer = definer;
	}

	public String getDefiner() {
		return this.definer;
	}

}
