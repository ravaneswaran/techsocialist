package com.techsocialist.utilities.exporters.database.api;

public interface ExIm {

    public void setHost(String host);

    public String getHost();

    public void setDatabaseName(String databaseName);

    public String getDatabaseName();

    public void setUsername(String username);

    public String getUsername();

    public void setPassword(String password);

    public String getPassword();

    public String getPort();

    public void setPort(String port);
}
