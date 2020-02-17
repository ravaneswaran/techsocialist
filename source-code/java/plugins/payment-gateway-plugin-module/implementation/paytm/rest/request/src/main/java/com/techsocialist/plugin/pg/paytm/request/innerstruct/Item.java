package com.techsocialist.plugin.pg.paytm.request.innerstruct;

import com.techsocialist.plugin.pg.api.request.paytm.innerstruct.IItem;

public class Item implements IItem {

    private String id;

    private String productId;

    private String brandId;

    private String[] categoryList;

    private String model;

    private String ean;

    private double price;

    private int quantity;

    private String verticalId;

    private boolean isEmiEnabled;

    public IItem setId(String id) {
        this.id = id;
        return this;
    }

    public IItem setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public IItem setBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }

    public IItem setCategoryList(String[] categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public IItem setModel(String model) {
        this.model = model;
        return this;
    }

    public IItem setEan(String ean) {
        this.ean = ean;
        return this;
    }

    public IItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public IItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public IItem setVerticalId(String verticalId) {
        this.verticalId = verticalId;
        return this;
    }

    public IItem setEmiEnabled(boolean emiEnabled) {
        isEmiEnabled = emiEnabled;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getBrandId() {
        return brandId;
    }

    public String[] getCategoryList() {
        return categoryList;
    }

    public String getModel() {
        return model;
    }

    public String getEan() {
        return ean;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getVerticalId() {
        return verticalId;
    }

    public boolean isEmiEnabled() {
        return isEmiEnabled;
    }
}
