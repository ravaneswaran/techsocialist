package com.techsocialist.plugin.pg;

import com.techsocialist.plugin.pg.impl.AbstractPaytmPaymentGatewayRestPlugin;
import com.techsocialist.plugin.pg.paytm.request.FetchBalanceInfoRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchPaymentOptionsRequest;
import com.techsocialist.plugin.pg.paytm.request.InitiateTransactionRequest;

import java.io.IOException;

public class PaytmPaymentGatewayRestPlugin extends AbstractPaytmPaymentGatewayRestPlugin {

    @Override
    public String initiateTransaction(String merchantId, String merchantKey, String customerId, String orderId, long amount, String currency, String websiteName, String callbackUrl) throws IOException {
        return this.initiateTransaction(merchantId, merchantKey, "C11", "WEB", "v1", orderId, customerId, amount, currency, websiteName, callbackUrl);
    }

    @Override
    public String initiateTransaction(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String customerId, long amount, String currency, String websiteName, String callbackUrl) throws IOException {

        InitiateTransactionRequest paytmRequest = new InitiateTransactionRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setVersion(version);
        paytmRequest.setOrderId(orderId);

        paytmRequest.setCustomerId(customerId).setAmount(amount).setCurrency(currency).setCallbackUrl(callbackUrl).setWebsiteName(websiteName);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        return jsonResponse;
    }

    @Override
    public String fetchBalanceInfo(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode) throws IOException {
        return this.fetchBalanceInfo(merchantId, merchantKey, "C11", "WEB", "v1", orderId, transactionToken, paymentMode);
    }

    @Override
    public String fetchBalanceInfo(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String transactionToken, String paymentMode) throws IOException {
        FetchBalanceInfoRequest paytmRequest = new FetchBalanceInfoRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setVersion(version);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setTransactionToken(transactionToken);

        paytmRequest.setPaymentMode(paymentMode);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println(jsonResponse);

        return jsonResponse;
    }

    @Override
    public String fetchPaymentOptions(String merchantId, String merchantKey, String transactionToken, String orderId) throws IOException {
        FetchPaymentOptionsRequest paytmRequest = new FetchPaymentOptionsRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setTransactionToken(transactionToken);
        paytmRequest.setOrderId(orderId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        System.out.println(jsonResponse);

        return jsonResponse;
    }
}
