package com.techsocialist.plugin.mail.util;

import com.techsocialist.plugin.mail.service.api.IMailService;

public class MailUtil {

    public static final IMailService getMailService(String className) throws ReflectiveOperationException{
        Class<?> clazz = Class.forName(className);
        return MailUtil.getMailService(clazz);
    }

    public static final IMailService getMailService(Class<?> clazz) throws ReflectiveOperationException{
        Object object = clazz.newInstance();

        if(object != null && object instanceof IMailService){
            return (IMailService)object;
        } else {
            return null;
        }
    }
}
