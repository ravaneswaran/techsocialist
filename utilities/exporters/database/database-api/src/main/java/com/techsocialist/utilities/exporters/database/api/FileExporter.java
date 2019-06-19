package com.techsocialist.utilities.exporters.database.api;

public interface FileExporter extends Exporter{

    public int AS_MYSQL_FILE = 1;

    public int AS_MSSQL2005_FILE = 2;

    public int AS_MSSQL2008_FILE = 4;

    public int AS_ORACLE_FILE = 8;

    public int AS_POSTGRESQL_FILE = 16;

    public int AS_SQLITE_FILE = 32;

    public int AS_INGRES_FILE = 64;

    public void setLocation(String path);

	public String getLocation();

}
