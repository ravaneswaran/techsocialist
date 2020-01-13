package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

import java.util.TreeMap;

public class OrderStatusRequest extends AbstractPaytmRequest{

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/order/status";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/order/status";
    }

    @Override
    public JSONObject data() {

        TreeMap<String, String> paytmParams = new TreeMap<>();

        paytmParams.put("MID", this.getMerchantId());
        paytmParams.put("ORDERID", this.getOrderId());

        /*String checksum =  CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(ApplicationProperties.getMerchantKey(), paytmParams);*/
        String checksum = this.getMerchantKey();

        paytmParams.put("CHECKSUMHASH", checksum);

        JSONObject data = new JSONObject(paytmParams);

        return data;
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
}
