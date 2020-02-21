package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity;

public abstract class AbstractRazorPayEntity implements IRazorPayEntity {

    @SerializedName("id")
    private String id;

    @SerializedName("enitity")
    private String entity;

    @SerializedName("created_at")
    private long createdAt;

    @Override
    public IRazorPayEntity setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public IRazorPayEntity setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    @Override
    public IRazorPayEntity setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
