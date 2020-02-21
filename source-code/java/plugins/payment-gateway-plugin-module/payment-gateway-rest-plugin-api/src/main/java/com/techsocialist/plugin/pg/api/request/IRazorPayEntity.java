package com.techsocialist.plugin.pg.api.request;

public interface IRazorPayEntity {

    public static final String CUSTOMER_ENTITY = "Customer";
    public static final String ORDER_ENTITY = "Order";
    public static final String PAYMENT_ENTITY = "Payment";


    public IRazorPayEntity setId(String id);

    public IRazorPayEntity setEntity(String entity);

    public IRazorPayEntity setCreatedAt(long createdAt);

}
