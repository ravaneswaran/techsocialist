package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.AbstractPaytmResponse;

public class ResultInfo extends AbstractPaytmResponse {

    @SerializedName("resultStatus")
    private String resultStatus;

    @SerializedName("resultCode")
    private String resultCode;

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

    @Override
    public boolean isOk(){
        return "S".equals(this.getResultStatus()) && 0 == Integer.parseInt(this.getResultCode()) && "Success".equals(this.getResultMessage());
    }
}
