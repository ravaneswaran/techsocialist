package com.techsocialist.plugin.pg.api;

public interface IRazorPayPaymentGatewayCheckoutPlugin extends IPaymentGatewayCheckoutPlugin{

    public String renderManualCheckoutForm(boolean production) throws Exception;

    public IRazorPayPaymentGatewayCheckoutPlugin setMerchantId(String merchantId);

    public IRazorPayPaymentGatewayCheckoutPlugin setTransactionAmount(String transactionAmount);

    public IRazorPayPaymentGatewayCheckoutPlugin setCurrency(String currency);

    public IRazorPayPaymentGatewayCheckoutPlugin setOrderId(String orderId);

    public IRazorPayPaymentGatewayCheckoutPlugin setButtonText(String buttonText);

    public IRazorPayPaymentGatewayCheckoutPlugin setName(String name);

    public IRazorPayPaymentGatewayCheckoutPlugin setDescription(String description);

    public IRazorPayPaymentGatewayCheckoutPlugin setImageUrl(String imageUrl);

    public IRazorPayPaymentGatewayCheckoutPlugin setPrefillName(String prefillName);

    public IRazorPayPaymentGatewayCheckoutPlugin setPrefillEmail(String prefillEmail);

    public IRazorPayPaymentGatewayCheckoutPlugin setPrefillContact(String prefillContact);

    public IRazorPayPaymentGatewayCheckoutPlugin setThemeColor(String themeColor);

    public IRazorPayPaymentGatewayCheckoutPlugin setCallbackUrl(String callbackUrl);

}
