package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EMIDetail {

    public EMIDetail(){}

    public EMIDetail(List<EMIChannelInfo> emiChannelInfos, boolean isHybridDisabled){
        this.emiChannelInfos = emiChannelInfos;
        this.isHybridDisabled = isHybridDisabled;
    }

    @SerializedName("emiChannelInfos")
    private List<EMIChannelInfo> emiChannelInfos;

    @SerializedName("isHybridDisabled")
    private boolean isHybridDisabled;

    public List<EMIChannelInfo> getEmiChannelInfos() {
        return emiChannelInfos;
    }

    public boolean isHybridDisabled() {
        return isHybridDisabled;
    }
}
