package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Table;

import java.util.List;

public class MySqlTable implements Table {

	private String name;

	private String type;
	
	private List<Table> parents;
	
	private boolean evaluated;

	public MySqlTable() {

	}

	public MySqlTable(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public List<Table> getParentTables() {
		return this.parents;
	}

	public void setParentTables(List<Table> tables) {
		this.parents = tables;
	}

	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}

	public boolean isEvaluated() {
		return this.evaluated;
	}
}
