package com.techsocialist.os.stripper.service.api;

import com.techsocialist.os.stripper.model.api.linux.ILinuxKernelIPRoutingTableEntry;
import com.techsocialist.os.stripper.model.api.linux.ILinuxLogin;

import java.io.IOException;
import java.util.List;

public interface ILinuxStripperService extends IOperatingSystemStripperService {

    public List<ILinuxKernelIPRoutingTableEntry> getLinuxKernelIPRoutingTableEntries() throws IOException;

    public String getCPUDetails() throws IOException;

    public String getHardwareDetails() throws IOException;

    public List<ILinuxLogin> getLogins() throws IOException;
}
