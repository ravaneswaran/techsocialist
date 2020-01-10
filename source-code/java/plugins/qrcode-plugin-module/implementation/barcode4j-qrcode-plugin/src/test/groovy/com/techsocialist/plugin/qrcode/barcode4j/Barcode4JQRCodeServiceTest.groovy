package com.techsocialist.plugin.qrcode.barcode4j

import spock.lang.Specification

class Barcode4JQRCodeServiceTest extends Specification{

    def "test creating a qrcode image" (){
        setup:
        def qrCodeService = new Barcode4JQRCodeService()
        when:
        def result = qrCodeService.createImage("test data", "UTF-8", 100, 100)
        then:
        result != null
    }

    def "test scanning a qrcode image" (){
        setup:
        def qrCodeService = new Barcode4JQRCodeService()
        def image = qrCodeService.createImage("test data", "UTF-8", 100, 100)
        when:
        def scannedResult = qrCodeService.scanImage(image)
        then:
        null != scannedResult && "test data" == scannedResult
    }
}
