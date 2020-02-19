package com.techsocialist.plugin.pg.api;

public interface IPaymentGatewayCheckoutPlugin {

    public String renderCheckoutForm(boolean production) throws Exception;

}
