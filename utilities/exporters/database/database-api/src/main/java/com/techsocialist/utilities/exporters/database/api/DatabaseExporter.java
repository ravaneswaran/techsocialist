package com.techsocialist.utilities.exporters.database.api;

public interface DatabaseExporter extends Exporter{

	public void setSource(Connection source);

	public Connection getSource();

	public void setTarget(Connection target);

	public Connection getTarget();

}
