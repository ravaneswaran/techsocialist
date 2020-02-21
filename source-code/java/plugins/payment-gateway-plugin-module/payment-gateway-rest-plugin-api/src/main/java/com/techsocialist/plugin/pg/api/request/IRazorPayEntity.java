package com.techsocialist.plugin.pg.api.request;

public interface IRazorPayEntity {

    public static final String CUSTOMER_ENTITY = "customer";
    public static final String ORDER_ENTITY = "order";
    public static final String PAYMENT_ENTITY = "payment";
    public static final String SETTLEMENT_ENTITY = "settlement";


    public IRazorPayEntity setId(String id);

    public IRazorPayEntity setEntity(String entity);

    public IRazorPayEntity setCreatedAt(long createdAt);

}
