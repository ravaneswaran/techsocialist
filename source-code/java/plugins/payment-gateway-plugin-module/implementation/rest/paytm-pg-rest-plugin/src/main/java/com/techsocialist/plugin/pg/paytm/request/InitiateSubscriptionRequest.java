package com.techsocialist.plugin.pg.paytm.request;

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

    private int subscriptionFrequency;

    private String subscriptionFrequencyUnit;

    private long subscriptionStartDate;

    private long subscriptionExpiryDate;

    private int subscriptionGraceDays;

    private int subscriptionEnableRetry;

    private int subscriptionRetryCount;

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
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("clientId", this.getClientId());
        head.put("version", this.getVersion());
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", this.getChannelId());
        /*String checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(this.getMerchantKey(), dataBody().toString());*/
        String checksum = this.getMerchantKey();
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
        body.put("subscriptionStartDate", simpleDateFormat.format(new Date(this.subscriptionStartDate)));
        body.put("subscriptionExpiryDate", simpleDateFormat.format(new Date(this.subscriptionExpiryDate)));
        body.put("subscriptionGraceDays", String.valueOf(this.subscriptionGraceDays));
        body.put("subscriptionEnableRetry", String.valueOf(this.subscriptionEnableRetry));
        body.put("subscriptionRetryCount", String.valueOf(this.subscriptionRetryCount));
        body.put("paytmSsoToken", "");
        body.put("callbackUrl", String.format(subscriptionCallbackURL, this.getOrderId()));
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

    public InitiateSubscriptionRequest setSubscriptionFrequency(int subscriptionFrequency) {
        this.subscriptionFrequency = subscriptionFrequency;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionFrequencyUnit(String subscriptionFrequencyUnit) {
        this.subscriptionFrequencyUnit = subscriptionFrequencyUnit;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionStartDate(long subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionExpiryDate(long subscriptionExpiryDate) {
        this.subscriptionExpiryDate = subscriptionExpiryDate;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionGraceDays(int subscriptionGraceDays) {
        this.subscriptionGraceDays = subscriptionGraceDays;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionEnableRetry(int subscriptionEnableRetry) {
        this.subscriptionEnableRetry = subscriptionEnableRetry;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionRetryCount(int subscriptionRetryCount) {
        this.subscriptionRetryCount = subscriptionRetryCount;
        return this;
    }

    public InitiateSubscriptionRequest setSubscriptionCallbackURL(String subscriptionCallbackURL) {
        this.subscriptionCallbackURL = subscriptionCallbackURL;
        return this;
    }
}
