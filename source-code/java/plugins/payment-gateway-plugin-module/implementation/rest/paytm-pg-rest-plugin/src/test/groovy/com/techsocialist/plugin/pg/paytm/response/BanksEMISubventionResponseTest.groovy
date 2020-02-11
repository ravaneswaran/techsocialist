package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.request.paytm.innerstruct.IItem
import com.techsocialist.plugin.pg.paytm.request.innerstruct.Item
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class BanksEMISubventionResponseTest extends AbstractPaytmResponseTest {

    def "test BanksEMISubventionResponse as json string"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"

        String itemId = String.format("item-%s", new Date().getTime())
        String productId = String.format("product-%s", new Date().getTime())
        String brandId = String.format("brand-id-%s", new Date().getTime())
        String quantity = 10
        String price = "100"
        String verticalId = String.valueOf(new Date().getTime())
        String isEmiEnabled = "true"

        Item item = new Item()
        item.setId(String.valueOf(new Date().getTime()))
        item.setBrandId(String.format("brand-id-%s", new Date().getTime()))
        String categoryList = ["", ""]
        item.setCategoryList(categoryList).setQuantity(10).setEan("ean").setEmiEnabled(true).setModel("model")
        item.setVerticalId(verticalId).setProductId(String.format("product-%s", new Date().getTime()))

        IItem[] items = [item]

        when:
        String jsonString = paymentGatewayRestPlugin.banksEMISubvention(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, itemId, productId, brandId, quantity, price, verticalId, isEmiEnabled,  items)

        then:
        null != jsonString
    }

    def "test BanksEMISubventionResponse as object"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"

        String itemId = String.format("item-%s", new Date().getTime())
        String productId = String.format("product-%s", new Date().getTime())
        String brandId = String.format("brand-id-%s", new Date().getTime())
        String quantity = 10
        String price = "100"
        String verticalId = String.valueOf(new Date().getTime())
        String isEmiEnabled = "true"

        Item item = new Item()
        item.setId(String.valueOf(new Date().getTime()))
        item.setBrandId(String.format("brand-id-%s", new Date().getTime()))
        String categoryList = ["", ""]
        item.setCategoryList(categoryList).setQuantity(10).setEan("ean").setEmiEnabled(true).setModel("model")
        item.setVerticalId(verticalId).setProductId(String.format("product-%s", new Date().getTime()))

        IItem[] items = [item]

        when:
        String jsonString = paymentGatewayRestPlugin.banksEMISubvention(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, itemId, productId, brandId, quantity, price, verticalId, isEmiEnabled,  items)
        BanksEMISubventionResponse banksEMISubventionResponse = unmarshallerPlugin.unmarshall(jsonString, BanksEMISubventionResponse.class)

        then:
        null != banksEMISubventionResponse
    }

    def "test BanksEMISubventionResponse -> banksEMISubventionResponseHead"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"

        String itemId = String.format("item-%s", new Date().getTime())
        String productId = String.format("product-%s", new Date().getTime())
        String brandId = String.format("brand-id-%s", new Date().getTime())
        String quantity = 10
        String price = "100"
        String verticalId = String.valueOf(new Date().getTime())
        String isEmiEnabled = "true"

        Item item = new Item()
        item.setId(String.valueOf(new Date().getTime()))
        item.setBrandId(String.format("brand-id-%s", new Date().getTime()))
        String categoryList = ["", ""]
        item.setCategoryList(categoryList).setQuantity(10).setEan("ean").setEmiEnabled(true).setModel("model")
        item.setVerticalId(verticalId).setProductId(String.format("product-%s", new Date().getTime()))

        IItem[] items = [item]

        when:
        String jsonString = paymentGatewayRestPlugin.banksEMISubvention(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, itemId, productId, brandId, quantity, price, verticalId, isEmiEnabled,  items)
        BanksEMISubventionResponse banksEMISubventionResponse = unmarshallerPlugin.unmarshall(jsonString, BanksEMISubventionResponse.class)

        then:
        null != banksEMISubventionResponse.getBanksEMISubventionResponseHead()
    }

    def "test BanksEMISubventionResponse -> banksEMISubventionResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"

        String itemId = String.format("item-%s", new Date().getTime())
        String productId = String.format("product-%s", new Date().getTime())
        String brandId = String.format("brand-id-%s", new Date().getTime())
        String quantity = 10
        String price = "100"
        String verticalId = String.valueOf(new Date().getTime())
        String isEmiEnabled = "true"

        Item item = new Item()
        item.setId(String.valueOf(new Date().getTime()))
        item.setBrandId(String.format("brand-id-%s", new Date().getTime()))
        String categoryList = ["", ""]
        item.setCategoryList(categoryList).setQuantity(10).setEan("ean").setEmiEnabled(true).setModel("model")
        item.setVerticalId(verticalId).setProductId(String.format("product-%s", new Date().getTime()))

        IItem[] items = [item]

        when:
        String jsonString = paymentGatewayRestPlugin.banksEMISubvention(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, itemId, productId, brandId, quantity, price, verticalId, isEmiEnabled,  items)
        BanksEMISubventionResponse banksEMISubventionResponse = unmarshallerPlugin.unmarshall(jsonString, BanksEMISubventionResponse.class)

        then:
        null != banksEMISubventionResponse.getBanksEMISubventionResponseBody()
    }

}
