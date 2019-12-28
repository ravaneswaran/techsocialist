package com.techsocialist.linux.stripper.service.impl;

import com.techsocialist.linux.stripper.model.impl.LinuxEnvironmentVariable;
import com.techsocialist.linux.stripper.model.impl.LinuxKernelIPRoutingTableEntry;
import com.techsocialist.linux.stripper.model.impl.LinuxProcess;
import com.techsocialist.linux.stripper.model.impl.LinuxSystemProperty;
import com.techsocialist.os.stripper.model.api.*;
import com.techsocialist.os.stripper.service.impl.LinuxStripperService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class LinuxStripperServiceImpl extends LinuxStripperService {

    public List<IProcess> getProcesses() throws IOException {
        int[] columnEndIndex = {13, 16, 21, 25, 33, 38, 47, 52, 60, 65, 76};
        List<IProcess> processes = new ArrayList<IProcess>();

        executeOperatingSystemCommand("ps -aux");

        String output = this.getOutput();

        if(null != output && !output.isEmpty()){
            String[] outputLines = output.split("\n");

            int linesToSkip = 1;
            int skipCounter = 0;
            for(String outputLine : outputLines){

                if(skipCounter < linesToSkip){
                    skipCounter += 1;
                    continue;
                }

                String user = outputLine.substring(0, columnEndIndex[0]);
                String pid = outputLine.substring(columnEndIndex[0] + 1, columnEndIndex[1]);
                String cpuPercentage = outputLine.substring(columnEndIndex[1] + 1, columnEndIndex[2]);
                String memoryPercentage = outputLine.substring(columnEndIndex[2] + 1, columnEndIndex[3]);
                String vsz = outputLine.substring(columnEndIndex[3] + 1, columnEndIndex[4]);
                String rss = outputLine.substring(columnEndIndex[4] + 1, columnEndIndex[5]);
                String tty = outputLine.substring(columnEndIndex[5] + 1, columnEndIndex[6]);
                String stat = outputLine.substring(columnEndIndex[6] + 1, columnEndIndex[7]);
                String start = outputLine.substring(columnEndIndex[7] + 1, columnEndIndex[8]);
                String time = outputLine.substring(columnEndIndex[8] + 1, columnEndIndex[9]);
                String command = outputLine.substring(columnEndIndex[9]+1, outputLine.length());

                ILinuxProcess linuxProcess = new LinuxProcess();
                linuxProcess.setUser(user);
                linuxProcess.setPID(pid);
                linuxProcess.setCPUPercentage(cpuPercentage);
                linuxProcess.setMemoryPercentage(memoryPercentage);
                linuxProcess.setVSZ(vsz);
                linuxProcess.setRSS(rss);
                linuxProcess.setSTAT(stat);
                linuxProcess.setStart(start);
                linuxProcess.setTTY(tty);
                linuxProcess.setTime(time);
                linuxProcess.setCommand(command);

                processes.add(linuxProcess);
            }
        }

        return processes;
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


    @Override
    public List<ILinuxKernelIPRoutingTableEntry> getLinuxKernelIPRoutingTableEntries() throws IOException {
        int[] columnEndIndex = {16, 32, 48, 58, 60, 71, 73};
        List<ILinuxKernelIPRoutingTableEntry> linuxKernelIPRoutingTableEntries = new ArrayList<ILinuxKernelIPRoutingTableEntry>();

        executeOperatingSystemCommand("netstat -r");

        String output = this.getOutput();

        if(null != output && !output.isEmpty()){
            String[] outputLines = output.split("\n");

            int linesToSkip = 2;
            int skipCounter = 0;
            for(String outputLine : outputLines){

                if(skipCounter < linesToSkip){
                    skipCounter += 1;
                    continue;
                }

                String destination = outputLine.substring(0, columnEndIndex[0]);
                String gateway = outputLine.substring(columnEndIndex[0] + 1, columnEndIndex[1]);
                String genMask = outputLine.substring(columnEndIndex[1] + 1, columnEndIndex[2]);
                String flags = outputLine.substring(columnEndIndex[2] + 1, columnEndIndex[3]);
                String mss = outputLine.substring(columnEndIndex[3] + 1, columnEndIndex[4]);
                String window = outputLine.substring(columnEndIndex[4] + 1, columnEndIndex[5]);
                String irtt = outputLine.substring(columnEndIndex[5] + 1, columnEndIndex[6]);
                String iface = outputLine.substring(columnEndIndex[6] + 1, outputLine.length());


                ILinuxKernelIPRoutingTableEntry linuxKernelIPRoutingTableEntry = new LinuxKernelIPRoutingTableEntry();
                linuxKernelIPRoutingTableEntry.setDestination(destination);
                linuxKernelIPRoutingTableEntry.setGateway(gateway);
                linuxKernelIPRoutingTableEntry.setGenMask(genMask);
                linuxKernelIPRoutingTableEntry.setFlags(flags);
                linuxKernelIPRoutingTableEntry.setMSS(mss);
                linuxKernelIPRoutingTableEntry.setWindow(window);
                linuxKernelIPRoutingTableEntry.setIRTT(irtt);
                linuxKernelIPRoutingTableEntry.setIFace(iface);

                linuxKernelIPRoutingTableEntries.add(linuxKernelIPRoutingTableEntry);
            }
        }

        return linuxKernelIPRoutingTableEntries;
    }
}
