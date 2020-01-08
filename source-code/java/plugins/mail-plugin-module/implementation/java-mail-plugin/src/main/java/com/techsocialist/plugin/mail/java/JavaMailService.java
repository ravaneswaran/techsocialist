package com.techsocialist.plugin.mail.java;

import com.techsocialist.plugin.mail.service.impl.AbstractMailService;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class JavaMailService extends AbstractMailService {

    private Session session;

    private int status = STATUS_DEFAULT;

    @Override
    public int connect(String host, String port, String userName, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", host);

        this.session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

        return null != this.session ? STATUS_SUCCESS : STATUS_FAILURE;
    }

    @Override
    public void sendMail(String from, String[] tos, String[] ccs, String[] bccs, String[] attachments, String subject, String message) throws Exception {

        if (null == from || from.isEmpty()) {
            this.setStatus(STATUS_FAILURE);
            throw new RuntimeException("Invalid from address...");
        }

        if (null == tos || tos.length < 1) {
            this.setStatus(STATUS_FAILURE);
            throw new RuntimeException("Invalid to address...");
        }

        Message mimeMessage = new MimeMessage(this.session);
        mimeMessage.setFrom(new InternetAddress(from));

        InternetAddress[] toAddresses = new InternetAddress[tos.length];
        for (int i = 0; i < tos.length; i++) {
            toAddresses[i] = new InternetAddress(tos[i]);
        }
        mimeMessage.setRecipients(Message.RecipientType.TO, toAddresses);

        if (null != ccs && ccs.length > 0) {
            InternetAddress[] ccAddresses = new InternetAddress[ccs.length];
            for (int i = 0; i < ccs.length; i++) {
                ccAddresses[i] = new InternetAddress(ccs[i]);
            }
            mimeMessage.setRecipients(Message.RecipientType.CC, ccAddresses);
        }

        if (null != bccs && bccs.length > 0) {
            InternetAddress[] bccAddresses = new InternetAddress[bccs.length];
            for (int i = 0; i < bccs.length; i++) {
                bccAddresses[i] = new InternetAddress(bccs[i]);
            }
            mimeMessage.setRecipients(Message.RecipientType.BCC, bccAddresses);
        }

        mimeMessage.setSubject(subject);
        BodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
        mimeBodyPart.setText(message);
        Multipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);

        if(null != attachments && attachments.length > 0) {
            for (String attachment : attachments) {
                File file = new File(attachment);
                mimeBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(file);
                mimeBodyPart.setDataHandler(new DataHandler(source));
                mimeBodyPart.setFileName(file.getName());
                mimeMultipart.addBodyPart(mimeBodyPart);
            }
        }

        mimeMessage.setContent(mimeMultipart);
        mimeMessage.saveChanges();
        Transport.send(mimeMessage);

        this.setStatus(STATUS_SUCCESS);
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return this.status;
    }
}
