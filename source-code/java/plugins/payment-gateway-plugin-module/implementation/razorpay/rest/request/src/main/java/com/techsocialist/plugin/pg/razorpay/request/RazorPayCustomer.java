package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.razorpay.request.innerstruct.RazorPayNote;

public class RazorPayCustomer extends AbstractRazorPayEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("contact")
    private String contact;

    @SerializedName("gstin")
    private String gstin;

    @SerializedName("notes")
    private RazorPayNote note;

    public RazorPayCustomer(){
        this.setEntity(CUSTOMER_ENTITY);
    }

    public RazorPayCustomer setName(String name) {
        this.name = name;
        return this;
    }

    public RazorPayCustomer setEmail(String email) {
        this.email = email;
        return this;
    }

    public RazorPayCustomer setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public RazorPayCustomer setGstin(String gstin) {
        this.gstin = gstin;
        return this;
    }

    public RazorPayCustomer setNote(RazorPayNote note) {
        this.note = note;
        return this;
    }
}
