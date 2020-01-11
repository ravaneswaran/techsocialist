package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public abstract class AbstractPaytmRequest {

    private String merchantId;

    private String orderId;

    public String dataAsJsonString(){
        return data().toString();
    }

    protected String getStagingUrlEndPointPrefix(){
        return "https://securegw-stage.paytm.in/theia/api";
    }

    protected String getProductionUrlEndPointPrefix(){
        return "https://securegw.paytm.in/theia/api";
    }

    public String getUrlEndPointPrefix(boolean production){
        return production ? getProductionUrlEndPointPrefix() : getStagingUrlEndPointPrefix();
    }

    public abstract String url(boolean production);

    public abstract JSONObject dataHead();

    public abstract JSONObject dataBody();

    public JSONObject data(){
        JSONObject paytmRequestData = new JSONObject();

        JSONObject head = dataHead();
        JSONObject body = dataBody();

        if(null != head){
            paytmRequestData.put("head", dataHead());
        }

        if(null != body){
            paytmRequestData.put("body", dataBody());
        }

        return paytmRequestData;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
