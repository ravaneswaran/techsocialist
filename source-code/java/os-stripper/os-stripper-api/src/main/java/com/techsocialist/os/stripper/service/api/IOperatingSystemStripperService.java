package com.techsocialist.os.stripper.service.api;

import com.techsocialist.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.os.stripper.model.api.IProcess;
import com.techsocialist.os.stripper.model.api.ISystemProperty;

import java.io.IOException;
import java.util.List;

public interface IOperatingSystemStripperService {

    public List<IProcess> getProcesses();

    public List<IEnvironmentVariable> getEnvironmentVariables() throws IOException;

    public List<ISystemProperty> getSystemProperties();

    public String getInternetProtocolConfiguration() throws IOException;
}
