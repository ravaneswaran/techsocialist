package com.techsocialist.plugin.os.stripper.util;

import com.techsocialist.plugin.os.stripper.service.api.IOperatingSystemStripperService;

public class OperatingSystemStripperUtil {

    public static final IOperatingSystemStripperService getOperatingSystemStripperService(Class<?> clazz) throws ReflectiveOperationException{
        Object object = clazz.newInstance();

        if(object != null && object instanceof IOperatingSystemStripperService){
            return (IOperatingSystemStripperService)object;
        } else {
            return null;
        }
    }

    public static final IOperatingSystemStripperService getOperatingSystemStripperService(String className) throws ReflectiveOperationException{
        Class<?> clazz = Class.forName(className);
        return OperatingSystemStripperUtil.getOperatingSystemStripperService(clazz);
    }
}
