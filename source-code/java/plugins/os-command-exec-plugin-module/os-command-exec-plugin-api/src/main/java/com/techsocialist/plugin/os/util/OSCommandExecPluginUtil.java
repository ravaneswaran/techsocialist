package com.techsocialist.plugin.os.util;

import com.techsocialist.plugin.os.api.IOSCommandExecPlugin;

public class OSCommandExecPluginUtil {

    public static final IOSCommandExecPlugin getOSCommandExecService(String className) throws ReflectiveOperationException {
        Class<?> clazz = Class.forName(className);
        return getOSCommandExecService(clazz);
    }

    public static final IOSCommandExecPlugin getOSCommandExecService(Class<?> clazz) throws ReflectiveOperationException {
        return (IOSCommandExecPlugin)clazz.newInstance();
    }

}
