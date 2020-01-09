package com.techsocialist.plugin.sms.service.util;

import com.techsocialist.plugin.sms.service.api.ISMSService;

public class SMSUtil {

    public static final ISMSService getSMSService(String className) throws ReflectiveOperationException{
        Class<?> clazz = Class.forName(className);
        return SMSUtil.getSMSService(clazz);
    }

    public static final ISMSService getSMSService(Class<?> clazz) throws ReflectiveOperationException{
        return  (ISMSService)clazz.newInstance();
    }
}
