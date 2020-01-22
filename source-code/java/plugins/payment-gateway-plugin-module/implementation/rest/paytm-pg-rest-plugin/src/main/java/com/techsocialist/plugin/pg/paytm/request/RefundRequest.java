package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class RefundRequest extends AbstractPaytmRequest{

    private String transactionType;

    private String transactionId;

    private String refundId;

    private String amountToRefund;

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/refund/apply";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/refund/apply";
    }

    @Override
    public String url(boolean production) {
        return getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(this.getMerchantKey(), dataBody().toString());

        head.put("clientId", this.getClientId());
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("txnType", this.transactionType);
        body.put("orderId", this.getOrderId());
        body.put("txnId", this.transactionId);
        body.put("refId", this.refundId);
        body.put("refundAmount", this.amountToRefund);

        return body;
    }

    public RefundRequest setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public RefundRequest setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public RefundRequest setRefundId(String refundId) {
        this.refundId = refundId;
        return this;
    }

    public RefundRequest setAmountToRefund(String amountToRefund) {
        this.amountToRefund = amountToRefund;
        return this;
    }
}
