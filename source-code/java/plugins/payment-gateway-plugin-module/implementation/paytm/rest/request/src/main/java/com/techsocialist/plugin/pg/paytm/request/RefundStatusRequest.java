package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class RefundStatusRequest extends AbstractPaytmRequest {

    private String refundId;

    public RefundStatusRequest(){
        this.setVersion("v2");
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return String.format("https://securegw.paytm.in/%s/refund/status", this.getVersion());
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return String.format("https://securegw-stage.paytm.in/%s/refund/status", this.getVersion());
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
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
        body.put("orderId", this.getOrderId());
        body.put("refId", this.refundId);

        return body;
    }

    public RefundStatusRequest setRefundId(String refundId) {
        this.refundId = refundId;
        return this;
    }
}
