package com.techsocialist.plugin.mail;

import com.techsocialist.plugin.mail.service.impl.AbstractMailService;
import com.techsocialist.plugin.os.api.IOSCommandExecPlugin;
import com.techsocialist.plugin.os.util.OSCommandExecPluginUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CurlMailPlugin extends AbstractMailService {

    private static final String SPACE = " ";
    private static final String SINGLE_QUOTE = "'";
    private static final String SEMI_COLON = ";";
    private static final String MAIL_FROM = "--mail-from";
    private static final String MAIL_RECIPIENT = "--mail-rcpt";

    private StringBuilder curlCommandBuilder = new StringBuilder();

    private int status;

    @Override
    public int connect(String host, String port, String userName, String password) {
        this.curlCommandBuilder.append("curl").append(SPACE).append("--url").append(SPACE).append(SINGLE_QUOTE).append(String.format("smtp://%s:%s", host, port)).append(SINGLE_QUOTE).append(SPACE);
        if(null != userName && null != password && !userName.isEmpty() && !password.isEmpty()){
            this.curlCommandBuilder.append("--user").append(SPACE).append(SINGLE_QUOTE).append(userName).append(":").append(password).append(SINGLE_QUOTE).append(SPACE);
        }

        return STATUS_SUCCESS;
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

        this.curlCommandBuilder.append(MAIL_FROM).append(SPACE).append(SINGLE_QUOTE).append(from).append(SINGLE_QUOTE).append(SPACE);

        StringBuilder toBuilder = new StringBuilder();
        for (String to : tos) {
            toBuilder.append(to).append(SEMI_COLON);
        }
        this.curlCommandBuilder.append(MAIL_RECIPIENT).append(SPACE).append(SINGLE_QUOTE).append(toBuilder.toString()).append(SINGLE_QUOTE).append(SPACE);

        if(null != ccs && ccs.length > 0) {
            StringBuilder ccBuilder = new StringBuilder();
            for (String cc : ccs) {
                ccBuilder.append(cc).append(SEMI_COLON);
            }
            this.curlCommandBuilder.append(MAIL_RECIPIENT).append(SPACE).append(SINGLE_QUOTE).append(ccBuilder.toString()).append(SINGLE_QUOTE).append(SPACE);
        }

        if(null != bccs && bccs.length > 0){
            StringBuilder bccBuilder = new StringBuilder();
            for (String bcc : bccs) {
                bccBuilder.append(bcc).append(SEMI_COLON);
            }
            this.curlCommandBuilder.append(MAIL_RECIPIENT).append(SPACE).append(SINGLE_QUOTE).append(bccBuilder.toString()).append(SINGLE_QUOTE).append(SPACE);
        }

        File messageFile = this.createMessageFile(from, tos, subject, message);
        if(null != messageFile){
            String fileAbsolutePath = messageFile.getAbsolutePath();
            this.curlCommandBuilder.append("--upload-file").append(SPACE).append(fileAbsolutePath).append(SPACE);
        }

        this.curlCommandBuilder.append("--insecure");

        IOSCommandExecPlugin osCommandExecService = OSCommandExecPluginUtil.getOSCommandExecPlugin("LinuxCommandExecPlugin");
        osCommandExecService.executeCommand(this.curlCommandBuilder.toString().trim());

        this.deleteMessageFile(messageFile);

        if(null == osCommandExecService.getError()){
            this.setStatus(STATUS_SUCCESS);
        }
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    private File createMessageFile(String from, String[] tos, String subject, String message) throws IOException {
        StringBuilder toStringBuilder = new StringBuilder();
        if(null != tos && tos.length > 0){
            for(String to : tos){
                toStringBuilder.append(to).append(";");
            }
        }

        StringBuilder mailMessageBuilder = new StringBuilder();
        mailMessageBuilder.append("From: ").append(from).append("\n");
        mailMessageBuilder.append("To: ").append(toStringBuilder.toString()).append("\n");
        mailMessageBuilder.append("Subject: ").append(subject).append("\n\n");
        mailMessageBuilder.append(message).append("\n");

        File messageFile = File.createTempFile("mail-message-", ".txt");
        messageFile.createNewFile();
        OutputStream outputStream = new FileOutputStream(messageFile);
        outputStream.write(mailMessageBuilder.toString().getBytes());
        outputStream.close();

        return  messageFile;
    }

    private void deleteMessageFile(File messageFile){
        messageFile.delete();
    }

}
