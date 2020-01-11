package com.techsocialist.plugin.os.stripper.util;

import com.techsocialist.plugin.os.stripper.api.IOperatingSystemStripperPlugin;

public class OperatingSystemStripperPluginUtil {

    public static final IOperatingSystemStripperPlugin getOperatingSystemStripperPlugin(Class<?> clazz) throws ReflectiveOperationException{
        Object object = clazz.newInstance();

        if(object != null && object instanceof IOperatingSystemStripperPlugin){
            return (IOperatingSystemStripperPlugin)object;
        } else {
            return null;
        }
    }

    public static final IOperatingSystemStripperPlugin getOperatingSystemStripperPlugin(String className) throws ReflectiveOperationException{
        Class<?> clazz = Class.forName(className);
        return OperatingSystemStripperPluginUtil.getOperatingSystemStripperPlugin(clazz);
    }
}
