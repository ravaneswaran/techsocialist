package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.linux.ILinuxCPU;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestLinuxCPUDetail extends TestCase {

    ILinuxCPU linuxCPU = new LinuxCPU();

    public void testGetSetWindow(){
        String expected = "user";
        linuxCPU.setCPUDetail(expected);
        String actual = linuxCPU.getCPUDetail();

        Assert.assertEquals(expected, actual);
    }

}
