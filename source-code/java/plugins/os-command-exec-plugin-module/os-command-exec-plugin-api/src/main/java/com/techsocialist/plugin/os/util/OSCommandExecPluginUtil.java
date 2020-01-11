package com.techsocialist.plugin.os.util;

import com.techsocialist.plugin.os.api.IOSCommandExecPlugin;

public class OSCommandExecPluginUtil {

    public static final IOSCommandExecPlugin getOSCommandExecPlugin(String className) throws ReflectiveOperationException {
        Class<?> clazz = Class.forName(className);
        return getOSCommandExecPlugin(clazz);
    }

    public static final IOSCommandExecPlugin getOSCommandExecPlugin(Class<?> clazz) throws ReflectiveOperationException {
        return (IOSCommandExecPlugin)clazz.newInstance();
    }

}
