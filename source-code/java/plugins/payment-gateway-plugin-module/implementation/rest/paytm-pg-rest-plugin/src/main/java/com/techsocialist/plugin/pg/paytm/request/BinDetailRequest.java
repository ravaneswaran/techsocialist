package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class BinDetailRequest extends AbstractPaytmRequest {

    private String version;

    private String channelId;

    private String transactionToken;

    private String bin;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/fetchBinDetail?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.version,  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("version", version);
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", channelId);
        head.put("txnToken", transactionToken);

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        body.put("bin", bin);

        return body;
    }

    public BinDetailRequest setVersion(String version) {
        this.version = version;
        return this;
    }

    public BinDetailRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public BinDetailRequest setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
        return this;
    }

    public BinDetailRequest setBin(String bin) {
        this.bin = bin;
        return this;
    }
}
