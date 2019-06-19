package com.techsocialist.utilities.exporters.database.api;

public interface KeyColumnUsage {

	public void setTableName(String tableName);

	public String getTableName();

	public void setConstraintName(String constraintName);

	public String getConstraintName();

	public void setColumnName(String columnName);

	public String getColumnName();

	public void setReferencedTableName(String referencedTableName);

	public String getReferencedTableName();

	public void setReferencedColumnName(String referencedColumnName);

	public String getReferencedColumnName();

}
