package com.techsocialist.plugin.pg;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.techsocialist.plugin.pg.api.IPaytmPaymentGatewayCheckoutPlugin;

import java.util.Map;
import java.util.TreeMap;

public class PaytmPaymentGatewayCheckoutPlugin implements IPaytmPaymentGatewayCheckoutPlugin {

    private String merchantId;

    private String merchantKey;

    private String website;

    private String industryType;

    private String channelId;

    private String orderId;

    private String customerId;

    private String mobileNumber;

    private String email;

    private String transactionAmount;

    private String callbackUrl;

    @Override
    public String renderStandardCheckout(boolean production) throws Exception  {

        if(null == this.merchantId || this.merchantId.isEmpty()){
            throw new RuntimeException("MERCHANT ID cannot be null or empty...");
        }

        if(null == this.merchantKey || this.merchantKey.isEmpty()){
            throw new RuntimeException("MERCHANT KEY cannot be null or empty...");
        }

        if(null == this.orderId || this.orderId.isEmpty()){
            throw new RuntimeException("ORDER ID cannot be null or empty...");
        }

        if(null == this.channelId || this.channelId.isEmpty()){
            throw new RuntimeException("CHANNEL ID cannot be null or empty...");
        }

        if(null == this.customerId || this.customerId.isEmpty()){
            throw new RuntimeException("CUSTOMER ID cannot be null or empty...");
        }

        if(null == this.mobileNumber || this.mobileNumber.isEmpty()){
            throw new RuntimeException("MOBILE NUMBER cannot be null or empty...");
        }

        if(null == this.email || this.email.isEmpty()){
            throw new RuntimeException("EMAIL cannot be null or empty...");
        }

        if(null == this.transactionAmount || this.transactionAmount.isEmpty()){
            throw new RuntimeException("TRANSACTION AMOUNT cannot be null or empty...");
        }

        if(null == this.industryType || this.industryType.isEmpty()){
            throw new RuntimeException("INDUSTRY TYPE cannot be null or empty...");
        }

        if(null == this.website || this.website.isEmpty()){
            throw new RuntimeException("WEBSITE cannot be null or empty...");
        }

        if(null == this.callbackUrl || this.callbackUrl.isEmpty()){
            throw new RuntimeException("CALLBACK URL cannot be null or empty...");
        }


        TreeMap<String, String> paytmParams = new TreeMap<>();
        paytmParams.put("MID", this.merchantId);
        paytmParams.put("WEBSITE", this.website);
        paytmParams.put("INDUSTRY_TYPE_ID", this.industryType);
        paytmParams.put("CHANNEL_ID", this.channelId);
        paytmParams.put("ORDER_ID", this.orderId);
        paytmParams.put("CUST_ID", this.customerId);
        paytmParams.put("MOBILE_NO", this.mobileNumber);
        paytmParams.put("EMAIL", this.email);
        paytmParams.put("TXN_AMOUNT", this.transactionAmount);
        paytmParams.put("CALLBACK_URL", this.callbackUrl);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.merchantKey, paytmParams);

        String url = this.getUrl(production);

        StringBuilder outputHtml = new StringBuilder();
        outputHtml.append("<html>").append("\n");
        outputHtml.append("<head>").append("\n");
        outputHtml.append("<title>Merchant Checkout Page</title>").append("\n");
        outputHtml.append("</head>").append("\n");
        outputHtml.append("<body>").append("\n");
        outputHtml.append("<center><h1>Please do not refresh this page...</h1></center>").append("\n");
        outputHtml.append("<form method='post' action='" + url + "' name='paytm_form'>").append("\n");

        for(Map.Entry<String,String> entry : paytmParams.entrySet()) {
            outputHtml.append("<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'>").append("\n");
        }

        outputHtml.append("<input type='hidden' name='CHECKSUMHASH' value='" + checksum + "'>").append("\n");
        outputHtml.append("</form>").append("\n");
        outputHtml.append("<script type='text/javascript'>").append("\n");
        outputHtml.append("document.paytm_form.submit();").append("\n");
        outputHtml.append("</script>").append("\n");
        outputHtml.append("</body>").append("\n");
        outputHtml.append("</html>");

        return outputHtml.toString();
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setWebsite(String website) {
        this.website = website;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setIndustryType(String industryType) {
        this.industryType = industryType;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    @Override
    public IPaytmPaymentGatewayCheckoutPlugin setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    @Override
    public String getStagingUrl() {
        return "https://securegw-stage.paytm.in/order/process";
    }

    @Override
    public String getProductionUrl() {
        return "https://securegw.paytm.in/order/process";
    }

    @Override
    public String getUrl(boolean production) {
        return production ? this.getProductionUrl() : this.getStagingUrl();
    }
}
