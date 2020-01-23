package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BankForm {

    @SerializedName("pageType")
    private String pageType;

    @SerializedName("isForceResendOtp")
    private boolean isForceResendOtp;

    @SerializedName("redirectForm")
    private RedirectForm redirectForm;

    @SerializedName("directForms")
    private List<DirectForm> directForms;

    @SerializedName("displayField")
    private DisplayField displayField;

    public String getPageType() {
        return pageType;
    }

    public boolean isForceResendOtp() {
        return isForceResendOtp;
    }

    public RedirectForm getRedirectForm() {
        return redirectForm;
    }

    public List<DirectForm> getDirectForms() {
        return directForms;
    }

    public DisplayField getDisplayField() {
        return displayField;
    }
}
