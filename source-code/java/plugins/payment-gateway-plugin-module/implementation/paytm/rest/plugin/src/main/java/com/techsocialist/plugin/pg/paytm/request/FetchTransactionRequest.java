package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class FetchTransactionRequest extends AbstractPaytmRequest {

    private String timestamp;

    private String tokenType;

    private String linkId;

    private String pageNo;

    private String pageSize;

    private String searchStartDate;

    private String searchEndDate;

    public FetchTransactionRequest setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public FetchTransactionRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public FetchTransactionRequest setLinkId(String linkId) {
        this.linkId = linkId;
        return this;
    }

    public FetchTransactionRequest setPageNo(String pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public FetchTransactionRequest setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public FetchTransactionRequest setSearchStartDate(String searchStartDate) {
        this.searchStartDate = searchStartDate;
        return this;
    }

    public FetchTransactionRequest setSearchEndDate(String searchEndDate) {
        this.searchEndDate = searchEndDate;
        return this;
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/link/fetchTransaction";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/link/fetchTransaction";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {
        return null;
    }

    @Override
    public JSONObject dataBody() {
        return null;
    }
}
