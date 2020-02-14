package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class ProcessTransactionRequest extends AbstractPaytmRequest{

    private String requestType;

    private String paymentMode;

    private String authMode;

    private String cardInfo;

    private String paymentFlow;

    private String storeInstrument;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/processTransaction?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(),  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {

        JSONObject head = new JSONObject();

        head.put("clientId", this.getChannelId());
        head.put("version", this.getVersion());
        head.put("requestTimestamp", this.getRequestTimestamp());
        head.put("channelId", this.getChannelId());
        head.put("txnToken", this.getTransactionToken());

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();

        //body.put("requestType", "NATIVE");
        body.put("requestType", this.requestType);
        body.put("mid", this.getMerchantId());
        body.put("orderId", this.getOrderId());
        body.put("paymentMode", this.paymentMode);
        body.put("authMode", this.authMode);
        body.put("cardInfo", this.cardInfo);
        //body.put("paymentFlow", "NONE");
        body.put("paymentFlow", this.paymentFlow);
        //body.put("storeInstrument", "0");
        body.put("storeInstrument", this.storeInstrument);

        return body;
    }

    public ProcessTransactionRequest setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public ProcessTransactionRequest setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }

    public ProcessTransactionRequest setAuthMode(String authMode) {
        this.authMode = authMode;
        return this;
    }

    public ProcessTransactionRequest setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
        return this;
    }

    public ProcessTransactionRequest setPaymentFlow(String paymentFlow) {
        this.paymentFlow = paymentFlow;
        return this;
    }

    public ProcessTransactionRequest setStoreInstrument(String storeInstrument) {
        this.storeInstrument = storeInstrument;
        return this;
    }
}
