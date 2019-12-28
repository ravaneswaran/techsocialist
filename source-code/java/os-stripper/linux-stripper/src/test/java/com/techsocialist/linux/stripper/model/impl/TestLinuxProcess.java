package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.linux.ILinuxProcess;
import junit.framework.Assert;
import junit.framework.TestCase;


public class TestLinuxProcess extends TestCase {

    private ILinuxProcess linuxProcess = new LinuxProcess();

    public void testGetSetUserMethod(){
        String expected = "user";
        linuxProcess.setUser(expected);
        String actual = linuxProcess.getUser();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetPIDMethod(){
        String expected = "pid";
        linuxProcess.setPID(expected);
        String actual = linuxProcess.getPID();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetCPUPercentage(){
        String expected = "";
        linuxProcess.setCPUPercentage(expected);
        String actual = linuxProcess.getCPUPercentage();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetMemoryPercentage(){
        String expected = "";
        linuxProcess.setMemoryPercentage(expected);
        String actual = linuxProcess.getMemoryPercentage();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetVSZ(){
        String expected = "";
        linuxProcess.setVSZ(expected);
        String actual = linuxProcess.getVSZ();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetRSS(){
        String expected = "";
        linuxProcess.setRSS(expected);
        String actual = linuxProcess.getRSS();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetSTAT(){
        String expected = "";
        linuxProcess.setSTAT(expected);
        String actual = linuxProcess.getSTAT();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetStart(){
        String expected = "";
        linuxProcess.setStart(expected);
        String actual = linuxProcess.getStart();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetTime(){
        String expected = "";
        linuxProcess.setTime(expected);
        String actual = linuxProcess.getTime();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetCommand(){
        String expected = "";
        linuxProcess.setCommand(expected);
        String actual = linuxProcess.getCommand();

        Assert.assertEquals(expected, actual);
    }

    public void testSetGetTTY(){
        String expected = "";
        linuxProcess.setTTY(expected);
        String actual = linuxProcess.getTTY();

        Assert.assertEquals(expected, actual);
    }

}
