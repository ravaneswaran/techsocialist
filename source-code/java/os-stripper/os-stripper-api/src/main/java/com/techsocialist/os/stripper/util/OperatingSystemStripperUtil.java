package com.techsocialist.os.stripper.util;

import com.techsocialist.os.stripper.service.api.ILinuxStripperService;

public class OperatingSystemStripperUtil {

    public static final ILinuxStripperService getLinuxStripperService(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Object object = clazz.newInstance();

        if(object != null && object instanceof ILinuxStripperService){
            return (ILinuxStripperService)object;
        } else {
            return null;
        }
    }
}
