package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.ResultInfo;

public abstract class AbstractPaytmResponseBody {

    @SerializedName("resultInfo")
    private ResultInfo resultInfo;

    @SerializedName("extraParamsMap")
    private String extraParamsMap;

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public String getExtraParamsMap() {
        return extraParamsMap;
    }

    public boolean ok(){
        return this.resultInfo.ok();
    }
}
