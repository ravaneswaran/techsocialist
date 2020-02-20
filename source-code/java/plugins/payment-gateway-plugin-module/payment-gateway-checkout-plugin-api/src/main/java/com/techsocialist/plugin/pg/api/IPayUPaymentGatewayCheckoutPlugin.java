package com.techsocialist.plugin.pg.api;

public interface IPayUPaymentGatewayCheckoutPlugin extends IPaymentGatewayCheckoutPlugin{

    public IPayUPaymentGatewayCheckoutPlugin setMerchantId(String merchantId);

    public IPayUPaymentGatewayCheckoutPlugin setAccountId(String accountId);

    public IPayUPaymentGatewayCheckoutPlugin setDescription(String description);

    public IPayUPaymentGatewayCheckoutPlugin setReferenceCode(String referenceCode);

    public IPayUPaymentGatewayCheckoutPlugin setAmount(String amount);

    public IPayUPaymentGatewayCheckoutPlugin setTax(String tax);

    public IPayUPaymentGatewayCheckoutPlugin setTaxReturnBase(String taxReturnBase);

    public IPayUPaymentGatewayCheckoutPlugin setCurrency(String currency);

    public IPayUPaymentGatewayCheckoutPlugin setSignature(String signature);

    public IPayUPaymentGatewayCheckoutPlugin setTest(String test);

    public IPayUPaymentGatewayCheckoutPlugin setBuyerEmail(String buyerEmail);

    public IPayUPaymentGatewayCheckoutPlugin setResponseUrl(String responseUrl);

    public IPayUPaymentGatewayCheckoutPlugin setConfirmationUrl(String confirmationUrl);

    public String getStagingUrl();

    public String getProductionUrl();

    public String getUrl(boolean production);

}
