package com.techsocialist.utilities.exporter.database;

public abstract class AbstractExIm implements ExIm{

    protected String host;

    protected String port;

    protected String databaseName;

    protected String username;

    protected String password;

    public AbstractExIm() {

    }

    public AbstractExIm(String host, String databaseName,
                            String username, String password) {
        setHost(host);
        setDatabaseName(databaseName);
        setUsername(username);
        setPassword(password);
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return this.host;
    }

    public void setPort(String port){
        this.port = port;
    }

    public String getPort(){
        return this.port;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    //public abstract void  test();

}
