package com.techsocialist.plugin.pg;

import com.techsocialist.plugin.pg.impl.AbstractPaytmPaymentGatewayRestPlugin;
import com.techsocialist.plugin.pg.paytm.request.FetchBalanceInfoRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchPaymentOptionsRequest;
import com.techsocialist.plugin.pg.paytm.request.InitiateTransactionRequest;
import com.techsocialist.plugin.pg.paytm.request.RefundRequest;
import com.techsocialist.plugin.pg.paytm.request.RefundStatusRequest;
import com.techsocialist.plugin.pg.paytm.request.TransactionStatusRequest;
import com.techsocialist.plugin.pg.paytm.request.UpdateTransactionRequest;

public class PaytmPaymentGatewayRestPlugin extends AbstractPaytmPaymentGatewayRestPlugin {

    @Override
    public String initiateTransaction(String merchantId, String merchantKey, String customerId, String orderId, long amount, String currency, String websiteName, String callbackUrl) throws Exception {
        return this.initiateTransaction(merchantId, merchantKey, "C11", "WEB", "v1", orderId, customerId, amount, currency, websiteName, callbackUrl);
    }

    @Override
    public String initiateTransaction(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String customerId, long amount, String currency, String websiteName, String callbackUrl) throws Exception {

        InitiateTransactionRequest paytmRequest = new InitiateTransactionRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setVersion(version);
        paytmRequest.setOrderId(orderId);

        paytmRequest.setCustomerId(customerId).setAmount(amount).setCurrency(currency).setCallbackUrl(callbackUrl).setWebsiteName(websiteName);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("initiateTransaction[jsonResponse] ----->>>>> "+jsonResponse);
        return jsonResponse;
    }

    @Override
    public String fetchBalanceInfo(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode) throws Exception {
        return this.fetchBalanceInfo(merchantId, merchantKey, "C11", "WEB", "v1", orderId, transactionToken, paymentMode);
    }

    @Override
    public String fetchBalanceInfo(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String transactionToken, String paymentMode) throws Exception {
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

        //System.out.println("fetchBalanceInfo[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("< -------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchPaymentOptions(String merchantId, String merchantKey, String transactionToken, String orderId) throws Exception {
        FetchPaymentOptionsRequest paytmRequest = new FetchPaymentOptionsRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setTransactionToken(transactionToken);
        paytmRequest.setOrderId(orderId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchPaymentOptions[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("< -------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String transactionStatus(String merchantId, String merchantKey, String orderId) throws Exception {
        TransactionStatusRequest paytmRequest = new TransactionStatusRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("transactionStatus[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String refund(String merchantId, String merchantKey, String orderId, String refundId, String transactionId, String clientId,  String refundAmount) throws Exception {

        RefundRequest paytmRequest = new RefundRequest();
        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setClientId(clientId);

        paytmRequest.setTransactionId(transactionId).setRefundId(refundId).setAmountToRefund("1000");

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("refund[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String refundStatus(String merchantId, String merchantKey, String orderId, String refundId, String clientId) throws Exception {

        RefundStatusRequest paytmRequest = new RefundStatusRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setRefundId(refundId);
        paytmRequest.setClientId(clientId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("refundStatus[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String updateTransaction(String merchantId, String merchantKey, String orderId, String customerId, String transactionToken, String transactionAmount, String currency) throws Exception {

        UpdateTransactionRequest paytmRequest = new UpdateTransactionRequest();
        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setTransactionToken(transactionToken);
        paytmRequest.setOrderId(orderId);

        paytmRequest.setAmount(transactionAmount).setCurrency(currency).setCustomerId(customerId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        System.out.println("updateTransaction[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }
}
