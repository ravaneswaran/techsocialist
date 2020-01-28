package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class FetchInstrumentRequest extends AbstractPaytmRequest{

    private String userToken;

    private String transactionAmount;

    public FetchInstrumentRequest setUserToken(String userToken) {
        this.userToken = userToken;
        return this;
    }

    public FetchInstrumentRequest setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/paymentservices/fetch/instrument";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/paymentservices/fetch/instrument";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {
        JSONObject head = new JSONObject();

        head.put("clientId",this.getClientId());
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), dataBody().toString());
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("userToken", this.userToken);
        body.put("mid", this.getMerchantId());

        return body;
    }
}
