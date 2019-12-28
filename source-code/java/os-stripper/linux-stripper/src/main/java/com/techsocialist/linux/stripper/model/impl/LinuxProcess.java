package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.linux.ILinuxProcess;

public class LinuxProcess implements ILinuxProcess {

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

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return this.user;
    }

    public void setPID(String pid) {
        this.pid = pid;
    }

    public String getPID() {
        return this.pid;
    }

    public void setCPUPercentage(String cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }

    public String getCPUPercentage() {
        return this.cpuPercentage;
    }

    public void setMemoryPercentage(String memoryPercentage) {
        this.memoryPercentage = memoryPercentage;
    }

    public String getMemoryPercentage() {
        return this.memoryPercentage;
    }

    public void setVSZ(String vsz) {
        this.vsz = vsz;
    }

    public String getVSZ() {
        return this.vsz;
    }

    public void setRSS(String rss) {
        this.rss = rss;
    }

    public String getRSS() {
        return this.rss;
    }

    public void setSTAT(String stat) {
        this.stat = stat;
    }

    public String getSTAT() {
        return this.stat;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStart() {
        return this.start;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public void setTTY(String tty) {
        this.tty = tty;
    }

    @Override
    public String getTTY() {
        return this.tty;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
