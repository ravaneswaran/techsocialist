package com.techsocialist.plugin.qrcode

import spock.lang.Specification

class GoogleZxingQRCodePluginTest extends Specification {

    def "test creating a qrcode image" (){
        setup:
            def qrCodeService = new GoogleZxingQRCodePlugin()
        when:
            def result = qrCodeService.createImage("test data", "UTF-8", 100, 100)
        then:
            result != null
    }

    def "test scanning a qrcode image" (){
        setup:
            def qrCodeService = new GoogleZxingQRCodePlugin()
            def image = qrCodeService.createImage("test data", "UTF-8", 100, 100)
        when:
            def scannedResult = qrCodeService.scanImage(image)
        then:
            null != scannedResult && "test data" == scannedResult
    }

}
