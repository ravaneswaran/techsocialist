package com.techsocialist.utilities.exporters.database.api;

public interface Trigger {

	public void setName(String name);

	public String getName();

	public void setEvent(String event);

	public String getEvent();

	public void setTable(String table);

	public String getTable();

	public void setStatement(String statement);

	public String getStatement();

	public void setTiming(String timing);

	public String getTiming();

	public void setCreated(String created);

	public String getCreated();

	public void setSqlMode(String sqlMode);

	public String getSqlMode();

	public void setDefiner(String definer);

	public String getDefiner();

}
