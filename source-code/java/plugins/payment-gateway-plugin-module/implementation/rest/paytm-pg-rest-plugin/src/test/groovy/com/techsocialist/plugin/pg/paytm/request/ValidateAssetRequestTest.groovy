package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class ValidateAssetRequestTest extends Specification {

    def "test production url construction"() {

        when:
        ValidateAssetRequest paytmRequest = new ValidateAssetRequest()
        String merchantId = "1234567890"
        String requestId = new Date().getTime()
        paytmRequest.setMerchantId(merchantId)
        paytmRequest.setRequestId(requestId);

        then:
        String.format("https://securegw.paytm.in/userAsset/token/create?mid=%s&requestId=%s", merchantId, requestId) == paytmRequest.url(true)
    }

}
