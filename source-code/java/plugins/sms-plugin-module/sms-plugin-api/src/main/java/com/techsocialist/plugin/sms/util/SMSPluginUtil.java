package com.techsocialist.plugin.sms.util;

import com.techsocialist.plugin.sms.api.ISMSPlugin;

public class SMSPluginUtil {

    public static final ISMSPlugin getSMSPlugin(String className) throws ReflectiveOperationException{
        Class<?> clazz = Class.forName(className);
        return SMSPluginUtil.getSMSPlugin(clazz);
    }

    public static final ISMSPlugin getSMSPlugin(Class<?> clazz) throws ReflectiveOperationException{
        return  (ISMSPlugin)clazz.newInstance();
    }
}
