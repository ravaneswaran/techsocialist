package com.techsocialist.plugin.pg.api;

public interface IPaytmPaymentGatewayCheckoutPlugin extends IPaymentGatewayCheckoutPlugin {

    public IPaytmPaymentGatewayCheckoutPlugin setMerchantId(String merchantId);

    public IPaytmPaymentGatewayCheckoutPlugin setMerchantKey(String merchantKey);

    public IPaytmPaymentGatewayCheckoutPlugin setWebsite(String website);

    public IPaytmPaymentGatewayCheckoutPlugin setIndustryType(String industryType);

    public IPaytmPaymentGatewayCheckoutPlugin setChannelId(String channelId);

    public IPaytmPaymentGatewayCheckoutPlugin setOrderId(String orderId);

    public IPaytmPaymentGatewayCheckoutPlugin setCustomerId(String customerId);

    public IPaytmPaymentGatewayCheckoutPlugin setMobileNumber(String mobileNumber);

    public IPaytmPaymentGatewayCheckoutPlugin setEmail(String email);

    public IPaytmPaymentGatewayCheckoutPlugin setTransactionAmount(String transactionAmount);

    public IPaytmPaymentGatewayCheckoutPlugin setCallbackUrl(String callbackUrl);

    public String getStagingUrl();

    public String getProductionUrl();

    public String getUrl(boolean production);

}
