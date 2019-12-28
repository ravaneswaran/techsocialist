package com.techsocialist.os.stripper.model.api.linux;

import com.techsocialist.os.stripper.model.api.IProcess;

public interface ILinuxProcess extends IProcess {

    public void setUser(String user);

    public String getUser();

    public void setPID(String pid);

    public String getPID();

    public void setCPUPercentage(String cpuPercentage);

    public String getCPUPercentage();

    public void setMemoryPercentage(String memoryPercentage);

    public String getMemoryPercentage();

    public void setVSZ(String vsz);

    public String getVSZ();

    public void setRSS(String rss);

    public String getRSS();

    public void setSTAT(String stat);

    public String getSTAT();

    public void setStart(String start);

    public String getStart();

    public void setTime(String time);

    public String getTime();

    public void setTTY(String tty);

    public String getTTY();

    public void setCommand(String command);

    public String getCommand();
}
