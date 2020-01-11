package com.techsocialist.plugin.mail.util;

import com.techsocialist.plugin.mail.api.IMailPlugin;

public class MailPluginUtil {

    public static final IMailPlugin getMailService(String className) throws ReflectiveOperationException{
        Class<?> clazz = Class.forName(className);
        return MailPluginUtil.getMailService(clazz);
    }

    public static final IMailPlugin getMailService(Class<?> clazz) throws ReflectiveOperationException{
        Object object = clazz.newInstance();

        if(object != null && object instanceof IMailPlugin){
            return (IMailPlugin)object;
        } else {
            return null;
        }
    }
}
