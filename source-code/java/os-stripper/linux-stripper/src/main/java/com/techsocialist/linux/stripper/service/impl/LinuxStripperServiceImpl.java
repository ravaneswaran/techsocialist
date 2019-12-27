package com.techsocialist.linux.stripper.service.impl;

import com.techsocialist.linux.stripper.model.impl.LinuxEnvironmentVariable;
import com.techsocialist.linux.stripper.model.impl.LinuxSystemProperty;
import com.techsocialist.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.os.stripper.model.api.ILinuxSystemProperty;
import com.techsocialist.os.stripper.model.api.IProcess;
import com.techsocialist.os.stripper.model.api.ISystemProperty;
import com.techsocialist.os.stripper.service.impl.LinuxStripperService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class LinuxStripperServiceImpl extends LinuxStripperService {

    public List<IProcess> getProcesses() {
        return null;
    }

    public List<IEnvironmentVariable> getEnvironmentVariables() throws IOException {

        List<IEnvironmentVariable> environmentVariables = new ArrayList<IEnvironmentVariable>();

        executeOperatingSystemCommand("printenv");
        String output = this.getOutput();

        if(null != output && !output.isEmpty()){
            String[] outputLines = output.split("\n");
            for(String outputLine : outputLines){
                String key = outputLine.substring(0, outputLine.indexOf('='));
                String value = outputLine.substring(outputLine.indexOf('=') + 1, outputLine.length());

                IEnvironmentVariable environmentVariable = new LinuxEnvironmentVariable();
                environmentVariable.setKey(key);
                environmentVariable.setValue(value);

                environmentVariables.add(environmentVariable);
            }
        }

        return environmentVariables;
    }

    public List<ISystemProperty> getSystemProperties() {
        List<ISystemProperty> systemProperties = new ArrayList<ISystemProperty>();
        Properties properties = System.getProperties();
        Iterator<Object> iterator = properties.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();

            if (key instanceof String) {
                String stringKey = (String) key;

                ILinuxSystemProperty linuxSystemProperty = new LinuxSystemProperty();
                linuxSystemProperty.setKey(stringKey);
                linuxSystemProperty.setValue(properties.getProperty(stringKey));

                systemProperties.add(linuxSystemProperty);
            }
        }

        return systemProperties;
    }

    @Override
    public String getInternetProtocolConfiguration() throws IOException {
        executeOperatingSystemCommand("ifconfig");
        return this.getOutput();
    }
}
