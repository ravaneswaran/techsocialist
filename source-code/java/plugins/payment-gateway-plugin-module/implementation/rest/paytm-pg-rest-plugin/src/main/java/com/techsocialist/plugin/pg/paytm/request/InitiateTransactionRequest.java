package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class InitiateTransactionRequest extends AbstractPaytmRequest{

    private String userId;

    private long amount;

    private String currency;

    private String callbackUrl;

    private String websiteName;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/initiateTransaction?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(),  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("signature", this.generateChecksum(dataBody()));

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject txnAmount = new JSONObject();
        txnAmount.put("value", this.amount);
        txnAmount.put("currency", this.currency);

        JSONObject userInfo = new JSONObject();
        userInfo.put("custId", this.userId);

        JSONObject body = new JSONObject();
        body.put("requestType", "Payment");
        body.put("mid", this.getMerchantId());
        body.put("websiteName", this.websiteName);
        body.put("orderId", this.getOrderId());
        body.put("callbackUrl", String.format(this.callbackUrl, this.getOrderId()));
        body.put("txnAmount", txnAmount);
        body.put("userInfo", userInfo);

        return body;
    }

    public InitiateTransactionRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public InitiateTransactionRequest setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public InitiateTransactionRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public InitiateTransactionRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public InitiateTransactionRequest setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
        return this;
    }
}
