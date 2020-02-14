package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class RenewSubscriptionRequest extends AbstractPaytmRequest {

    private String transactionAmount;

    private String currency;

    private String subscriptionId;

    public RenewSubscriptionRequest setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public RenewSubscriptionRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RenewSubscriptionRequest setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/subscription/renew?mid=%s&orderId=%s";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/subscription/renew?mid=%s&orderId=%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), dataBody().toString());
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("orderId", this.getOrderId());
        body.put("subscriptionId", this.subscriptionId);

        JSONObject txnAmount = new JSONObject();
        txnAmount.put("value", this.transactionAmount);
        txnAmount.put("currency", this.currency);

        body.put("txnAmount", txnAmount);

        return body;
    }
}
