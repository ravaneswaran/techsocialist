package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.BinDetail;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.HasLowSuccess;

import java.util.List;

public class FetchBinDetailsResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("isHybridDisabled")
    private boolean isHybridDisabled;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("iconUrl")
    private String iconUrl;

    @SerializedName("isEmiAvailable")
    private boolean isEmiAvailable;

    @SerializedName("authModes")
    private List<String> authModes;

    @SerializedName("hasLowSuccessRate")
    private HasLowSuccess hasLowSuccessRate;

    @SerializedName("oneClickSupported")
    private boolean oneClickSupported;

    @SerializedName("oneClickMaxAmount")
    private String oneClickMaxAmount;

    @SerializedName("binDetail")
    private BinDetail binDetail;

    public boolean isHybridDisabled() {
        return isHybridDisabled;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public boolean isEmiAvailable() {
        return isEmiAvailable;
    }

    public List<String> getAuthModes() {
        return authModes;
    }

    public HasLowSuccess getHasLowSuccessRate() {
        return hasLowSuccessRate;
    }

    public boolean isOneClickSupported() {
        return oneClickSupported;
    }

    public String getOneClickMaxAmount() {
        return oneClickMaxAmount;
    }

    public BinDetail getBinDetail() {
        return binDetail;
    }
}
