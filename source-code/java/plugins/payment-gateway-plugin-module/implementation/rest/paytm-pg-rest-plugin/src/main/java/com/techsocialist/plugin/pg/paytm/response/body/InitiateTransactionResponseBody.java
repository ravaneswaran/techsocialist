package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class InitiateTransactionResponseBody {

    @XmlPath("body/resultInfo")
    @SerializedName("resultInfo")
    private ResultInfo resultInfo;

    @XmlPath("body/txnToken")
    @SerializedName("txnToken")
    private String transactionToken;

    @XmlPath("body/isPromoCodeValid")
    @SerializedName("isPromoCodeValid")
    private boolean isPromoCodeValid;

    @XmlPath("body/authenticated")
    @SerializedName("authenticated")
    private boolean authenticated;

    @XmlPath("body/extraParamsMap")
    @SerializedName("extraParamsMap")
    private String extraParamsMap;

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    /*public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }*/

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public boolean isPromoCodeValid() {
        return isPromoCodeValid;
    }

    /*public void setPromoCodeValid(boolean promoCodeValid) {
        isPromoCodeValid = promoCodeValid;
    }*/

    public boolean isAuthenticated() {
        return authenticated;
    }

    /*public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }*/

    public String getExtraParamsMap() {
        return extraParamsMap;
    }

    public void setExtraParamsMap(String extraParamsMap) {
        this.extraParamsMap = extraParamsMap;
    }
}
