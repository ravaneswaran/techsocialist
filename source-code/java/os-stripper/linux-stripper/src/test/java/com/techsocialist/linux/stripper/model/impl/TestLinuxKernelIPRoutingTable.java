package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.linux.ILinuxKernelIPRoutingTableEntry;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestLinuxKernelIPRoutingTable extends TestCase {

    private ILinuxKernelIPRoutingTableEntry linuxKernelIPRoutingTable = new LinuxKernelIPRoutingTableEntry();

    public void testGetSetDestination(){
        String expected = "user";
        linuxKernelIPRoutingTable.setDestination(expected);
        String actual = linuxKernelIPRoutingTable.getDestination();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetGateway(){
        String expected = "user";
        linuxKernelIPRoutingTable.setGateway(expected);
        String actual = linuxKernelIPRoutingTable.getGateway();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetGenMask(){
        String expected = "user";
        linuxKernelIPRoutingTable.setGenMask(expected);
        String actual = linuxKernelIPRoutingTable.getGenMask();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetFlags(){
        String expected = "user";
        linuxKernelIPRoutingTable.setFlags(expected);
        String actual = linuxKernelIPRoutingTable.getFlags();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetMSS(){
        String expected = "user";
        linuxKernelIPRoutingTable.setMSS(expected);
        String actual = linuxKernelIPRoutingTable.getMSS();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetWindow(){
        String expected = "user";
        linuxKernelIPRoutingTable.setWindow(expected);
        String actual = linuxKernelIPRoutingTable.getWindow();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetIRTT(){
        String expected = "user";
        linuxKernelIPRoutingTable.setIRTT(expected);
        String actual = linuxKernelIPRoutingTable.getIRTT();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetIFace(){
        String expected = "user";
        linuxKernelIPRoutingTable.setIFace(expected);
        String actual = linuxKernelIPRoutingTable.getIFace();

        Assert.assertEquals(expected, actual);
    }
}
