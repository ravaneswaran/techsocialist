package com.techsocialist.plugin.pg;

import com.techsocialist.plugin.pg.api.IPayPalPaymentGatewayCheckoutPlugin;

public class PayPalPaymentGatewayCheckoutPlugin implements IPayPalPaymentGatewayCheckoutPlugin {

    private String total;

    private String currency;

    private String locale;

    private String styleSize;

    private String styleColor;

    private String styleShape;

    private String commit;

    private String environment;

    private void validate(){

        if(null == this.total || this.total.isEmpty()){
            throw new RuntimeException("TOTAL cannot be null or empty...");
        }

        if(null == this.currency || this.currency.isEmpty()){
            throw new RuntimeException("CURRENCY cannot be null or empty...");
        }

        if(null == this.locale || this.locale.isEmpty()){
            throw new RuntimeException("LOCALE cannot be null or empty...");
        }

        if(null == this.styleSize || this.styleSize.isEmpty()){
            throw new RuntimeException("STYLE SIZE cannot be null or empty...");
        }

        if(null == this.styleColor || this.styleColor.isEmpty()){
            throw new RuntimeException("STYLE COLOR cannot be null or empty...");
        }

        if(null == this.styleShape || this.styleShape.isEmpty()){
            throw new RuntimeException("STYLE SHAPE cannot be null or empty...");
        }

        if(null == this.commit || this.commit.isEmpty()){
            throw new RuntimeException("COMMIT cannot be null or empty...");
        }

    }

    @Override
    public String renderStandardCheckout(boolean production) throws Exception {
        this.environment = production ? "production" : "sandbox";
        return this.renderSimpleCheckout();
    }

    @Override
    public String renderSimpleCheckout() throws Exception {

        validate();

        StringBuilder outputHtml = new StringBuilder();

        outputHtml.append("<div id=\"paypal-button\"></div>").append("\n");
        outputHtml.append("<script src=\"https://www.paypalobjects.com/api/checkout.js\"></script>").append("\n");
        outputHtml.append("<script>").append("\n");
        outputHtml.append("paypal.Button.render({").append("\n");
        outputHtml.append("env").append(":").append("'").append(this.environment).append("'").append(",").append("\n");

        outputHtml.append("client").append(":").append("{").append("\n");
        outputHtml.append("sandbox").append(":").append("'").append("demo_sandbox_client_id").append("'").append(",").append("\n");
        outputHtml.append("production").append(":").append("'").append("demo_production_client_id").append("'").append("\n");
        outputHtml.append("}").append(",").append("\n");

        outputHtml.append("locale").append(":").append("'").append(this.locale).append("'").append(",").append("\n");

        outputHtml.append("style").append(":").append("{").append("\n");
        outputHtml.append("size").append(":").append("'").append(this.styleSize).append("'").append(",").append("\n");
        outputHtml.append("color").append(":").append("'").append(this.styleColor).append("'").append(",").append("\n");
        outputHtml.append("shape").append(":").append("'").append(this.styleShape).append("'").append(",").append("\n");
        outputHtml.append("}").append(",").append("\n");

        outputHtml.append("commit").append(":").append(this.commit).append(",").append("\n");

        outputHtml.append("payment").append(":").append("function(data, actions) {").append("\n");
        outputHtml.append("return actions.payment.create({").append("\n");
        outputHtml.append("transactions: [{").append("\n");
        outputHtml.append("amount: {").append("\n");
        outputHtml.append("total").append(":").append("'").append(this.total).append("'").append(",").append("\n");
        outputHtml.append("currency").append(":").append("'").append(this.currency).append("'").append("\n");
        outputHtml.append("}").append("\n");
        outputHtml.append("}]").append("\n");
        outputHtml.append("});").append("\n");
        outputHtml.append("},").append("\n");

        outputHtml.append("onAuthorize: function(data, actions) {").append("\n");
        outputHtml.append("return actions.payment.execute().then(function() {").append("\n");
        outputHtml.append("window.alert('Thank you for your purchase!');").append("\n");
        outputHtml.append("});").append("\n");
        outputHtml.append("}").append("\n");
        outputHtml.append("}, '#paypal-button');").append("\n");
        outputHtml.append("</script>").append("\n");

        return outputHtml.toString();
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setTotal(String total) {
        this.total = total;
        return this;
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setStyleSize(String styleSize) {
        this.styleSize = styleSize;
        return this;
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setStyleColor(String styleColor) {
        this.styleColor = styleColor;
        return this;
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setStyleShape(String styleShape) {
        this.styleShape = styleShape;
        return this;
    }

    @Override
    public IPayPalPaymentGatewayCheckoutPlugin setCommit(String commit) {
        this.commit = commit;
        return this;
    }
}
