package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class BalanceInfoRequest extends AbstractPaytmRequest {

    private String clientId;

    private String version;

    private String channelId;

    private String transactionToken;

    private String paymentMode;

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/userAsset";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/userAsset";
    }

    @Override
    public String url(boolean production) {
        return String.format("%s/fetchBalanceInfo?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("clientId", clientId);
        head.put("version", version);
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", channelId);
        head.put("txnToken", transactionToken);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        body.put("paymentMode", paymentMode);

        return body;
    }

    public BalanceInfoRequest setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public BalanceInfoRequest setVersion(String version) {
        this.version = version;
        return this;
    }

    public BalanceInfoRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public BalanceInfoRequest setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
        return this;
    }

    public BalanceInfoRequest setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }
}
