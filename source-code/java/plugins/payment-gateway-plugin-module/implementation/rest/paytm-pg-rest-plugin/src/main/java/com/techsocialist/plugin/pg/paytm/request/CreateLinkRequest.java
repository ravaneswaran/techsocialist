package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class CreateLinkRequest extends AbstractPaytmLinkRequest {

    private String linkType;

    private String linkDescription;

    private String linkName;

    private String amount;

    private String expiryDate;

    private boolean sendSMS;

    private boolean sendEmail;

    private String statusCallbackUrl;

    private String maxPaymentsAllowed;

    public CreateLinkRequest setLinkType(String linkType) {
        this.linkType = linkType;
        return this;
    }

    public CreateLinkRequest setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
        return this;
    }

    public CreateLinkRequest setLinkName(String linkName) {
        this.linkName = linkName;
        return this;
    }

    public CreateLinkRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public CreateLinkRequest setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public CreateLinkRequest setSendSMS(boolean sendSMS) {
        this.sendSMS = sendSMS;
        return this;
    }

    public CreateLinkRequest setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
        return this;
    }

    public CreateLinkRequest setStatusCallbackUrl(String statusCallbackUrl) {
        this.statusCallbackUrl = statusCallbackUrl;
        return this;
    }

    public CreateLinkRequest setMaxPaymentsAllowed(String maxPaymentsAllowed) {
        this.maxPaymentsAllowed = maxPaymentsAllowed;
        return this;
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/link/create";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/link/create";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {
        JSONObject head = new JSONObject();

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());
        head.put("timestamp", this.getRequestTimestamp());
        head.put("tokenType", this.tokenType);
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("linkType", this.linkType);
        body.put("linkDescription", this.linkDescription);
        body.put("linkName", this.linkName);
        body.put("merchantRequestId", this.merchantRequestId);
        body.put("amount", this.amount);
        body.put("expiryDate", this.expiryDate);
        body.put("sendSms", this.sendSMS);
        body.put("sendEmail", this.sendEmail);
        body.put("statusCallbackUrl", this.statusCallbackUrl);
        body.put("maxPaymentsAllowed", this.maxPaymentsAllowed);

        return body;
    }
}
