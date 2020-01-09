package com.techsocialist.plugin.os.command.exec.service.api;

import java.io.IOException;

public interface IOSCommandExecService {

    public void executeCommands(String... commands) throws IOException;

    public void executeCommand(String command) throws IOException;

    public void setOutput(String output);

    public void setError(String error);

    public String getOutput();

    public String getError();
}
