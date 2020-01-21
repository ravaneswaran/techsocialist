package com.techsocialist.plugin.pg.paytm.request;


import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public abstract class AbstractPaytmRequest {

    private String merchantId;

    private String merchantKey;

    private String channelId = "WEB";

    private String orderId;

    private String version = "v1";

    private String clientId = "C11";

    private String transactionToken;

    public String dataAsJsonString() throws Exception {
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

    public JSONObject data() throws Exception {
        JSONObject paytmRequestData = new JSONObject();

        JSONObject head = dataHead();
        JSONObject body = dataBody();

        if(null != head){
            paytmRequestData.put("head", head);
        }

        if(null != body){
            paytmRequestData.put("body", body);
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public long getRequestTimestamp() {
        return System.currentTimeMillis();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }


    public String generateChecksum(JSONObject jsonObject) {
        String checksum = null;
        try {
            checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(this.getMerchantKey(), jsonObject.toString());
        } catch (Exception e) {
            checksum = e.getMessage();
        }

        return checksum;
    }
}
