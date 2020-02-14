package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class ResendNotificationLinkRequest extends AbstractPaytmLinkRequest{

    private boolean sendSMS;

    private boolean sendEmail;

    private String customerName;

    private String customerEmail;

    private String customerMobileNumber;

    public ResendNotificationLinkRequest setSendSMS(boolean sendSMS) {
        this.sendSMS = sendSMS;
        return this;
    }

    public ResendNotificationLinkRequest setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
        return this;
    }

    public ResendNotificationLinkRequest setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public ResendNotificationLinkRequest setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public ResendNotificationLinkRequest setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
        return this;
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/link/resendNotification";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/link/resendNotification";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());

        JSONObject head = new JSONObject();

        head.put("tokenType", this.tokenType);
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("linkId", this.linkId);
        body.put("sendSms", this.sendSMS);

        JSONObject notifyContact = new JSONObject();

        notifyContact.put("customerMobile", this.customerMobileNumber);
        body.put("notifyContact", notifyContact);


        return body;
    }
}
