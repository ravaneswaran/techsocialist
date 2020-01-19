package com.techsocialist.plugin.pg.paytm.response.head;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
@XmlAccessorType(XmlAccessType.FIELD)
public class InitiateTransactionHead {

    @XmlPath("head/responseTimestamp")
    private String responseTimestamp;

    @XmlPath("head/version")
    private String version;

    @XmlPath("head/signature")
    private String signature;

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
}
