package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.IEnvironmentVariable;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestLinuxEnvironmentVariable extends TestCase {

    private IEnvironmentVariable environmentVariable = new LinuxEnvironmentVariable();

    public void testGetSetKey(){
        String expected = "user";
        environmentVariable.setKey(expected);
        String actual = environmentVariable.getKey();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetValue(){
        String expected = "pid";
        environmentVariable.setValue(expected);
        String actual = environmentVariable.getValue();

        Assert.assertEquals(expected, actual);
    }
}
