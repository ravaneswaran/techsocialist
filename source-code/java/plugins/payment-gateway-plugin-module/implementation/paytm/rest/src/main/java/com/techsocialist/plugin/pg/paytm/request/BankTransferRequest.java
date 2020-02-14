package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class BankTransferRequest extends AbstractPaytmRequest {

    private String subwalletGuid;

    private String amount;

    private String beneficiaryAccount;

    private String beneficiaryIFSC;

    private String purpose;

    private String date;

    private String callbackUrl;

    private String comments;

    private String transferMode;

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://dashboard.paytm.com/bpay/api/%s/disburse/order/bank";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://staging-dashboard.paytm.com/bpay/api/%s/disburse/order/bank";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion());
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
        paytmParams.put("beneficiaryAccount", this.beneficiaryAccount);
        paytmParams.put("beneficiaryIFSC", this.beneficiaryIFSC);
        paytmParams.put("amount", this.amount);
        paytmParams.put("purpose", this.purpose);
        paytmParams.put("date", this.date);

        return paytmParams;
    }

    public BankTransferRequest setSubwalletGuid(String subwalletGuid) {
        this.subwalletGuid = subwalletGuid;
        return this;
    }

    public BankTransferRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public BankTransferRequest setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
        return this;
    }

    public BankTransferRequest setBeneficiaryIFSC(String beneficiaryIFSC) {
        this.beneficiaryIFSC = beneficiaryIFSC;
        return this;
    }

    public BankTransferRequest setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public BankTransferRequest setDate(String date) {
        this.date = date;
        return this;
    }

    public BankTransferRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public BankTransferRequest setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public BankTransferRequest setTransferMode(String transferMode) {
        this.transferMode = transferMode;
        return this;
    }
}
