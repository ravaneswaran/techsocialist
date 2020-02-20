package com.techsocialist.plugin.pg.razorpay.request.innerstruct;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity;

public class RazorPayNote implements IRazorPayEntity {

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

    public String getLandmark() {
        return landmark;
    }

    public String getLocation() {
        return location;
    }
}
