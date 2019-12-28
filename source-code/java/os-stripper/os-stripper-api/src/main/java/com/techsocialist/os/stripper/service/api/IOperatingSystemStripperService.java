package com.techsocialist.os.stripper.service.api;

import com.techsocialist.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.os.stripper.model.api.IProcess;
import com.techsocialist.os.stripper.model.api.ISystemProperty;

import java.io.IOException;
import java.util.List;

public interface IOperatingSystemStripperService {

    public static final String OPERATING_SYSTEM_STRIPPER_SERVICE_IMPLEMENTATION = "techsocialist.os.stripper.service";

    public static final String UNIX_STRIPPER_SERVICE_IMPLEMENTATION = "techsocialist.unix.stripper.service";
    public static final String LINUX_STRIPPER_SERVICE_IMPLEMENTATION = "techsocialist.linux.stripper.service";
    public static final String WINDOWS_STRIPPER_SERVICE_IMPLEMENTATION = "techsocialist.windows.stripper.service";
    public static final String SOLARIS_STRIPPER_SERVICE_IMPLEMENTATION = "techsocialist.solaris.stripper.service";

    public List<IProcess> getProcesses() throws IOException;

    public List<IEnvironmentVariable> getEnvironmentVariables() throws IOException;

    public List<ISystemProperty> getSystemProperties();

    public String getInternetProtocolConfiguration() throws IOException;
}
