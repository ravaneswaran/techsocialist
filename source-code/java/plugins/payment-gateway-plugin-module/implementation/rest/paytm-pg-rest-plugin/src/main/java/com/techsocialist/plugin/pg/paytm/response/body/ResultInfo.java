package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resultInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultInfo {

    @XmlPath("body/resultInfo/resultStatus")
    @SerializedName("resultStatus")
    private String resultStatus;

    @XmlPath("body/resultInfo/resultCode")
    @SerializedName("resultCode")
    private String resultCode;

    @XmlPath("body/resultInfo/resultMsg")
    @SerializedName("resultMsg")
    private String resultMessage;

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
