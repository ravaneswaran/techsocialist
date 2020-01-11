package com.techsocialist.plugin.os;

import com.techsocialist.plugin.os.impl.AbstractOSCommandExecPlugin;

import java.io.IOException;

public class LinuxCommandExecPlugin extends AbstractOSCommandExecPlugin {

    @Override
    public void executeCommand(String command) throws IOException {
        super.executeCommands("bash", "-c", command);
    }

}
