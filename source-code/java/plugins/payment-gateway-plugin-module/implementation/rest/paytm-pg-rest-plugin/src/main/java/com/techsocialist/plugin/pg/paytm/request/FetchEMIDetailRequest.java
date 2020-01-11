package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class FetchEMIDetailRequest extends AbstractPaytmRequest {

    private String clientId;

    private String version;

    private String channelId;

    private String transactionToken;

    private String[] channelCodes;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/fetchEMIDetail?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.version,  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("clientId", this.clientId);
        head.put("version", this.version);
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", this.channelId);
        head.put("txnToken", this.transactionToken);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        StringBuffer channelCodesBuffer = new StringBuffer();
        for (String channelCode : channelCodes) {
            channelCodesBuffer.append(channelCode).append(",");
        }
        String channelCodeValStr = channelCodesBuffer.toString();
        body.put("channelCode", channelCodeValStr.substring(0, channelCodeValStr.length() - 1));

        return body;
    }

    public FetchEMIDetailRequest setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public FetchEMIDetailRequest setVersion(String version) {
        this.version = version;
        return this;
    }

    public FetchEMIDetailRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public FetchEMIDetailRequest setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
        return this;
    }

    public FetchEMIDetailRequest setChannelCodes(String[] channelCodes) {
        this.channelCodes = channelCodes;
        return this;
    }
}
