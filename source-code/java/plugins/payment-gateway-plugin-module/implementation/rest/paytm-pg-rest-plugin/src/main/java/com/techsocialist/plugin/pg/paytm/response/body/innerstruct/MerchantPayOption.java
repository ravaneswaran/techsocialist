package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MerchantPayOption {

    @SerializedName("paymentModes")
    private List<PaymentMode> paymentModes;

    @SerializedName("savedInstruments")
    private List<SavedInstrument> savedInstruments;

    @SerializedName("savedInstruments")
    private UserProfileSarvatra userProfileSarvatra;

    @SerializedName("savedInstruments")
    private List<ActiveSubscription> activeSubscriptions;

    public List<PaymentMode> getPaymentModes() {
        return paymentModes;
    }

    public List<SavedInstrument> getSavedInstruments() {
        return savedInstruments;
    }

    public UserProfileSarvatra getUserProfileSarvatra() {
        return userProfileSarvatra;
    }

    public List<ActiveSubscription> getActiveSubscriptions() {
        return activeSubscriptions;
    }
}
