package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class ValidateAssetRequest extends AbstractPaytmRequest {

    private String requestId;

    private String customerAccountNumber;

    private String bankIfscCode;

    private String customerFirstName;

    private String customerLastName;

    private String customerMobileNumber;

    private String vpa;

    public ValidateAssetRequest setVpa(String vpa) {
        this.vpa = vpa;
        return this;
    }

    public ValidateAssetRequest setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public ValidateAssetRequest setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
        return this;
    }

    public ValidateAssetRequest setBankIfscCode(String bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
        return this;
    }

    public ValidateAssetRequest setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
        return this;
    }

    public ValidateAssetRequest setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
        return this;
    }

    public ValidateAssetRequest setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
        return this;
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/userAsset/token/create?mid=%s&requestId=%s";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/userAsset/token/create?mid=%s&requestId=%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production),this.getMerchantId(), this.requestId);
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());

        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("requestId", this.requestId);
        body.put("accountNumber", this.customerAccountNumber);
        body.put("ifscCode", this.bankIfscCode);

        JSONObject customerName = new JSONObject();
        customerName.put("firstName", this.customerFirstName);
        customerName.put("lastName", this.customerLastName);

        body.put("name", customerName);
        body.put("mobileNo", this.customerMobileNumber);

        return body;
    }
}
