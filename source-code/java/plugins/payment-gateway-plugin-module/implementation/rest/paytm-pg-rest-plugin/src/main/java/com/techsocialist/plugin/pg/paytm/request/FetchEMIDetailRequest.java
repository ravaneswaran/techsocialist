package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class FetchEMIDetailRequest extends AbstractPaytmRequest {

    private String[] channelCodes;

    private String amount;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/fetchEMIDetail?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(),  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("clientId", this.getClientId());
        head.put("version", this.getVersion());
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", this.getChannelId());
        head.put("txnToken", this.getTransactionToken());

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        StringBuffer channelCodesBuffer = new StringBuffer();
        if(null != channelCodes) {
            for (String channelCode : channelCodes) {
                channelCodesBuffer.append(channelCode).append(",");
            }
            String channelCodeValStr = channelCodesBuffer.toString();
            body.put("channelCode", channelCodeValStr.substring(0, channelCodeValStr.length() - 1));
        }

        return body;
    }

    public FetchEMIDetailRequest setChannelCodes(String[] channelCodes) {
        this.channelCodes = channelCodes;
        return this;
    }

    public FetchEMIDetailRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }
}
