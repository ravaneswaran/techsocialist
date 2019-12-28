package com.techsocialist.linux.stripper.service.impl;

import com.techsocialist.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.os.stripper.model.api.ILinuxKernelIPRoutingTableEntry;
import com.techsocialist.os.stripper.model.api.IProcess;
import com.techsocialist.os.stripper.model.api.ISystemProperty;
import com.techsocialist.os.stripper.service.api.ILinuxStripperService;
import com.techsocialist.os.stripper.util.OperatingSystemStripperUtil;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

public class TestLinuxStripperService extends TestCase {

    public void testLinuxStripperServiceInstance() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService("com.techsocialist.linux.stripper.service.impl.LinuxStripperServiceImpl");
        Assert.assertTrue(null != linuxStripperService);
    }

    public void testGetSystemProperties() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService("com.techsocialist.linux.stripper.service.impl.LinuxStripperServiceImpl");
        List<ISystemProperty> systemProperties = linuxStripperService.getSystemProperties();
        Assert.assertTrue(null != systemProperties && systemProperties.size() > 0);
    }

    public void testGetEnvironmentProperties() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService("com.techsocialist.linux.stripper.service.impl.LinuxStripperServiceImpl");
        List<IEnvironmentVariable> environmentVariables = linuxStripperService.getEnvironmentVariables();
        Assert.assertTrue(null != environmentVariables && environmentVariables.size() > 0);
    }

    public void testGetInternetProtocolConfiguration() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService("com.techsocialist.linux.stripper.service.impl.LinuxStripperServiceImpl");
        String intenetProtocolConfiguration = linuxStripperService.getInternetProtocolConfiguration();
        Assert.assertTrue(null != intenetProtocolConfiguration && intenetProtocolConfiguration.length() > 0);
    }

    public void testGetProcesses() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService("com.techsocialist.linux.stripper.service.impl.LinuxStripperServiceImpl");
        List<IProcess> processes = linuxStripperService.getProcesses();
        Assert.assertTrue(null != processes && processes.size() > 0);
    }

    public void testGetLinuxKernelIPRoutingTableEntries() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService("com.techsocialist.linux.stripper.service.impl.LinuxStripperServiceImpl");
        List<ILinuxKernelIPRoutingTableEntry> linuxKernelIPRoutingTableEntries = linuxStripperService.getLinuxKernelIPRoutingTableEntries();
        Assert.assertTrue(null != linuxKernelIPRoutingTableEntries && linuxKernelIPRoutingTableEntries.size() > 0);
    }

}
