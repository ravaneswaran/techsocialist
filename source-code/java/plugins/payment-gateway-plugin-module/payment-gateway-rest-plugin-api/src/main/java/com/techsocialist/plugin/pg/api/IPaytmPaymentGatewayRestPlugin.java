package com.techsocialist.plugin.pg.api;

import java.io.IOException;

public interface IPaytmPaymentGatewayRestPlugin {

    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException;

    public String initiateTransaction(String merchantId, String merchantKey, String userId, long amount, String currency, String websiteName, String callbackUrl) throws IOException;
    public String initiateTransaction(String merchantId, String merchantKey, String clientId, String channelId, String version, String userId, long amount, String currency, String websiteName, String callbackUrl) throws IOException;

    public String balanceInfo(String merchantId, String merchantKey, String transactionToken, String paymentMode) throws IOException;
    public String balanceInfo(String merchantId, String merchantKey, String clientId, String channelId, String version, String transactionToken, String paymentMode) throws IOException;

}
