package com.techsocialist.plugin.os.command.exec.service.impl;

import com.techsocialist.plugin.os.command.exec.service.api.IOSCommandExecService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractOSCommandExecService implements IOSCommandExecService {

    private String output;

    private String error;

    @Override
    public void executeCommand(String command) throws IOException {
        // run the Unix "ps -ef" command using the Runtime exec method:
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // read the output from the command
        StringBuilder outputStringBuilder = new StringBuilder();
        String outputString = null;
        while ((outputString = stdInput.readLine()) != null) {
            outputStringBuilder.append(outputString).append("\n");
        }

        // read any errors from the attempted command
        StringBuilder errorStringBuilder = new StringBuilder();
        String errorString = null;
        while ((errorString = stdError.readLine()) != null) {
            errorStringBuilder.append(errorString).append("\n");
        }

        stdInput.close();
        stdError.close();

        this.setOutput(outputStringBuilder.toString());
        this.setError(errorStringBuilder.toString());
    }

    @Override
    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getOutput() {
        return output;
    }

    @Override
    public String getError() {
        return error;
    }
}
