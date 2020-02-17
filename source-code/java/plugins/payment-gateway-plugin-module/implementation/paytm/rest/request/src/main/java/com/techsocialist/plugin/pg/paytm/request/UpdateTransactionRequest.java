package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class UpdateTransactionRequest extends AbstractPaytmRequest{

    private String amount;

    private String currency;

    private String customerId;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/updateTransactionDetail?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() throws Exception {
        JSONObject head = new JSONObject();

        head.put("txnToken", this.getTransactionToken());

        String checksum =  CheckSumServiceHelper.getCheckSumServiceHelper()
                .genrateCheckSum(this.getMerchantKey(), dataBody().toString());
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

    public UpdateTransactionRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public UpdateTransactionRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public UpdateTransactionRequest setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }
}
