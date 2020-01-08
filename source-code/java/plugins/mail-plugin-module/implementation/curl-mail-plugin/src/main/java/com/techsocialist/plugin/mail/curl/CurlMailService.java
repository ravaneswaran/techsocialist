package com.techsocialist.plugin.mail.curl;

import com.techsocialist.plugin.mail.service.impl.AbstractMailService;

public class CurlMailService extends AbstractMailService {

    private int status;

    @Override
    public int connect(String host, String port, String userName, String password) {
        return STATUS_SUCCESS;
    }

    @Override
    public void sendMail(String from, String[] tos, String[] ccs, String[] bccs, String[] attachments, String subject, String message) throws Exception {

    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    private String constructCurlCommand(String from, String[] tos, String[] ccs, String[] bccs, String[] attachments, String subject, String message){
        StringBuilder curlCommandBuilder = new StringBuilder();

        curlCommandBuilder.append("curl").append(" ").append("--url").append(" ");

        return null;
    }

}
