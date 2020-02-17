package com.techsocialist.plugin.pg.paytm.request.innerstruct

import spock.lang.Specification

class ItemTest extends Specification{

    def "test Item"(){

        when:
        Item item = new Item()
        item.setId(String.valueOf(new Date().getTime()))
        item.setBrandId(String.format("brand-id-%s", new Date().getTime()))
        String categoryList = ["", ""]
        item.setCategoryList(categoryList).setQuantity(10).setEan("ean").setEmiEnabled(true).setModel("model")
        item.setVerticalId(String.valueOf(new Date().getTime())).setProductId(String.format("product-%s", new Date().getTime()))
        item.setPrice(1000.00)

        then:
        (null != item.getId() && null != item.getBrandId() && null != item.getCategoryList() && null != item.getQuantity()
        && null != item.getEan() && true == item.isEmiEnabled() && null != item.getModel() && null != item.getVerticalId()
        && null != item.getProductId() && 1000.00 == item.getPrice())
    }
}
