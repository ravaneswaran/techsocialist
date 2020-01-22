package com.techsocialist.plugin.pg.api;

import java.io.IOException;

public interface IPaytmPaymentGatewayRestPlugin {

    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception;

    public String initiateTransaction(String merchantId, String merchantKey, String customerId, String orderId, long amount, String currency, String websiteName, String callbackUrl) throws Exception;
    public String initiateTransaction(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String userId, long amount, String currency, String websiteName, String callbackUrl) throws Exception;

    public String fetchBalanceInfo(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode) throws Exception;
    public String fetchBalanceInfo(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String transactionToken, String paymentMode) throws Exception;

    public String fetchPaymentOptions(String merchantId, String merchantKey, String transactionToken, String orderId) throws Exception;

    public String transactionStatus(String merchantId, String merchantKey, String orderId) throws Exception;

    public String refund(String merchantId, String merchantKey, String orderId, String refundId, String transactionId, String clientId,  String refundAmount) throws Exception;

}
