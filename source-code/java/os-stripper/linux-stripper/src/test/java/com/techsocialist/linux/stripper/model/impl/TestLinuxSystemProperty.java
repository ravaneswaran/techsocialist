package com.techsocialist.linux.stripper.model.impl;

import com.techsocialist.os.stripper.model.api.ISystemProperty;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestLinuxSystemProperty extends TestCase {

    ISystemProperty systemProperty = new LinuxSystemProperty();

    public void testGetSetKey(){
        String expected = "user";
        systemProperty.setKey(expected);
        String actual = systemProperty.getKey();

        Assert.assertEquals(expected, actual);
    }

    public void testGetSetValue(){
        String expected = "pid";
        systemProperty.setValue(expected);
        String actual = systemProperty.getValue();

        Assert.assertEquals(expected, actual);
    }

}
