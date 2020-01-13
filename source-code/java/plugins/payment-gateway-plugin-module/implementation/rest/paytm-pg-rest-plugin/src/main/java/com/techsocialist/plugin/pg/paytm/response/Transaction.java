package com.techsocialist.plugin.pg.paytm.response;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {

    @XmlPath("head/responseTimestamp")
    private String responseTimestamp;

    @XmlPath("head/version")
    private String version;

    @XmlPath("head/signature")
    private String signature;

    @XmlPath("body/txnToken")
    private String txnToken;

    @XmlPath("body/isPromoCodeValid")
    private boolean isPromoCodeValid;

    @XmlPath("body/authenticated")
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
