package com.techsocialist.plugin.os.api;

import java.io.IOException;

public interface IOSCommandExecPlugin {

    public void executeCommands(String... commands) throws IOException;

    public void executeCommand(String command) throws IOException;

    public String getOutput();

    public void setOutput(String output);

    public String getError();

    public void setError(String error);
}
