package com.techsocialist.linux.stripper.service.impl;

import com.techsocialist.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.os.stripper.model.api.linux.ILinuxKernelIPRoutingTableEntry;
import com.techsocialist.os.stripper.model.api.IProcess;
import com.techsocialist.os.stripper.model.api.ISystemProperty;
import com.techsocialist.os.stripper.model.api.linux.ILinuxLogin;
import com.techsocialist.os.stripper.service.api.ILinuxStripperService;
import com.techsocialist.os.stripper.service.api.IOperatingSystemStripperService;
import com.techsocialist.os.stripper.util.OperatingSystemStripperUtil;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

public class TestLinuxStripperService extends TestCase {

    static {
        System.setProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION, LinuxStripperServiceImpl.class.getName());
    }

    public void testLinuxStripperServiceInstance() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        Assert.assertTrue(null != linuxStripperService);
    }

    public void testGetSystemProperties() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        List<ISystemProperty> systemProperties = linuxStripperService.getSystemProperties();
        Assert.assertTrue(null != systemProperties && systemProperties.size() > 0);
    }

    public void testGetEnvironmentProperties() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        List<IEnvironmentVariable> environmentVariables = linuxStripperService.getEnvironmentVariables();
        Assert.assertTrue(null != environmentVariables && environmentVariables.size() > 0);
    }

    public void testGetInternetProtocolConfiguration() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        String intenetProtocolConfiguration = linuxStripperService.getInternetProtocolConfiguration();
        Assert.assertTrue(null != intenetProtocolConfiguration && intenetProtocolConfiguration.length() > 0);
    }

    public void testGetProcesses() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        List<IProcess> processes = linuxStripperService.getProcesses();
        Assert.assertTrue(null != processes && processes.size() > 0);
    }

    public void testGetLinuxKernelIPRoutingTableEntries() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        List<ILinuxKernelIPRoutingTableEntry> linuxKernelIPRoutingTableEntries = linuxStripperService.getLinuxKernelIPRoutingTableEntries();
        Assert.assertTrue(null != linuxKernelIPRoutingTableEntries && linuxKernelIPRoutingTableEntries.size() > 0);
    }

    public void testGetCPUDetails() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        String details = linuxStripperService.getCPUDetails();
        Assert.assertTrue(null != details && details.length() > 0);
    }

    public void testGetHardwareDetails() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        String details = linuxStripperService.getHardwareDetails();
        Assert.assertTrue(null != details && details.length() > 0);
    }

    public void testGetLogins() throws Exception {
        ILinuxStripperService linuxStripperService = OperatingSystemStripperUtil.getLinuxStripperService(System.getProperty(IOperatingSystemStripperService.OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION));
        List<ILinuxLogin> logins = linuxStripperService.getLogins();
        Assert.assertTrue(null != logins && logins.size() > 0);
    }
}
