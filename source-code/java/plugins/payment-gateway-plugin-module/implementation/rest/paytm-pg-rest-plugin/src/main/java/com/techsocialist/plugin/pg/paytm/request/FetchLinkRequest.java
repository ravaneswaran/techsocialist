package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class FetchLinkRequest extends AbstractPaytmLinkRequest{

    private String linkDescription;

    private String pageNo;

    private String pageSize;

    private String customerName;

    private String customerPhone;

    private String customerEmail;

    private String paymentStatus;

    public FetchLinkRequest setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
        return this;
    }

    public FetchLinkRequest setPageNo(String pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public FetchLinkRequest setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public FetchLinkRequest setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public FetchLinkRequest setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public FetchLinkRequest setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public FetchLinkRequest setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/link/fetch";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/link/fetch";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        head.put("tokenType", this.tokenType);
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());

        return body;
    }
}
