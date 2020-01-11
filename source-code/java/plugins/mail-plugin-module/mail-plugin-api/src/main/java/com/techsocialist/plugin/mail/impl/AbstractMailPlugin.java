package com.techsocialist.plugin.mail.impl;

import com.techsocialist.plugin.mail.api.IMailPlugin;

public abstract class AbstractMailPlugin implements IMailPlugin {

    @Override
    public void sendMail(String from, String to, String subject, String message) throws Exception {
        if (null != to && !to.isEmpty()) {
            String[] tos = new String[1];
            tos[0] = to;
            this.sendMail(from, tos, null, null, null, subject, message);
        } else {
            this.sendMail(from, null, null, null, null, subject, message);
        }
    }

    @Override
    public void sendMail(String from, String to, String[] ccs, String subject, String message) throws Exception {
        if (null != to && !to.isEmpty()) {
            String[] tos = new String[1];
            tos[0] = to;
            this.sendMail(from, tos, ccs, null, null, subject, message);
        } else {
            this.sendMail(from, null, ccs, null, null, subject, message);
        }
    }

    @Override
    public void sendMail(String from, String to, String[] ccs, String[] bccs, String subject, String message) throws Exception {
        if (null != to && !to.isEmpty()) {
            String[] tos = new String[1];
            tos[0] = to;
            this.sendMail(from, tos, ccs, bccs, null, subject, message);
        } else {
            this.sendMail(from, null, ccs, bccs, null, subject, message);
        }
    }
}
