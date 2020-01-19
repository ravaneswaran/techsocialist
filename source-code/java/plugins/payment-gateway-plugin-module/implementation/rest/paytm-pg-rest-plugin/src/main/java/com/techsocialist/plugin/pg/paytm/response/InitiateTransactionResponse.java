package com.techsocialist.plugin.pg.paytm.response;

import com.techsocialist.plugin.pg.paytm.response.body.InitiateTransactionBody;
import com.techsocialist.plugin.pg.paytm.response.head.InitiateTransactionHead;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-initiate-transaction-response")
@XmlAccessorType(XmlAccessType.FIELD)
public class InitiateTransactionResponse {

    @XmlPath("head")
    private InitiateTransactionHead initiateTransactionHead;

    @XmlPath("body")
    private InitiateTransactionBody initiateTransactionBody;

    public InitiateTransactionHead getInitiateTransactionHead() {
        return initiateTransactionHead;
    }

    public void setInitiateTransactionHead(InitiateTransactionHead initiateTransactionHead) {
        this.initiateTransactionHead = initiateTransactionHead;
    }

    public InitiateTransactionBody getInitiateTransactionBody() {
        return initiateTransactionBody;
    }

    public void setInitiateTransactionBody(InitiateTransactionBody initiateTransactionBody) {
        this.initiateTransactionBody = initiateTransactionBody;
    }
}
