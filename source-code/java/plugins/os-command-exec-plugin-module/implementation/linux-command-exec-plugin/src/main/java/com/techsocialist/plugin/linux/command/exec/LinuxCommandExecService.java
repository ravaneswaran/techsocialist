package com.techsocialist.plugin.linux.command.exec;

import com.techsocialist.plugin.os.command.exec.service.impl.AbstractOSCommandExecService;

import java.io.IOException;

public class LinuxCommandExecService extends AbstractOSCommandExecService {

    @Override
    public void executeCommand(String command) throws IOException {
        super.executeCommands("bash", "-c", command);
    }
}
