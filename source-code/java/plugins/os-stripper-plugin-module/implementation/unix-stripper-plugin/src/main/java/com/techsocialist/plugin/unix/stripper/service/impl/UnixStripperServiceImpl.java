package com.techsocialist.plugin.unix.stripper.service.impl;

import com.techsocialist.plugin.unix.stripper.model.impl.UnixEnvironmentVariable;
import com.techsocialist.plugin.unix.stripper.model.impl.UnixKernelIPRoutingTableEntry;
import com.techsocialist.plugin.unix.stripper.model.impl.UnixLogin;
import com.techsocialist.plugin.unix.stripper.model.impl.UnixProcess;
import com.techsocialist.plugin.unix.stripper.model.impl.UnixSystemProperty;
import com.techsocialist.plugin.os.stripper.model.api.IEnvironmentVariable;
import com.techsocialist.plugin.os.stripper.model.api.IKernelIPRoutingTableEntry;
import com.techsocialist.plugin.os.stripper.model.api.ILogin;
import com.techsocialist.plugin.os.stripper.model.api.IProcess;
import com.techsocialist.plugin.os.stripper.model.api.ISystemProperty;
import com.techsocialist.plugin.os.stripper.service.impl.AbstractOperatingSystemStripperService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class UnixStripperServiceImpl extends AbstractOperatingSystemStripperService {

    public List<IProcess> getProcesses() throws IOException {
        //int[] columnEndIndex = {13, 16, 21, 25, 33, 38, 47, 52, 60, 65, 76};
        int[] columnEndIndex = {12, 15, 20, 24, 32, 37, 46, 51, 59, 64, 75};
        List<IProcess> processes = new ArrayList<IProcess>();

        executeOperatingSystemCommand("ps -aux");

        String output = this.getOutput();

        if (null != output && !output.isEmpty()) {
            String[] outputLines = output.split("\n");

            int linesToSkip = 1;
            int skipCounter = 0;
            for (String outputLine : outputLines) {

                if (skipCounter < linesToSkip) {
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
                String command = outputLine.substring(columnEndIndex[9] + 1, outputLine.length());

                IProcess unixProcess = new UnixProcess();
                unixProcess.setUser(user);
                unixProcess.setPID(pid);
                unixProcess.setCPUPercentage(cpuPercentage);
                unixProcess.setMemoryPercentage(memoryPercentage);
                unixProcess.setVSZ(vsz);
                unixProcess.setRSS(rss);
                unixProcess.setSTAT(stat);
                unixProcess.setStart(start);
                unixProcess.setTTY(tty);
                unixProcess.setTime(time);
                unixProcess.setCommand(command);

                processes.add(unixProcess);
            }
        }

        return processes;
    }

    public List<IEnvironmentVariable> getEnvironmentVariables() throws IOException {

        List<IEnvironmentVariable> environmentVariables = new ArrayList<IEnvironmentVariable>();

        executeOperatingSystemCommand("printenv");
        String output = this.getOutput();

        if (null != output && !output.isEmpty()) {
            String[] outputLines = output.split("\n");
            for (String outputLine : outputLines) {
                String key = outputLine.substring(0, outputLine.indexOf('='));
                String value = outputLine.substring(outputLine.indexOf('=') + 1, outputLine.length());

                IEnvironmentVariable environmentVariable = new UnixEnvironmentVariable();
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

                ISystemProperty linuxSystemProperty = new UnixSystemProperty();
                linuxSystemProperty.setKey(stringKey);
                linuxSystemProperty.setValue(properties.getProperty(stringKey));

                systemProperties.add(linuxSystemProperty);
            }
        }

        return systemProperties;
    }


    public String getInternetProtocolConfiguration() throws IOException {
        executeOperatingSystemCommand("ifconfig");
        return this.getOutput();
    }


    public List<IKernelIPRoutingTableEntry> getKernelIPRoutingTableEntries() throws IOException {
        //int[] columnEndIndex = {16, 32, 48, 58, 60, 71, 73};
        int[] columnEndIndex = {15, 31, 47, 57, 59, 70, 72};
        List<IKernelIPRoutingTableEntry> linuxKernelIPRoutingTableEntries = new ArrayList<IKernelIPRoutingTableEntry>();

        executeOperatingSystemCommand("netstat -r");

        String output = this.getOutput();

        if (null != output && !output.isEmpty()) {
            String[] outputLines = output.split("\n");

            int linesToSkip = 2;
            int skipCounter = 0;
            for (String outputLine : outputLines) {

                if (skipCounter < linesToSkip) {
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


                IKernelIPRoutingTableEntry unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry();
                unixKernelIPRoutingTableEntry.setDestination(destination);
                unixKernelIPRoutingTableEntry.setGateway(gateway);
                unixKernelIPRoutingTableEntry.setGenMask(genMask);
                unixKernelIPRoutingTableEntry.setFlags(flags);
                unixKernelIPRoutingTableEntry.setMSS(mss);
                unixKernelIPRoutingTableEntry.setWindow(window);
                unixKernelIPRoutingTableEntry.setIRTT(irtt);
                unixKernelIPRoutingTableEntry.setIFace(iface);

                linuxKernelIPRoutingTableEntries.add(unixKernelIPRoutingTableEntry);
            }
        }

        return linuxKernelIPRoutingTableEntries;
    }

    public String getCPUDetails() throws IOException {
        executeOperatingSystemCommand("lscpu");
        return this.getOutput();
    }

    public String getHardwareDetails() throws IOException {
        executeOperatingSystemCommand("lshw");
        return this.getOutput();
    }

    public List<ILogin> getLogins() throws IOException {
        //int[] columnEndIndex = {2, 6, 24, 29, 38, 48, 59};
        int[] columnEndIndex = {1, 5, 23, 28, 37, 47, 58};
        List<ILogin> unixLogins = new ArrayList<ILogin>();

        executeOperatingSystemCommand("lslogins");

        String output = this.getOutput();

        if (null != output && !output.isEmpty()) {
            String[] outputLines = output.split("\n");

            int linesToSkip = 1;
            int skipCounter = 0;
            for (String outputLine : outputLines) {

                if (skipCounter < linesToSkip) {
                    skipCounter += 1;
                    continue;
                }

                String userId = outputLine.substring(0, columnEndIndex[0]);
                String userName = outputLine.substring(columnEndIndex[0] + 1, columnEndIndex[1]);
                String proc = outputLine.substring(columnEndIndex[1] + 1, columnEndIndex[2]);
                String pwdLock = outputLine.substring(columnEndIndex[2] + 1, columnEndIndex[3]);
                String pwdDeny = outputLine.substring(columnEndIndex[3] + 1, columnEndIndex[4]);
                String lastLogin = outputLine.substring(columnEndIndex[4] + 1, columnEndIndex[5]);
                String gecos = outputLine.substring(columnEndIndex[5] + 1, outputLine.length());

                ILogin unixLogin = new UnixLogin();
                unixLogin.setUserId(userId);
                unixLogin.setUserName(userName);
                unixLogin.setPROC(proc);
                unixLogin.setPWDLock(pwdLock);
                unixLogin.setPWDDeny(pwdDeny);
                unixLogin.setLastLogin(lastLogin);
                unixLogin.setGECOS(gecos);

                unixLogins.add(unixLogin);
            }
        }

        return unixLogins;
    }
}
