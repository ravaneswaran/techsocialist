package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class WalletTransferRequest extends AbstractPaytmRequest{

    private String solution;

    private String subwalletGuid;

    private String amount;

    private String beneficiaryEmail;

    private String beneficiaryContactNumber;

    private boolean validateBeneficiary;

    private String beneficiaryName;

    private String callbackUrl;

    private String comments;

    public WalletTransferRequest setSolution(String solution) {
        this.solution = solution;
        return this;
    }

    public WalletTransferRequest setSubwalletGuid(String subwalletGuid) {
        this.subwalletGuid = subwalletGuid;
        return this;
    }

    public WalletTransferRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public WalletTransferRequest setBeneficiaryEmail(String beneficiaryEmail) {
        this.beneficiaryEmail = beneficiaryEmail;
        return this;
    }

    public WalletTransferRequest setBeneficiaryContactNumber(String beneficiaryContactNumber) {
        this.beneficiaryContactNumber = beneficiaryContactNumber;
        return this;
    }

    public WalletTransferRequest setValidateBeneficiary(boolean validateBeneficiary) {
        this.validateBeneficiary = validateBeneficiary;
        return this;
    }

    public WalletTransferRequest setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
        return this;
    }

    public WalletTransferRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public WalletTransferRequest setComments(String comments) {
        this.comments = comments;
        return this;
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://staging-dashboard.paytm.com/bpay/api/%s/disburse/order/wallet/%s";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://dashboard.paytm.com/bpay/api/%s/disburse/order/wallet/%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion(), this.solution);
    }

    @Override
    public JSONObject data() throws Exception {
        return this.dataBody();
    }

    @Override
    public JSONObject dataHead() throws Exception {
        return null;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject paytmParams = new JSONObject();

        paytmParams.put("subwalletGuid", this.subwalletGuid);
        paytmParams.put("orderId", this.getOrderId());
        paytmParams.put("beneficiaryPhoneNo", this.beneficiaryContactNumber);
        paytmParams.put("amount", this.amount);

        return paytmParams;
    }
}
