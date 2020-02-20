package com.techsocialist.plugin.pg;

import com.techsocialist.plugin.pg.api.IPayUPaymentGatewayCheckoutPlugin;

//http://developers.payulatam.com/en/web_checkout/integration.html
public class PayUPaymentGatewayCheckoutPlugin implements IPayUPaymentGatewayCheckoutPlugin {

    private String merchantId;

    private String accountId;

    private String description;

    private String referenceCode;

    private String amount;

    private String tax;

    private String taxReturnBase;

    private String currency;

    private String signature;

    private String test;

    private String buyerEmail;

    private String responseUrl;

    private String confirmationUrl;

    private void validate() throws Exception{

        if(null == this.merchantId || this.merchantId.isEmpty()){
            throw new RuntimeException("MERCHANT ID cannot be null or empty...");
        }

        if(null == this.accountId || this.accountId.isEmpty()){
            throw new RuntimeException("ACCOUNT ID cannot be null or empty...");
        }

        if(null == this.description || this.description.isEmpty()){
            throw new RuntimeException("DESCRIPTION cannot be null or empty...");
        }

        if(null == this.referenceCode || this.referenceCode.isEmpty()){
            throw new RuntimeException("REFERENCE CODE cannot be null or empty...");
        }

        if(null == this.amount || this.amount.isEmpty()){
            throw new RuntimeException("AMOUNT cannot be null or empty...");
        }

        if(null == this.tax || this.tax.isEmpty()){
            throw new RuntimeException("TAX cannot be null or empty...");
        }

        if(null == this.taxReturnBase || this.taxReturnBase.isEmpty()){
            throw new RuntimeException("TAX RETURN BASE cannot be null or empty...");
        }

        if(null == this.currency || this.currency.isEmpty()){
            throw new RuntimeException("CURRENCY cannot be null or empty...");
        }

        if(null == this.signature || this.signature.isEmpty()){
            throw new RuntimeException("SIGNATURE cannot be null or empty...");
        }

        if(null == this.test || this.test.isEmpty()){
            throw new RuntimeException("TEST cannot be null or empty...");
        }

        if(null == this.buyerEmail || this.buyerEmail.isEmpty()){
            throw new RuntimeException("BUYER EMAIL cannot be null or empty...");
        }

        if(null == this.responseUrl || this.responseUrl.isEmpty()){
            throw new RuntimeException("RESPONSE URL cannot be null or empty...");
        }

        if(null == this.confirmationUrl || this.confirmationUrl.isEmpty()){
            throw new RuntimeException("CONFIRMATION URL cannot be null or empty...");
        }
    }

    @Override
    public String renderStandardCheckout(boolean production) throws Exception {

        validate();

        StringBuilder outputHtml = new StringBuilder();

        outputHtml.append("<form method=\"post\" action=\"").append(this.getUrl(production)).append("\">").append("\n");
        outputHtml.append("<input name=\"merchantId\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.merchantId).append("\">").append("\n");
        outputHtml.append("<input name=\"accountId\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.accountId).append("\">").append("\n");
        outputHtml.append("<input name=\"description\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.description).append("\">").append("\n");
        outputHtml.append("<input name=\"referenceCode\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.referenceCode).append("\">").append("\n");
        outputHtml.append("<input name=\"amount\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.amount).append("\">").append("\n");
        outputHtml.append("<input name=\"tax\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.tax).append("\">").append("\n");
        outputHtml.append("<input name=\"taxReturnBase\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.taxReturnBase).append("\">").append("\n");
        outputHtml.append("<input name=\"currency\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.currency).append("\">").append("\n");
        outputHtml.append("<input name=\"signature\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.signature).append("\">").append("\n");
        outputHtml.append("<input name=\"test\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.test).append("\">").append("\n");
        outputHtml.append("<input name=\"buyerEmail\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.buyerEmail).append("\">").append("\n");
        outputHtml.append("<input name=\"responseUrl\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.responseUrl).append("\">").append("\n");
        outputHtml.append("<input name=\"confirmationUrl\"").append(" ").append("type=\"hidden\"").append(" ").append("value=\"").append(this.confirmationUrl).append("\">").append("\n");
        outputHtml.append("<input name=\"Submit\"").append(" ").append("type=\"submit\"").append(" ").append("value=\"").append("Pay with PayU").append("\">").append("\n");
        outputHtml.append("</form>");

        return outputHtml.toString();
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setTax(String tax) {
        this.tax = tax;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setTaxReturnBase(String taxReturnBase) {
        this.taxReturnBase = taxReturnBase;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setTest(String test) {
        this.test = test;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
        return this;
    }

    @Override
    public IPayUPaymentGatewayCheckoutPlugin setConfirmationUrl(String confirmationUrl) {
        this.confirmationUrl = confirmationUrl;
        return this;
    }

    @Override
    public String getStagingUrl() {
        return "https://sandbox.checkout.payulatam.com/ppp-web-gateway-payu/";
    }

    @Override
    public String getProductionUrl() {
        return "https://checkout.payulatam.com/ppp-web-gateway-payu/";
    }

    @Override
    public String getUrl(boolean production) {
        return production ? this.getProductionUrl() : this.getStagingUrl();
    }


}
