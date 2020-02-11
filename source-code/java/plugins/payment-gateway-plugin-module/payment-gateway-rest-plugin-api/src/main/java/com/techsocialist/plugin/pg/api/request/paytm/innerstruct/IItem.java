package com.techsocialist.plugin.pg.api.request.paytm.innerstruct;

public interface IItem {

    public IItem setId(String id);

    public IItem setProductId(String productId);

    public IItem setBrandId(String brandId);

    public IItem setCategoryList(String[] categoryList);

    public IItem setModel(String model);

    public IItem setEan(String ean);

    public IItem setPrice(double price);

    public IItem setQuantity(int quantity);

    public IItem setVerticalId(String verticalId);

    public IItem setEmiEnabled(boolean emiEnabled);

    public String getId();

    public String getProductId();

    public String getBrandId();

    public String[] getCategoryList();

    public String getModel();

    public String getEan();

    public double getPrice();

    public int getQuantity();

    public String getVerticalId();

    public boolean isEmiEnabled();

}
