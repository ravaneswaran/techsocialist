package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class PaymentStatusRequest extends AbstractPaytmRequest{

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/merchant-status/api";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/merchant-status/api";
    }

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/getPaymentStatus", this.getUrlEndPointPrefix(production), this.getVersion());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();

        /*String checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(ApplicationProperties.getMerchantKey(), body.toString());*/
        String checksum = this.getMerchantKey();
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("orderId", this.getOrderId());

        return body;
    }
}
