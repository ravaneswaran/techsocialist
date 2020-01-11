package com.techsocialist.plugin.os.stripper.model;

import com.techsocialist.plugin.os.stripper.model.api.IProcess;

public class UnixProcess implements IProcess {

    private String user;

    private String pid;

    private String cpuPercentage;

    private String memoryPercentage;

    private String vsz;

    private String rss;

    private String stat;

    private String start;

    private String tty;

    private String time;

    private String command;

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPID() {
        return this.pid;
    }

    public void setPID(String pid) {
        this.pid = pid;
    }

    public String getCPUPercentage() {
        return this.cpuPercentage;
    }

    public void setCPUPercentage(String cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }

    public String getMemoryPercentage() {
        return this.memoryPercentage;
    }

    public void setMemoryPercentage(String memoryPercentage) {
        this.memoryPercentage = memoryPercentage;
    }

    public String getVSZ() {
        return this.vsz;
    }

    public void setVSZ(String vsz) {
        this.vsz = vsz;
    }

    public String getRSS() {
        return this.rss;
    }

    public void setRSS(String rss) {
        this.rss = rss;
    }

    public String getSTAT() {
        return this.stat;
    }

    public void setSTAT(String stat) {
        this.stat = stat;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String getTTY() {
        return this.tty;
    }

    @Override
    public void setTTY(String tty) {
        this.tty = tty;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
