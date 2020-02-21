package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.api.request.IRazorPayRequest;

public class RazorPayCustomerRequest implements IRazorPayRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("contact")
    private String contact;

    @SerializedName("fail_existing")
    private String failExisting;

    public RazorPayCustomerRequest setName(String name) {
        this.name = name;
        return this;
    }

    public RazorPayCustomerRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public RazorPayCustomerRequest setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public RazorPayCustomerRequest setFailExisting(String failExisting) {
        this.failExisting = failExisting;
        return this;
    }
}
