package com.techsocialist.plugin.os.stripper.impl;

import com.techsocialist.plugin.os.impl.AbstractOSCommandExecPlugin;
import com.techsocialist.plugin.os.stripper.api.IOperatingSystemStripperPlugin;

import java.io.IOException;

public abstract class AbstractOperatingSystemStripperPlugin extends AbstractOSCommandExecPlugin implements IOperatingSystemStripperPlugin {

    public void executeOperatingSystemCommand(String command) throws IOException {
        super.executeCommands("bash", "-c", command);
    }
}
