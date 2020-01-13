package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class SendOTPRequest extends AbstractPaytmRequest{

    private String mobileNumber;

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return String.format("https://securegw.paytm.in/login/sendOtp?mid=%s&orderId=%s",this.getMerchantId(), this.getOrderId());
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return String.format("https://securegw-stage.paytm.in/login/sendOtp?mid=%s&orderId=%s",this.getMerchantId(), this.getOrderId());
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();

        head.put("clientId", this.getClientId());
        head.put("version", this.getVersion());
        head.put("requestTimestamp", this.getRequestTimestamp());
        head.put("channelId", this.getChannelId());
        head.put("txnToken", this.getTransactionToken());

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();

        body.put("mobileNumber", this.mobileNumber);

        return body;
    }

    public SendOTPRequest setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }
}
