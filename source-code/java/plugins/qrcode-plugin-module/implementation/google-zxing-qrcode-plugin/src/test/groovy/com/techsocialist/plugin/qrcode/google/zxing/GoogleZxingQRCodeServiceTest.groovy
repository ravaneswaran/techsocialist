package com.techsocialist.plugin.qrcode.google.zxing

import spock.lang.Specification

class GoogleZxingQRCodeServiceTest extends Specification {

    def "test creating a qrcode image" (){
        setup:
            def qrCodeService = new GoogleZxingQRCodeService()
        when:
            def result = qrCodeService.createImage("test data", "UTF-8", 100, 100)
        then:
            result != null
    }

    def "test scanning a qrcode image" (){
        setup:
            def qrCodeService = new GoogleZxingQRCodeService()
            def image = qrCodeService.createImage("test data", "UTF-8", 100, 100)
        when:
            def scannedResult = qrCodeService.scanImage(image)
        then:
            null != scannedResult && "test data" == scannedResult
    }

}
