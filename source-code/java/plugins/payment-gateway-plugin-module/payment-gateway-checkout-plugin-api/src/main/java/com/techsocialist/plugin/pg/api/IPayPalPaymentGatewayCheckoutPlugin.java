package com.techsocialist.plugin.pg.api;

public interface IPayPalPaymentGatewayCheckoutPlugin extends IPaymentGatewayCheckoutPlugin{

    public String renderSimpleCheckout() throws Exception;

    public IPayPalPaymentGatewayCheckoutPlugin setTotal(String total);

    public IPayPalPaymentGatewayCheckoutPlugin setCurrency(String currency);

    public IPayPalPaymentGatewayCheckoutPlugin setLocale(String locale);

    public IPayPalPaymentGatewayCheckoutPlugin setStyleSize(String styleSize);

    public IPayPalPaymentGatewayCheckoutPlugin setStyleColor(String styleColor);

    public IPayPalPaymentGatewayCheckoutPlugin setStyleShape(String styleShape);

    public IPayPalPaymentGatewayCheckoutPlugin setCommit(String commit);


}
