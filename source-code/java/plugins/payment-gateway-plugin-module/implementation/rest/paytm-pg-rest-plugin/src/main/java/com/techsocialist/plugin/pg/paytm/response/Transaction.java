package com.techsocialist.plugin.pg.paytm.response;

public class Transaction {

    private String responseTimestamp;

    private String version;

    private String signature;

    private String txnToken;

    private boolean isPromoCodeValid;

    private boolean authenticated;

    public String getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(String responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTxnToken() {
        return txnToken;
    }

    public void setTxnToken(String txnToken) {
        this.txnToken = txnToken;
    }

    public boolean isPromoCodeValid() {
        return isPromoCodeValid;
    }

    public void setPromoCodeValid(boolean promoCodeValid) {
        isPromoCodeValid = promoCodeValid;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
