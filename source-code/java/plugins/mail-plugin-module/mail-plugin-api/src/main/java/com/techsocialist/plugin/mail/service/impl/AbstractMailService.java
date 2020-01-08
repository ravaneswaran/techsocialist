package com.techsocialist.plugin.mail.service.impl;

import com.techsocialist.plugin.mail.service.api.IMailService;

public abstract class AbstractMailService implements IMailService {

    @Override
    public int connect(String host, String port, String userName, String password) {
        return STATUS_DEFAULT;
    }

    @Override
    public void sendMail(String from, String to, String subject, String message) throws Exception {
        String[] tos = new String[1];
        tos[0] = to;
        this.sendMail(from, tos, null, null, null, subject, message);
    }

    @Override
    public void sendMail(String from, String to, String[] ccs, String subject, String message) throws Exception {
        String[] tos = new String[1];
        tos[0] = to;
        this.sendMail(from, tos, ccs, null, null, subject, message);
    }

    @Override
    public void sendMail(String from, String to, String[] ccs, String[] bccs, String subject, String message) throws Exception {
        String[] tos = new String[1];
        tos[0] = to;
        this.sendMail(from, tos, ccs, bccs, null, subject, message);
    }

    @Override
    public void sendMail(String from, String[] tos, String[] ccs, String[] bccs, String[] attachments, String subject, String message) throws Exception {
    }
}
