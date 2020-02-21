package com.techsocialist.plugin.pg.razorpay.request.innerstruct;

import com.google.gson.annotations.SerializedName;

public class RazorPayNote {

    @SerializedName("landmark")
    private String landmark;

    @SerializedName("location")
    private String location;

    public RazorPayNote setLandmark(String landmark) {
        this.landmark = landmark;
        return this;
    }

    public RazorPayNote setLocation(String location) {
        this.location = location;
        return this;
    }
}
