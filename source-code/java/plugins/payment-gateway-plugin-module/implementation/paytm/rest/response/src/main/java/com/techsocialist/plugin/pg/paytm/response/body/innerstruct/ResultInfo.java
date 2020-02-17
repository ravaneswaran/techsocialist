package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class ResultInfo {

    @SerializedName(value = "resultStatus", alternate = "status")
    private String resultStatus;

    @SerializedName(value = "resultCode", alternate = "code")
    private String resultCode;

    @SerializedName(value = "resultMsg", alternate = "message")
    private String resultMessage;

    @SerializedName("retry")
    private boolean retry;


    public ResultInfo(){}

    public ResultInfo(String resultStatus, String resultCode, String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultStatus = resultStatus;
    }

    public ResultInfo(String resultStatus, String resultCode, String resultMessage, boolean retry){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultStatus = resultStatus;
        this.retry = retry;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public boolean isRetry() {
        return retry;
    }

    public boolean ok(){
        return 0 == Integer.parseInt(this.getResultCode());
        //return "S".equals(this.getResultStatus()) && 0 == Integer.parseInt(this.getResultCode()) && "Success".equals(this.getResultMessage());
    }
}
