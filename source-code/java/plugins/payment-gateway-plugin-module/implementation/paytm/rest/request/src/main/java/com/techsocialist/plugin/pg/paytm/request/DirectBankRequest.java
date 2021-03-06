package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class DirectBankRequest extends AbstractPaytmRequest {

    private String otp;

    private String requestType;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/directBankRequest?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(),  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        return null;
    }

    @Override
    public JSONObject dataBody() {
        return null;
    }

    @Override
    public String dataAsJsonString() {
        JSONObject data = new JSONObject();

        data.put("txnToken", this.getTransactionToken());
        data.put("request-type", this.requestType);
        data.put("otp", this.otp);

        return data.toString();
    }

    public DirectBankRequest setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    public DirectBankRequest setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

}
