package com.techsocialist.utilities.exporter.database.api;

/**
 * Created with IntelliJ IDEA.
 * User: ravenees
 * Date: 10/26/12
 * Time: 2:20 PM
 */
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
