package com.techsocialist.plugin.pg.paytm.request;

import com.techsocialist.plugin.pg.api.request.paytm.innerstruct.IItem;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TenuresEMISubventionRequest extends AbstractPaytmRequest {

    private String bankCode;

    private String cardType;

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
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/theia/api/%s/emiSubvention/tenures?mid=%s";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/theia/api/%s/emiSubvention/tenures?mid=%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion(), this.getMerchantId());
    }

    @Override
    public JSONObject dataHead() throws Exception {
        return null;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());

        JSONObject filters = new JSONObject();
        filters.put("bankCode", "BANK_CODE");
        filters.put("cardType", "CARD_TYPE");

        body.put("filters", filters);

        JSONObject item = new JSONObject();

        item.put("id", "ITEM_ID");
        item.put("productId", "PRODUCT_ID");
        item.put("brandId", "BRAND_ID");

        List<String> categories = new ArrayList<>();
        categories.add("PRODUCT_CATEGORIES");
        item.put("categoryList", categories);
        item.put("quantity", "PRODUCT_QUANTITY");
        item.put("price", "PRODUCT_PRICE");
        item.put("verticalId", "PAYTM_EMI");
        item.put("isEmiEnabled", true);

        JSONObject[] items = {item};

        body.put("items", items);

        return body;
    }

    public TenuresEMISubventionRequest setBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    public TenuresEMISubventionRequest setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public TenuresEMISubventionRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public TenuresEMISubventionRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public TenuresEMISubventionRequest setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public TenuresEMISubventionRequest setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public TenuresEMISubventionRequest setBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }

    public TenuresEMISubventionRequest setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public TenuresEMISubventionRequest setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public TenuresEMISubventionRequest setPrice(String price) {
        this.price = price;
        return this;
    }

    public TenuresEMISubventionRequest setVerticalId(String verticalId) {
        this.verticalId = verticalId;
        return this;
    }

    public TenuresEMISubventionRequest setIsEmiEnabled(String isEmiEnabled) {
        this.isEmiEnabled = isEmiEnabled;
        return this;
    }

    public TenuresEMISubventionRequest setItems(IItem[] items) {
        this.items = items;
        return this;
    }
}
