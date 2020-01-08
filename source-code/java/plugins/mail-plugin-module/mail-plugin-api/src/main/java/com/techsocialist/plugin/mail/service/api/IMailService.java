package com.techsocialist.plugin.mail.service.api;

public interface IMailService {

    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_FAILURE = -1000;
    public static final int STATUS_WARNING = 1000;

    public int connect(String host, String port, String userName,
                       String password);

    public void sendMail(String from, String to, String subject, String message)
            throws Exception;

    public void sendMail(String from, String to, String[] ccs, String subject,
                        String message) throws Exception;

    public void sendMail(String from, String to, String[] ccs, String[] bccs,
                        String subject, String message) throws Exception;

    public void sendMail(String from, String[] tos, String[] ccs, String[] bccs,
                        String[] attachments, String subject, String message)
            throws Exception;

    public void setStatus(int status);

    public int getStatus();
}
