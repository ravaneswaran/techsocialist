package com.techsocialist.plugin.pg;

import com.techsocialist.plugin.pg.api.IRazorPayPaymentGatewayCheckoutPlugin;

public class RazorPayPaymentGatewayCheckoutPlugin implements IRazorPayPaymentGatewayCheckoutPlugin {

    private String merchantId;

    private String transactionAmount;

    private String currency;

    private String orderId;

    private String buttonText;

    private String name;

    private String description;

    private String imageUrl;

    private String prefillName;

    private String prefillEmail;

    private String prefillContact;

    private String themeColor;

    private String callbackUrl;

    private void validate() throws Exception {

        if(null == this.merchantId || this.merchantId.isEmpty()){
            throw new RuntimeException("MERCHANT ID cannot be null or empty...");
        }

        if(null == this.transactionAmount || this.transactionAmount.isEmpty()){
            throw new RuntimeException("TRANSACTION AMOUNT cannot be null or empty...");
        }

        if(null == this.currency || this.currency.isEmpty()){
            throw new RuntimeException("CURRENCY cannot be null or empty...");
        }

        if(null == this.orderId || this.orderId.isEmpty()){
            throw new RuntimeException("ORDER ID cannot be null or empty...");
        }

        if(null == this.buttonText || this.buttonText.isEmpty()){
            this.buttonText = "Pay with Razorpay";
        }

        if(null == this.name || this.name.isEmpty()){
            throw new RuntimeException("NAME cannot be null or empty...");
        }

        if(null == this.description){
            this.description = "";
        }

        if(null == this.imageUrl || this.imageUrl.isEmpty()){
            throw new RuntimeException("IMAGE URL cannot be null or empty...");
        }

        if(null == this.prefillName || this.prefillName.isEmpty()){
            throw new RuntimeException("PREFILL NAME cannot be null or empty...");
        }

        if(null == this.prefillEmail || this.prefillEmail.isEmpty()){
            throw new RuntimeException("PREFILL EMAIL cannot be null or empty...");
        }

        if(null == this.prefillContact || this.prefillContact.isEmpty()){
            throw new RuntimeException("PREFILL CONTACT cannot be null or empty...");
        }

        if(null == this.themeColor || this.themeColor.isEmpty()){
            this.themeColor = "#F37254";
        }

        if(null == this.callbackUrl || this.callbackUrl.isEmpty()){
            throw new RuntimeException("CALLBACK URL cannot be null or empty...");
        }
    }

    @Override
    public String renderStandardCheckoutForm(boolean production) throws Exception {

        validate();

        StringBuilder outputHtml = new StringBuilder();

        outputHtml.append("<form action=").append("\"").append(this.callbackUrl).append("\" method=\"POST\">").append("\n");

        outputHtml.append("<script").append("\n");
        outputHtml.append("src=").append("\"").append("https://checkout.razorpay.com/v1/checkout.js").append("\"").append("\n");
        outputHtml.append("data-key=").append("\"").append(this.merchantId).append("\"").append("\n");
        outputHtml.append("data-amount=").append("\"").append(this.transactionAmount).append("\"").append("\n");
        outputHtml.append("data-currency=").append("\"").append(this.currency).append("\"").append("\n");
        outputHtml.append("data-order_id=").append("\"").append(this.orderId).append("\"").append("\n");
        outputHtml.append("data-buttontext=").append("\"").append(this.buttonText).append("\"").append("\n");
        outputHtml.append("data-name=").append("\"").append(this.name).append("\"").append("\n");
        outputHtml.append("data-description=").append("\"").append(this.description).append("\"").append("\n");
        outputHtml.append("data-image=").append("\"").append(this.imageUrl).append("\"").append("\n");
        outputHtml.append("data-prefill.name=").append("\"").append(this.prefillName).append("\"").append("\n");
        outputHtml.append("data-prefill.email=").append("\"").append(this.prefillEmail).append("\"").append("\n");
        outputHtml.append("data-prefill.contact=").append("\"").append(this.prefillContact).append("\"").append("\n");
        outputHtml.append("data-theme.color=").append("\"").append(this.themeColor).append("\"").append("\n");
        outputHtml.append("></script>").append("\n");
        outputHtml.append("<input type=\"hidden\" custom=\"Hidden Element\" name=\"hidden\">").append("\n");
        outputHtml.append("</form>");

        return outputHtml.toString();
    }

    @Override
    public String renderManualCheckoutForm(boolean production) throws Exception {

        validate();

        StringBuilder outputHtml = new StringBuilder();

        outputHtml.append("<button id=\"rzp-button1\">Pay with Razorpay</button>").append("\n");
        outputHtml.append("<script src=\"https://checkout.razorpay.com/v1/checkout.js\"></script>").append("\n");
        outputHtml.append("<script>").append("\n");
        outputHtml.append("var options = {").append("\n");
        outputHtml.append("\"").append("key").append("\"").append(":").append("\"").append(this.merchantId).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("amount").append("\"").append(":").append("\"").append(this.transactionAmount).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("currency").append("\"").append(":").append("\"").append(this.currency).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("name").append("\"").append(":").append("\"").append(this.name).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("description").append("\"").append(":").append("\"").append(this.description).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("image").append("\"").append(":").append("\"").append(this.imageUrl).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("order_id").append("\"").append(":").append("\"").append(this.orderId).append("\"").append(",").append("\n");

        outputHtml.append("\"").append("handler").append("\"").append(":").append("function (response){").append("\n");
        outputHtml.append("alert(response.razorpay_payment_id);").append("\n");
        outputHtml.append("}").append(",").append("\n");

        outputHtml.append("\"").append("prefill").append("\"").append(":").append("{").append("\n");
        outputHtml.append("\"").append("name").append("\"").append(":").append("\"").append(this.prefillName).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("email").append("\"").append(":").append("\"").append(this.prefillEmail).append("\"").append(",").append("\n");
        outputHtml.append("\"").append("contact").append("\"").append(":").append("\"").append(this.prefillContact).append("\"").append(",").append("\n");
        outputHtml.append("}").append(",").append("\n");

        outputHtml.append("\"").append("notes").append("\"").append(":").append("{").append("\n");
        outputHtml.append("\"").append("address").append("\"").append(":").append("\"").append("note value").append("\"").append("\n");
        outputHtml.append("}").append(",").append("\n");

        outputHtml.append("\"").append("theme").append("\"").append(":").append("{").append("\n");
        outputHtml.append("\"").append("color").append("\"").append(":").append("\"").append(this.themeColor).append("\"").append("\n");
        outputHtml.append("}").append("\n");
        outputHtml.append("}").append(";").append("\n");

        outputHtml.append("var rzp1 = new Razorpay(options);").append("\n");
        outputHtml.append("document.getElementById('rzp-button1').onclick = function(e){").append("\n");
        outputHtml.append("rzp1.open();").append("\n");
        outputHtml.append("e.preventDefault();").append("\n");
        outputHtml.append("}").append("\n");
        outputHtml.append("</script>").append("\n");

        return outputHtml.toString();
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setPrefillName(String prefillName) {
        this.prefillName = prefillName;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setPrefillEmail(String prefillEmail) {
        this.prefillEmail = prefillEmail;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setPrefillContact(String prefillContact) {
        this.prefillContact = prefillContact;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setThemeColor(String themeColor) {
        this.themeColor = themeColor;
        return this;
    }

    @Override
    public IRazorPayPaymentGatewayCheckoutPlugin setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }
}
