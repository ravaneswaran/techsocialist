package com.techsocialist.plugin.pg;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.techsocialist.plugin.pg.impl.AbstractPaytmPaymentGatewayRestPlugin;
import com.techsocialist.plugin.pg.paytm.request.AccountListRequest;
import com.techsocialist.plugin.pg.paytm.request.AddFundRequest;
import com.techsocialist.plugin.pg.paytm.request.BankAccountValidationRequest;
import com.techsocialist.plugin.pg.paytm.request.BankTransferRequest;
import com.techsocialist.plugin.pg.paytm.request.CancelSubscriptionRequest;
import com.techsocialist.plugin.pg.paytm.request.ClaimBackFundRequest;
import com.techsocialist.plugin.pg.paytm.request.CreateLinkRequest;
import com.techsocialist.plugin.pg.paytm.request.DirectBankRequest;
import com.techsocialist.plugin.pg.paytm.request.DisburseStatusQueryRequest;
import com.techsocialist.plugin.pg.paytm.request.ExpireLinkRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchBalanceInfoRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchBinDetailsRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchEMIDetailRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchInstrumentRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchLinkRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchNBPaymentChannelRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchPaymentOptionsRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchSubscriptionStatusRequest;
import com.techsocialist.plugin.pg.paytm.request.FetchTransactionRequest;
import com.techsocialist.plugin.pg.paytm.request.InitiateSubscriptionRequest;
import com.techsocialist.plugin.pg.paytm.request.InitiateTransactionRequest;
import com.techsocialist.plugin.pg.paytm.request.MandateFormDownloadRequest;
import com.techsocialist.plugin.pg.paytm.request.MandateFormNotifyRequest;
import com.techsocialist.plugin.pg.paytm.request.MandateFormUploadRequest;
import com.techsocialist.plugin.pg.paytm.request.PaymentStatusRequest;
import com.techsocialist.plugin.pg.paytm.request.ProcessTransactionRequest;
import com.techsocialist.plugin.pg.paytm.request.RefundRequest;
import com.techsocialist.plugin.pg.paytm.request.RefundStatusRequest;
import com.techsocialist.plugin.pg.paytm.request.RenewSubscriptionRequest;
import com.techsocialist.plugin.pg.paytm.request.ResendNotificationLinkRequest;
import com.techsocialist.plugin.pg.paytm.request.SendOTPRequest;
import com.techsocialist.plugin.pg.paytm.request.TransactionStatusRequest;
import com.techsocialist.plugin.pg.paytm.request.UpdateLinkRequest;
import com.techsocialist.plugin.pg.paytm.request.UpdateTransactionRequest;
import com.techsocialist.plugin.pg.paytm.request.ValidateAssetRequest;
import com.techsocialist.plugin.pg.paytm.request.ValidateOTPRequest;
import com.techsocialist.plugin.pg.paytm.request.WalletTransferRequest;

import java.util.HashMap;
import java.util.Map;

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

        //System.out.println("updateTransaction[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String processTransaction(String merchantId, String merchantKey, String orderId, String transactionToken, String paymentMode, String authMode, String cardInfo, String requestType) throws Exception {
        ProcessTransactionRequest paytmRequest = new ProcessTransactionRequest();
        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setPaymentMode(paymentMode).setAuthMode(authMode).setCardInfo(cardInfo).setRequestType(requestType);
        paytmRequest.setTransactionToken(transactionToken);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("processTransaction[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String paymentStatus(String merchantId, String merchantKey, String orderId) throws Exception {
        PaymentStatusRequest paytmRequest = new PaymentStatusRequest();
        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("paymentStatus[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String initiateSubscription(String merchantId, String merchantKey, String customerId, String orderId, String currency, String transactionAmount, String subscriptionMaxAmount, String subscriptionPaymentMode, String subscriptionAmountType, String subscriptionFrequency, String subscriptionFrequencyUnit, String subscriptionStartDate, String subscriptionExpiryDate, String subscriptionGraceDays, String subscriptionEnableRetry, String subscriptionRetryCount, String subscriptionCallbackURL) throws Exception {

        InitiateSubscriptionRequest paytmRequest = new InitiateSubscriptionRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);

        paytmRequest.setCurrency(currency).setTransactionAmount(transactionAmount).setSubscriptionMaxAmount(subscriptionMaxAmount);
        paytmRequest.setSubscriptionPaymentMode(subscriptionPaymentMode).setSubscriptionAmountType(subscriptionAmountType);
        paytmRequest.setSubscriptionFrequency(subscriptionFrequency).setSubscriptionFrequencyUnit(subscriptionFrequencyUnit);
        paytmRequest.setSubscriptionStartDate(subscriptionStartDate).setSubscriptionExpiryDate(subscriptionExpiryDate);
        paytmRequest.setSubscriptionGraceDays(subscriptionGraceDays).setSubscriptionEnableRetry(subscriptionEnableRetry);
        paytmRequest.setSubscriptionRetryCount(subscriptionRetryCount).setSubscriptionCallbackURL(subscriptionCallbackURL);
        paytmRequest.setCustomerId(customerId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("initiateSubscription[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchBinDetails(String merchantId, String merchantKey, String orderId, String transactionToken, String bin) throws Exception {

        FetchBinDetailsRequest paytmRequest = new FetchBinDetailsRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setTransactionToken(transactionToken);
        paytmRequest.setBin(bin);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchBinDetails[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchNBPaymentChannel(String merchantId, String merchantKey, String version, String channelId, String requestTimestamp, String orderId, String transactionToken, String type) throws Exception {

        FetchNBPaymentChannelRequest paytmRequest = new FetchNBPaymentChannelRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setTransactionToken(transactionToken);
        paytmRequest.setType(type);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchNBPaymentChannel[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchEMIDetail(String merchantId, String merchantKey, String version, String channelId, String requestTimestamp, String transactionToken, String[] channelCodes, String amount) throws Exception {

        FetchEMIDetailRequest paytmRequest = new FetchEMIDetailRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setVersion(version);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setTransactionToken(transactionToken);

        paytmRequest.setChannelCodes(channelCodes).setAmount(amount);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchEMIDetail[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String sendOTP(String merchantId, String merchantKey, String version, String channelId, String requestTimestamp, String transactionToken, String mobileNumber) throws Exception {

        SendOTPRequest paytmRequest = new SendOTPRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setVersion(version);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setTransactionToken(transactionToken);

        paytmRequest.setMobileNumber(mobileNumber);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("sendOTP[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;

    }

    @Override
    public String validateOTP(String merchantId, String merchantKey, String version, String channelId, String requestTimestamp, String transactionToken, String otp) throws Exception {
        ValidateOTPRequest paytmRequest = new ValidateOTPRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setVersion(version);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setTransactionToken(transactionToken);

        paytmRequest.setOtp(otp);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("validateOTP[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String directBankRequest(String merchantId, String merchantKey, String orderId, String transactionToken, String requestType, String otp) throws Exception {

        DirectBankRequest paytmRequest = new DirectBankRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setOrderId(orderId);
        paytmRequest.setTransactionToken(transactionToken);
        paytmRequest.setRequestType(requestType).setOtp(otp);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("directBankRequest[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String cancelSubscription(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String tokenType, String subscriptionId, String ssoToken) throws Exception {

        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);

        paytmRequest.setTokenType(tokenType).setSsoToken(ssoToken).setSubscriptionId(subscriptionId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("cancelSubscription[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchInstrument(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String userToken, String transactionAmount) throws Exception {

        FetchInstrumentRequest paytmRequest = new FetchInstrumentRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setChannelId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);

        paytmRequest.setUserToken(userToken).setTransactionAmount(transactionAmount);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchInstrument[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String renewSubscription(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String orderId, String transactionAmount, String currency, String subscriptionId) throws Exception {

        RenewSubscriptionRequest paytmRequest = new RenewSubscriptionRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setChannelId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setOrderId(orderId);

        paytmRequest.setTransactionAmount(transactionAmount).setCurrency(currency).setSubscriptionId(subscriptionId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("renewSubscription[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String createLink(String merchantId, String merchantKey, String channelId, String version, String requestTimestamp, String tokenType, String merchantRequestId, String linkName, String linkDescription, String linkType, String amount, String expiryDate, boolean sendSMS, boolean sendEmail, String statusCallbackUrl, String maxPaymentsAllowed) throws Exception {

        CreateLinkRequest paytmRequest = new CreateLinkRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);

        paytmRequest.setTokenType(tokenType).setMerchantRequestId(merchantRequestId);
        paytmRequest.setLinkName(linkName).setLinkDescription(linkDescription).setLinkType(linkType).setAmount(amount).setExpiryDate(expiryDate).setSendSMS(sendSMS).setSendEmail(sendEmail).setStatusCallbackUrl(statusCallbackUrl).setMaxPaymentsAllowed(maxPaymentsAllowed);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("createLink[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchLink(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String tokenType, String linkId, String linkDescription, String merchantRequestId, String pageNo, String pageSize, String customerName, String customerPhone, String customerEmail, String paymentStatus) throws Exception{

        FetchLinkRequest paytmRequest = new FetchLinkRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);

        paytmRequest.setLinkId(linkId).setMerchantRequestId(merchantRequestId).setTokenType(tokenType);

        paytmRequest.setPaymentStatus(paymentStatus).setPageSize(pageSize).setPageNo(pageNo).setCustomerEmail(customerEmail).setCustomerName(customerName).setCustomerPhone(customerPhone).setLinkDescription(linkDescription);


        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchLink[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchTransaction(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String tokenType, String linkId, String pageNo, String pageSize, String searchStartDate, String searchEndDate) throws Exception {

        FetchTransactionRequest paytmRequest = new FetchTransactionRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setTokenType(tokenType).setLinkId(linkId).setPageNo(pageNo).setPageSize(pageSize);
        paytmRequest.setSearchEndDate(searchEndDate).setSearchStartDate(searchStartDate);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("fetchTransaction[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String updateLink(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String tokenType, String merchantRequestId, String linkId, String linkDescription, String expiryDate, String amount) throws Exception {

        UpdateLinkRequest paytmRequest = new UpdateLinkRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setTokenType(tokenType).setLinkId(linkId).setTimestamp(requestTimestamp).setMerchantRequestId(merchantRequestId);
        paytmRequest.setLinkDescription(linkDescription).setExpiryDate(expiryDate).setAmount(amount);


        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("updateLink[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String expireLink(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String tokenType, String merchantRequestId, String linkId) throws Exception {

        ExpireLinkRequest paytmRequest = new ExpireLinkRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);
        paytmRequest.setTokenType(tokenType).setLinkId(linkId).setTimestamp(requestTimestamp).setMerchantRequestId(merchantRequestId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("expireLink[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String resendNotificationLink(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String tokenType, String linkId, boolean sendSMS, boolean sendEmail, String customerName, String customerEmail, String customerMobileNumber) throws Exception {

        ResendNotificationLinkRequest paytmRequest = new ResendNotificationLinkRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);

        paytmRequest.setTokenType(tokenType).setLinkId(linkId).setTimestamp(requestTimestamp);
        paytmRequest.setSendSMS(sendSMS).setSendEmail(sendEmail).setCustomerName(customerName).setCustomerEmail(customerEmail).setCustomerMobileNumber(customerMobileNumber);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("resendNotificationLink[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String validateAsset(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String channelId, String requestId, String vpa, String customerAccountNumber, String bankIfscCode, String customerFirstName, String customerLastName, String customerMobileNumber) throws Exception {

        ValidateAssetRequest paytmRequest = new ValidateAssetRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setMerchantKey(merchantKey);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setChannelId(channelId);

        paytmRequest.setRequestId(requestId).setCustomerAccountNumber(customerAccountNumber).setBankIfscCode(bankIfscCode).setCustomerFirstName(customerFirstName);
        paytmRequest.setCustomerLastName(customerLastName).setCustomerMobileNumber(customerMobileNumber).setVpa(vpa);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        //System.out.println("validateAsset[jsonResponse] ----->>>>> "+jsonResponse);
        //System.out.println("<-------------------------------------------------------->");
        //System.out.println();

        return jsonResponse;
    }

    @Override
    public String walletTransfer(String merchantId, String merchantKey, String version, String solution, String orderId, String subwalletGuid, String amount, String beneficiaryEmail, String beneficiaryContactNumber, boolean validateBeneficiary, String beneficiaryName, String callbackUrl, String comments) throws Exception {

        WalletTransferRequest paytmRequest = new WalletTransferRequest();

        paytmRequest.setOrderId(orderId);
        paytmRequest.setVersion(version);

        paytmRequest.setSubwalletGuid(subwalletGuid).setAmount(amount).setBeneficiaryName(beneficiaryName);
        paytmRequest.setBeneficiaryEmail(beneficiaryEmail).setBeneficiaryContactNumber(beneficiaryContactNumber);
        paytmRequest.setValidateBeneficiary(validateBeneficiary).setCallbackUrl(callbackUrl).setComments(comments);
        paytmRequest.setSolution(solution);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("walletTransfer[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String bankTransfer(String merchantId, String merchantKey, String version, String orderId, String subwalletGuid, String amount, String beneficiaryAccount, String beneficiaryIFSC, String purpose, String date, String transferMode, String callbackUrl, String comments) throws Exception {

        BankTransferRequest paytmRequest = new BankTransferRequest();

        paytmRequest.setOrderId(orderId);
        paytmRequest.setVersion(version);

        paytmRequest.setAmount(amount).setBeneficiaryAccount(beneficiaryAccount).setBeneficiaryIFSC(beneficiaryIFSC).setSubwalletGuid(subwalletGuid);
        paytmRequest.setPurpose(purpose).setTransferMode(transferMode).setDate(date).setCallbackUrl(callbackUrl).setComments(comments);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("bankTransfer[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String addFund(String merchantId, String merchantKey, String version, String subwalletGuid, String amount) throws Exception {

        AddFundRequest paytmRequest = new AddFundRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setVersion(version);

        paytmRequest.setAmount(amount).setSubwalletGuid(subwalletGuid);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("addFund[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String claimBackFund(String merchantId, String merchantKey, String version, String subwalletGuid, String amount) throws Exception {

        ClaimBackFundRequest paytmRequest = new ClaimBackFundRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setVersion(version);

        paytmRequest.setAmount(amount).setSubwalletGuid(subwalletGuid);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("claimBackFund[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String accountList(String merchantId, String merchantKey, String version, String subwalletGuid) throws Exception {

        AccountListRequest paytmRequest = new AccountListRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setVersion(version);
        paytmRequest.setSubwalletGuid(subwalletGuid);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("accountList[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String bankAccountValidation(String merchantId, String merchantKey, String version, String orderId, String subwalletGuid, String beneficiaryAccount, String beneficiaryIFSC, String beneficiaryVPA, String callbackUrl) throws Exception {

        BankAccountValidationRequest paytmRequest = new BankAccountValidationRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setVersion(version);
        paytmRequest.setOrderId(orderId);

        paytmRequest.setSubwalletGuid(subwalletGuid).setBeneficiaryAccount(beneficiaryAccount).setBeneficiaryIFSC(beneficiaryIFSC);
        paytmRequest.setBeneficiaryVPA(beneficiaryVPA).setCallbackUrl(callbackUrl);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("bankAccountValidation[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String disburseStatusQuery(String merchantId, String merchantKey, String version, String orderId) throws Exception {

        DisburseStatusQueryRequest paytmRequest = new DisburseStatusQueryRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setOrderId(orderId);

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmRequest.dataBody().toString());
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("x-mid", merchantId);
        requestProperties.put("x-checksum", checksum);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", requestProperties, paytmRequest.dataAsJsonString());

        System.out.println("disburseStatusQuery[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String mandateFormDownload(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String tokenType, String subscriptionId) throws Exception {

        MandateFormDownloadRequest paytmRequest = new MandateFormDownloadRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setMerchantKey(merchantKey);

        paytmRequest.setTokenType(tokenType).setSubscriptionId(subscriptionId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        System.out.println("mandateFormDownload[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String mandateFormUpload(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String tokenType, String subscriptionId) throws Exception {

        MandateFormUploadRequest paytmRequest = new MandateFormUploadRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setMerchantKey(merchantKey);

        paytmRequest.setTokenType(tokenType).setSubscriptionId(subscriptionId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        System.out.println("mandateFormUpload[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;


    }

    @Override
    public String mandateFormNotify(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String tokenType, String subscriptionId) throws Exception {

        MandateFormNotifyRequest paytmRequest = new MandateFormNotifyRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setMerchantKey(merchantKey);

        paytmRequest.setTokenType(tokenType).setSubscriptionId(subscriptionId);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        System.out.println("mandateFormNotify[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }

    @Override
    public String fetchSubscriptionStatus(String merchantId, String merchantKey, String clientId, String version, String requestTimestamp, String tokenType, String token, String customerId, String subscriptionId) throws Exception {

        FetchSubscriptionStatusRequest paytmRequest = new FetchSubscriptionStatusRequest();

        paytmRequest.setMerchantId(merchantId);
        paytmRequest.setClientId(clientId);
        paytmRequest.setVersion(version);
        paytmRequest.setRequestTimestamp(requestTimestamp);
        paytmRequest.setMerchantKey(merchantKey);

        paytmRequest.setCustomerId(customerId).setSubscriptionId(subscriptionId).setTokenType(tokenType);

        String jsonResponse = processPaytmRequest(paytmRequest.url(false), "POST", "application/json", paytmRequest.dataAsJsonString());

        System.out.println("fetchSubscriptionStatus[jsonResponse] ----->>>>> "+jsonResponse);
        System.out.println("<-------------------------------------------------------->");
        System.out.println();

        return jsonResponse;
    }
}

