package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InitiateSubscriptionRequest extends AbstractPaytmRequest{

    private String transactionAmount;

    private String currency;

    private String customerId;

    private String subscriptionMaxAmount;

    private String subscriptionPaymentMode;

    private String subscriptionAmountType;

    private String subscriptionFrequency;

    private String subscriptionFrequencyUnit;

    private String subscriptionStartDate;

    private String subscriptionExpiryDate;

    private String subscriptionGraceDays;

    private String subscriptionEnableRetry;

    private String subscriptionRetryCount;

    private String subscriptionCallbackURL;

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/subscription/create";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/subscription/create";
    }

    @Override
    public String url(boolean production) {
        return String.format("%s?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() throws Exception {
        JSONObject head = new JSONObject();
        head.put("clientId", this.getClientId());
        head.put("version", this.getVersion());
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", this.getChannelId());
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(this.getMerchantKey(), dataBody().toString());
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JSONObject transactionAmount = new JSONObject();
        transactionAmount.put("value", this.transactionAmount);
        transactionAmount.put("currency", this.currency);

        JSONObject userInfo = new JSONObject();
        userInfo.put("custId", this.customerId);

        JSONObject body = new JSONObject();
        body.put("requestType", "NATIVE_SUBSCRIPTION");
        body.put("mid", this.getMerchantId());
        body.put("websiteName", "WEBSTAGING");
        body.put("orderId", this.getOrderId());
        body.put("subscriptionPaymentMode", this.subscriptionPaymentMode);
        body.put("subscriptionAmountType", this.subscriptionAmountType);
        body.put("subscriptionMaxAmount", this.subscriptionMaxAmount);
        body.put("subscriptionFrequency", this.subscriptionFrequency);
        body.put("subscriptionFrequencyUnit", this.subscriptionFrequencyUnit);
        body.put("subscriptionStartDate", this.subscriptionStartDate);
        body.put("subscriptionExpiryDate", this.subscriptionExpiryDate);
        body.put("subscriptionGraceDays", this.subscriptionGraceDays);
        body.put("subscriptionEnableRetry", this.subscriptionEnableRetry);
        body.put("subscriptionRetryCount", this.subscriptionRetryCount);
        body.put("paytmSsoToken", "");
        body.put("callbackUrl", this.subscriptionCallbackURL);
        body.put("userInfo", userInfo);
        body.put("txnAmount", transactionAmount);

        return body;
    }

    public InitiateSubscriptionRequest setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public InitiateSubscriptionRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public InitiateSubscriptionRequest setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionMaxAmount(String subscriptionMaxAmount) {
        this.subscriptionMaxAmount = subscriptionMaxAmount;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionPaymentMode(String subscriptionPaymentMode) {
        this.subscriptionPaymentMode = subscriptionPaymentMode;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionAmountType(String subscriptionAmountType) {
        this.subscriptionAmountType = subscriptionAmountType;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionFrequency(String subscriptionFrequency) {
        this.subscriptionFrequency = subscriptionFrequency;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionFrequencyUnit(String subscriptionFrequencyUnit) {
        this.subscriptionFrequencyUnit = subscriptionFrequencyUnit;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionExpiryDate(String subscriptionExpiryDate) {
        this.subscriptionExpiryDate = subscriptionExpiryDate;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionGraceDays(String subscriptionGraceDays) {
        this.subscriptionGraceDays = subscriptionGraceDays;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionEnableRetry(String subscriptionEnableRetry) {
        this.subscriptionEnableRetry = subscriptionEnableRetry;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionRetryCount(String subscriptionRetryCount) {
        this.subscriptionRetryCount = subscriptionRetryCount;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionCallbackURL(String subscriptionCallbackURL) {
        this.subscriptionCallbackURL = subscriptionCallbackURL;
        return this;
    }
}
