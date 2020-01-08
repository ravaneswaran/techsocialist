package com.techsocialist.plugin.os.stripper.service.api;

import com.techsocialist.plugin.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.plugin.os.stripper.model.api.IKernelIPRoutingTableEntry;
import com.techsocialist.plugin.os.stripper.model.api.ILogin;
import com.techsocialist.plugin.os.stripper.model.api.IProcess;
import com.techsocialist.plugin.os.stripper.model.api.ISystemProperty;

import java.io.IOException;
import java.util.List;

public interface IOperatingSystemStripperService {

    public List<IKernelIPRoutingTableEntry> getKernelIPRoutingTableEntries() throws IOException;

    public String getCPUDetails() throws IOException;

    public String getHardwareDetails() throws IOException;

    public List<ILogin> getLogins() throws IOException;

    public List<IProcess> getProcesses() throws IOException;

    public List<IEnvironmentVariable> getEnvironmentVariables() throws IOException;

    public List<ISystemProperty> getSystemProperties();

    public String getInternetProtocolConfiguration() throws IOException;
}
