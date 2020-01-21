package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class TransactionStatusRequest extends AbstractPaytmRequest {

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/order/status";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/order/status";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
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
    public JSONObject data() throws Exception {
        JSONObject paytmParams = super.data();

        paytmParams.put("MID", this.getMerchantId());
        paytmParams.put("ORDERID", this.getOrderId());

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), paytmParams.toString());
        paytmParams.put("CHECKSUMHASH", checksum);

        return paytmParams;
    }
}
