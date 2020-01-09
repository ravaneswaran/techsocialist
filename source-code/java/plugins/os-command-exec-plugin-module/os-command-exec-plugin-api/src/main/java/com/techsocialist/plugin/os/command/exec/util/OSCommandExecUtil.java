package com.techsocialist.plugin.os.command.exec.util;

import com.techsocialist.plugin.os.command.exec.service.api.IOSCommandExecService;

public class OSCommandExecUtil {

    public static final IOSCommandExecService getOSCommandExecService(String className) throws ReflectiveOperationException {
        Class<?> clazz = Class.forName(className);
        return getOSCommandExecService(clazz);
    }

    public static final IOSCommandExecService getOSCommandExecService(Class<?> clazz) throws ReflectiveOperationException {
        return (IOSCommandExecService)clazz.newInstance();
    }

}
