package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class UpdateTransactionDetailRequest extends AbstractPaytmRequest{

    private String amount;

    private String currency;

    private String customerId;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/updateTransactionDetail?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();

        head.put("txnToken", this.getTransactionToken());

        /*String checksum =  CheckSumServiceHelper.getCheckSumServiceHelper()
                .genrateCheckSum(ApplicationProperties.getMerchantKey(), body.toString());*/
        String checksum = this.getMerchantKey();
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();

        JSONObject txnAmount = new JSONObject();
        txnAmount.put("value", String.valueOf(this.amount));
        txnAmount.put("currency", this.currency);

        JSONObject userInfo = new JSONObject();
        userInfo.put("custId", this.customerId);

        body.put("txnAmount", txnAmount);
        body.put("userInfo", userInfo);

        return body;
    }

    public UpdateTransactionDetailRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public UpdateTransactionDetailRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public UpdateTransactionDetailRequest setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }
}
