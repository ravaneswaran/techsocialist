package com.techsocialist.os.stripper.service.api;

import com.techsocialist.os.stripper.model.api.ILinuxKernelIPRoutingTableEntry;

import java.io.IOException;
import java.util.List;

public interface ILinuxStripperService extends IOperatingSystemStripperService {

    public List<ILinuxKernelIPRoutingTableEntry> getLinuxKernelIPRoutingTableEntries() throws IOException;

}
