package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApplyPromoRequest extends AbstractPaytmRequest {

    private String tokenType;

    private String token;

    private String customerId;

    private String promoCode;

    private String transactionAmount;

    private String payMethod;

    private String bankCode;

    private String cardNo;

    private String savedCardId;

    private String vpa;

    private String totalTransactionAmount;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/theia/api/%s/applyPromo?mid=%s";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/theia/api/%s/applyPromo?mid=%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion(), this.getMerchantId());
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        head.put("channelId", this.getChannelId());
        head.put("tokenType", this.tokenType);
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());

        head.put("token", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("custId", this.customerId);

        JSONObject paymentOptions = new JSONObject();
        paymentOptions.put("transactionAmount", this.transactionAmount);
        paymentOptions.put("payMethod", this.payMethod);
        paymentOptions.put("bankCode", this.bankCode);
        paymentOptions.put("cardNo", this.cardNo);

        JSONArray paymentOptionsArray = new JSONArray();
        paymentOptionsArray.put(paymentOptions);

        body.put("paymentOptions", paymentOptionsArray);
        body.put("totalTransactionAmount", this.totalTransactionAmount);

        return body;
    }

    public ApplyPromoRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public ApplyPromoRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public ApplyPromoRequest setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public ApplyPromoRequest setPromoCode(String promoCode) {
        this.promoCode = promoCode;
        return this;
    }

    public ApplyPromoRequest setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public ApplyPromoRequest setPayMethod(String payMethod) {
        this.payMethod = payMethod;
        return this;
    }

    public ApplyPromoRequest setBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    public ApplyPromoRequest setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public ApplyPromoRequest setSavedCardId(String savedCardId) {
        this.savedCardId = savedCardId;
        return this;
    }

    public ApplyPromoRequest setVpa(String vpa) {
        this.vpa = vpa;
        return this;
    }

    public ApplyPromoRequest setTotalTransactionAmount(String totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
        return this;
    }
}
