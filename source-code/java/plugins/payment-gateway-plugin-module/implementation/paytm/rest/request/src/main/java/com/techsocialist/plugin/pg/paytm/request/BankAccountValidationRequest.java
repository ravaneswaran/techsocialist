package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class BankAccountValidationRequest extends AbstractPaytmRequest {

    private String subwalletGuid;

    private String beneficiaryAccount;

    private String beneficiaryIFSC;

    private String beneficiaryVPA;

    private String callbackUrl;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://staging-dashboard.paytm.com/bpay/api/%s/beneficiary/validate";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://dashboard.paytm.com/bpay/api/%s/beneficiary/validate";
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
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("orderId",this.getOrderId());
        jsonObject.put("subwalletGuid",this.subwalletGuid);
        jsonObject.put("beneficiaryAccount",this.beneficiaryAccount);
        jsonObject.put("beneficiaryIFSC",this.beneficiaryIFSC);

        return jsonObject;
    }

    public BankAccountValidationRequest setSubwalletGuid(String subwalletGuid) {
        this.subwalletGuid = subwalletGuid;
        return this;
    }

    public BankAccountValidationRequest setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
        return this;
    }

    public BankAccountValidationRequest setBeneficiaryIFSC(String beneficiaryIFSC) {
        this.beneficiaryIFSC = beneficiaryIFSC;
        return this;
    }

    public BankAccountValidationRequest setBeneficiaryVPA(String beneficiaryVPA) {
        this.beneficiaryVPA = beneficiaryVPA;
        return this;
    }

    public BankAccountValidationRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }
}
