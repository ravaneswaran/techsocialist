package com.techsocialist.plugin.mail.curl;

import com.techsocialist.plugin.mail.service.impl.AbstractMailService;

public class CurlMailService extends AbstractMailService {

    private static final String SPACE = " ";
    private static final String SINGLE_QUOTE_START = " '";
    private static final String SINGLE_QUOTE_END = "' ";
    private static final String SEMI_COLON = ";";
    private static final String MAIL_RECIPIENT = "--mail-rcpt";

    private StringBuilder curlCommandBuilder = new StringBuilder();

    private int status;

    @Override
    public int connect(String host, String port, String userName, String password) {
        this.curlCommandBuilder.append("curl").append(SPACE).append("--url").append(SINGLE_QUOTE_START).append(String.format("smtp://%s:%s", host, port)).append(SINGLE_QUOTE_END);
        this.curlCommandBuilder.append("--user").append(SINGLE_QUOTE_START).append(userName).append(":").append(SINGLE_QUOTE_END);
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

        String curlMailCommand = this.constructCurlCommand(from, tos, ccs, bccs, attachments, subject, message);
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    private String constructCurlCommand(String from, String[] tos, String[] ccs, String[] bccs, String[] attachments, String subject, String message) {
        this.curlCommandBuilder.append("--mail-from").append(SPACE).append(from).append(SPACE);

        StringBuilder toBuilder = new StringBuilder();
        for (String to : tos) {
            toBuilder.append(to).append(SEMI_COLON);
        }
        this.curlCommandBuilder.append(MAIL_RECIPIENT).append(SPACE).append(SINGLE_QUOTE_START).append(toBuilder.toString()).append(SINGLE_QUOTE_END).append(SPACE);

        StringBuilder ccBuilder = new StringBuilder();
        for (String cc : ccs) {
            ccBuilder.append(cc).append(SEMI_COLON);
        }
        this.curlCommandBuilder.append(MAIL_RECIPIENT).append(SPACE).append(SINGLE_QUOTE_START).append(ccBuilder.toString()).append(SINGLE_QUOTE_END).append(SPACE);

        StringBuilder bccBuilder = new StringBuilder();
        for (String bcc : bccs) {
            ccBuilder.append(bcc).append(SEMI_COLON);
        }
        this.curlCommandBuilder.append(MAIL_RECIPIENT).append(SPACE).append(SINGLE_QUOTE_START).append(bccBuilder.toString()).append(SINGLE_QUOTE_END).append(SPACE);

        this.curlCommandBuilder.append("--insecure");


        return this.curlCommandBuilder.toString().trim();
    }

}
