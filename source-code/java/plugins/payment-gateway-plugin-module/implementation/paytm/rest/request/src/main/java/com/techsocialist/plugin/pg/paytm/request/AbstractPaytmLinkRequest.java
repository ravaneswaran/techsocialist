package com.techsocialist.plugin.pg.paytm.request;

public abstract class AbstractPaytmLinkRequest extends AbstractPaytmRequest {

    protected String tokenType;

    protected String linkId;

    protected String merchantRequestId;

    protected String timestamp;

    public AbstractPaytmLinkRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public AbstractPaytmLinkRequest setLinkId(String linkId) {
        this.linkId = linkId;
        return this;
    }

    public AbstractPaytmLinkRequest setMerchantRequestId(String merchantRequestId) {
        this.merchantRequestId = merchantRequestId;
        return this;
    }

    public AbstractPaytmLinkRequest setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
