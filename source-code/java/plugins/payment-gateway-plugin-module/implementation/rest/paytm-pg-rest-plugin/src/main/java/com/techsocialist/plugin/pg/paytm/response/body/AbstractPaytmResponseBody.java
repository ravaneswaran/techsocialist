package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.ResultInfo;

public abstract class AbstractPaytmResponseBody {

    @SerializedName("resultInfo")
    private ResultInfo resultInfo;

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public boolean ok(){
        return null != this.resultInfo ? resultInfo.ok() : false;
    }
}
