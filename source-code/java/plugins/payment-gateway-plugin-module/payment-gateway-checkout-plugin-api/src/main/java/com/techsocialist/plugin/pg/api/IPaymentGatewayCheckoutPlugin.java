package com.techsocialist.plugin.pg.api;

public interface IPaymentGatewayCheckoutPlugin {

    public String renderStandardCheckoutForm(boolean production) throws Exception;

}
