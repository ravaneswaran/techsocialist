package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.techsocialist.plugin.pg.api.request.paytm.innerstruct.IItem;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BanksEMISubventionRequest extends AbstractPaytmRequest {

    private String tokenType;

    private String token;

    private String requestId;

    private String itemId;

    private String brandId;

    private String productId;

    private String quantity;

    private String price;

    private String verticalId;

    private String isEmiEnabled;

    private IItem[] items;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/theia/api/%s/emiSubvention/banks?mid=%s";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/theia/api/%s/emiSubvention/banks?mid=%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion(), this.getMerchantId());
    }

    @Override
    public JSONObject dataHead() throws Exception {
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());

        JSONObject head = new JSONObject();

        head.put("requestId", this.requestId);
        head.put("tokenType", this.tokenType);
        head.put("token", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());

        JSONObject item = new JSONObject();
        item.put("id", this.itemId);
        item.put("productId", this.productId);
        item.put("brandId", this.brandId);

        List<String> categories = new ArrayList<>();
        categories.add("PRODUCT_CATEGORIES");
        item.put("categoryList", categories);

        item.put("quantity", this.quantity);
        item.put("price", this.price);
        item.put("verticalId", this.verticalId);
        item.put("isEmiEnabled", this.isEmiEnabled);

        JSONObject[] items = {item};

        body.put("items", items);

        return body;
    }

    public BanksEMISubventionRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public BanksEMISubventionRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public BanksEMISubventionRequest setItems(IItem[] items) {
        this.items = items;
        return this;
    }

    public BanksEMISubventionRequest setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public BanksEMISubventionRequest setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public BanksEMISubventionRequest setBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }

    public BanksEMISubventionRequest setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public BanksEMISubventionRequest setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public BanksEMISubventionRequest setPrice(String price) {
        this.price = price;
        return this;
    }

    public BanksEMISubventionRequest setVerticalId(String verticalId) {
        this.verticalId = verticalId;
        return this;
    }

    public BanksEMISubventionRequest setIsEmiEnabled(String isEmiEnabled) {
        this.isEmiEnabled = isEmiEnabled;
        return this;
    }
}
