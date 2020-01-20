package com.techsocialist.plugin.pg.api;

import java.io.IOException;

public interface IPaytmPaymentGatewayRestPlugin {

    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException;

    public String initiateTransaction(String merchantId, String merchantKey, String customerId, String orderId, long amount, String currency, String websiteName, String callbackUrl) throws IOException;
    public String initiateTransaction(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String userId, long amount, String currency, String websiteName, String callbackUrl) throws IOException;

    public String fetchBalanceInfo(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode) throws IOException;
    public String fetchBalanceInfo(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String transactionToken, String paymentMode) throws IOException;

    public String fetchPaymentOptions(String merchantId, String merchantKey, String transactionToken, String orderId) throws IOException;

}
