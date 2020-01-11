package com.techsocialist.plugin.os.stripper.model.api;

public interface IProcess {

    public String getUser();

    public void setUser(String user);

    public String getPID();

    public void setPID(String pid);

    public String getCPUPercentage();

    public void setCPUPercentage(String cpuPercentage);

    public String getMemoryPercentage();

    public void setMemoryPercentage(String memoryPercentage);

    public String getVSZ();

    public void setVSZ(String vsz);

    public String getRSS();

    public void setRSS(String rss);

    public String getSTAT();

    public void setSTAT(String stat);

    public String getStart();

    public void setStart(String start);

    public String getTime();

    public void setTime(String time);

    public String getTTY();

    public void setTTY(String tty);

    public String getCommand();

    public void setCommand(String command);

}





