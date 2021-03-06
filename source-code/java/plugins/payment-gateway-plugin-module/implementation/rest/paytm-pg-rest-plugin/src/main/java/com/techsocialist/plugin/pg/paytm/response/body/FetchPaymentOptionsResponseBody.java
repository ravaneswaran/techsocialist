package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.AddMoneyPayOption;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantDetails;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantLimitInfo;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantPayOption;

public class FetchPaymentOptionsResponseBody extends AbstractPaytmResponseBody{

    @SerializedName("walletOnly")
    private boolean walletOnly;

    @SerializedName("zeroCostEmi")
    private boolean zeroCostEmi;

    @SerializedName("pcfEnabled")
    private boolean pcfEnabled;

    @SerializedName("nativeJsonRequestSupported")
    private boolean nativeJsonRequestSupported;

    @SerializedName("activeMerchant")
    private boolean  activeMerchant;

    @SerializedName("oneClickMaxAmount")
    private String oneClickMaxAmount;

    @SerializedName("onTheFlyKYCRequired")
    private boolean onTheFlyKYCRequired;

    @SerializedName("paymentFlow")
    private String paymentFlow;

    @SerializedName("merchantDetails")
    private MerchantDetails merchantDetails;

    @SerializedName("merchantPayOption")
    private MerchantPayOption merchantPayOption;

    @SerializedName("addMoneyPayOption")
    private AddMoneyPayOption addMoneyPayOption;

    @SerializedName("merchantLimitInfo")
    private MerchantLimitInfo merchantLimitInfo;

    public boolean isWalletOnly() {
        return walletOnly;
    }

    public boolean isZeroCostEmi() {
        return zeroCostEmi;
    }

    public boolean isPcfEnabled() {
        return pcfEnabled;
    }

    public boolean isNativeJsonRequestSupported() {
        return nativeJsonRequestSupported;
    }

    public boolean isActiveMerchant() {
        return activeMerchant;
    }

    public String getOneClickMaxAmount() {
        return oneClickMaxAmount;
    }

    public boolean isOnTheFlyKYCRequired() {
        return onTheFlyKYCRequired;
    }

    public String getPaymentFlow() {
        return paymentFlow;
    }

    public MerchantDetails getMerchantDetails() {
        return merchantDetails;
    }

    public MerchantPayOption getMerchantPayOption() {
        return merchantPayOption;
    }

    public AddMoneyPayOption getAddMoneyPayOption() {
        return addMoneyPayOption;
    }

    public MerchantLimitInfo getMerchantLimitInfo() {
        return merchantLimitInfo;
    }
}
