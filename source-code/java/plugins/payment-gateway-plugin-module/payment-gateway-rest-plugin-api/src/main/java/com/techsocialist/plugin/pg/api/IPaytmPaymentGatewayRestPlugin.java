package com.techsocialist.plugin.pg.api;

public interface IPaytmPaymentGatewayRestPlugin {

    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception;

    public String initiateTransaction(String merchantId, String merchantKey, String customerId, String orderId, long amount, String currency, String websiteName, String callbackUrl) throws Exception;
    public String initiateTransaction(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String userId, long amount, String currency, String websiteName, String callbackUrl) throws Exception;

    public String fetchBalanceInfo(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode) throws Exception;
    public String fetchBalanceInfo(String merchantId, String merchantKey, String clientId, String channelId, String version, String orderId, String transactionToken, String paymentMode) throws Exception;

    public String fetchPaymentOptions(String merchantId, String merchantKey, String transactionToken, String orderId) throws Exception;

    public String transactionStatus(String merchantId, String merchantKey, String orderId) throws Exception;

    public String refund(String merchantId, String merchantKey, String orderId, String refundId, String transactionId, String clientId,  String refundAmount) throws Exception;

    public String refundStatus(String merchantId, String merchantKey, String orderId, String refundId, String clientId) throws Exception;

    public String updateTransaction(String merchantId, String merchantKey, String orderId, String customerId, String transactionToken, String transactionAmount, String currency) throws Exception;

    public String processTransaction(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode, String authMode, String cardInfo, String requestType) throws Exception;

    public String paymentStatus(String merchantId, String merchantKey, String orderId) throws Exception;

    public String initiateSubscription(String merchantId, String merchantKey, String customerId, String orderId, String currency, String transactionAmount, String subscriptionMaxAmount, String subscriptionPaymentMode, String subscriptionAmountType, String subscriptionFrequency, String subscriptionFrequencyUnit, String subscriptionStartDate, String subscriptionExpiryDate, String subscriptionGraceDays, String subscriptionEnableRetry, String subscriptionRetryCount, String subscriptionCallbackURL) throws Exception;

    public String fetchBinDetails(String merchantId, String merchantKey, String orderId, String transactionToken, String bin) throws Exception;



    public String fetchNBPaymentChannel(String merchantId, String merchantKey, String version, String channelId, String requestTimestamp, String orderId, String transactionToken, String type) throws Exception;

    public String fetchEMIDetail(String merchantId, String merchantKey, String version, String channelId, String requestTimestamp, String transactionToken, String[] channelCodes, String amount) throws Exception;

    public String sendOTP(String merchantId, String  merchantKey, String version, String channelId, String requestTimestamp, String transactionToken, String mobileNumber) throws Exception;

    public String validateOTP(String merchantId, String  merchantKey, String version, String channelId, String requestTimestamp, String transactionToken, String otp) throws Exception;

    public String directBankRequest(String merchantId, String merchantKey, String orderId, String transactionToken, String requestType, String otp) throws Exception;
}
