package com.techsocialist.utilities.exporters.database.api;

import java.util.List;


public interface Table {
	
	public String BASE_TABLE = "BASE TABLE";
	
	public String VIEW = "VIEW";

	public void setName(String name);

	public void setType(String type);

	public String getName();

	public String getType();

	public List<Table> getParentTables();

	public void setParentTables(List<Table> tables);

	public void setEvaluated(boolean b);

	public boolean isEvaluated();
	
}
