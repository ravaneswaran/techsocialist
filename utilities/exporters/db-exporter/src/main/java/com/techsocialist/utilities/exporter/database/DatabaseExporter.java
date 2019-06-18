package com.techsocialist.utilities.exporter.database;

public interface DatabaseExporter extends Exporter{

	public void setSource(Connection source);

	public Connection getSource();

	public void setTarget(Connection target);

	public Connection getTarget();

}
