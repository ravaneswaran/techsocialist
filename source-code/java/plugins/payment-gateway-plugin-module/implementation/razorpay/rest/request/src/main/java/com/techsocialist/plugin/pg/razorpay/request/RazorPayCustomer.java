package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity;
import com.techsocialist.plugin.pg.razorpay.request.innerstruct.RazorPayNote;

public class RazorPayCustomer implements IRazorPayEntity {

    @SerializedName("id")
    private String id;

    @SerializedName("entity")
    private String entity;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("contact")
    private String contact;

    @SerializedName("gstin")
    private String gstin;

    @SerializedName("created_at")
    private long createdAt;

    @SerializedName("notes")
    private RazorPayNote note;

    public RazorPayCustomer(){
        this.setEntity(CUSTOMER_ENTITY);
    }

    public RazorPayCustomer setId(String id) {
        this.id = id;
        return this;
    }

    public RazorPayCustomer setEntity(String entity) {
        this.entity = entity;
        return this;
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

    public RazorPayCustomer setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public RazorPayCustomer setNote(RazorPayNote note) {
        this.note = note;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getEntity() {
        return entity;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getGstin() {
        return gstin;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public RazorPayNote getNote() {
        return note;
    }
}
