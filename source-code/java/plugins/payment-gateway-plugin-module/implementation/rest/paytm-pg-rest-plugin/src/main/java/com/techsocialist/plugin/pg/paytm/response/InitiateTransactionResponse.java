package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.InitiateTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.body.ResultInfo;
import com.techsocialist.plugin.pg.paytm.response.head.InitiateTransactionResponseHead;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paytm-initiate-transaction-response")
@XmlAccessorType(XmlAccessType.FIELD)
public class InitiateTransactionResponse {

    @XmlPath("head")
    @SerializedName("head")
    private InitiateTransactionResponseHead initiateTransactionResponseHead;

    @XmlPath("body")
    @SerializedName("body")
    private InitiateTransactionResponseBody initiateTransactionResponseBody;

    public InitiateTransactionResponseHead getInitiateTransactionResponseHead() {
        return initiateTransactionResponseHead;
    }

    /*public void setInitiateTransactionResponseHead(InitiateTransactionResponseHead initiateTransactionResponseHead) {
        this.initiateTransactionResponseHead = initiateTransactionResponseHead;
    }*/

    public InitiateTransactionResponseBody getInitiateTransactionResponseBody() {
        return initiateTransactionResponseBody;
    }

    /*public void setInitiateTransactionResponseBody(InitiateTransactionResponseBody initiateTransactionResponseBody) {
        this.initiateTransactionResponseBody = initiateTransactionResponseBody;
    }*/

    public boolean isOk() {
        ResultInfo resultInfo = this.initiateTransactionResponseBody.getResultInfo();
        return "S".equals(resultInfo.getResultStatus()) && 0 == Integer.parseInt(resultInfo.getResultCode()) && "Success".equals(resultInfo.getResultMessage());
    }
}
