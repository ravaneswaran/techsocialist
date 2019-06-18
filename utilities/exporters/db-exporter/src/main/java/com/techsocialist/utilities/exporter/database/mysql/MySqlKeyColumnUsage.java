package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.KeyColumnUsage;

public class MySqlKeyColumnUsage implements KeyColumnUsage {
	
	private String tableName;
	
	private String constraintName;
	
	private String columnName;
	
	private String referencedTableName;
	
	private String referencedColumnName;

	public void setTableName(String tableName) {
		this.tableName = tableName;
		
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
		
	}

	public String getConstraintName() {
		return this.constraintName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setReferencedTableName(String referencedTableName) {
		this.referencedTableName = referencedTableName;
	}

	public String getReferencedTableName() {
		return this.referencedTableName;
	}

	public void setReferencedColumnName(String referencedColumnName) {
		this.referencedColumnName = referencedColumnName;
	}

	public String getReferencedColumnName() {
		return this.referencedColumnName;
	}

}
