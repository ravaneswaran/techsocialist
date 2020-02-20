package com.techsocialist.plugin.pg.api;

public interface IPaymentGatewayCheckoutPlugin {

    public String renderStandardCheckout(boolean production) throws Exception;

}
