package com.techsocialist.plugin.barcode

import spock.lang.Specification

class Barcode4JPluginTest extends Specification {

    def "test creating a simple barcode image"(){
        setup:
            def barcodeService = new Barcode4JBarcodeService()
            def data = String.format("%s", new Date().getTime()).substring(0, 12)
        when:
            def result = barcodeService.createImage(data)
        then:
            null != result
    }

    def "test creating a codabar barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime())
        when:
        def result = barcodeService.createCodabarImage(data)
        then:
        null != result
    }

    def "test creating a code 128 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("HELLO-WORLD-%s", new Date().getTime())
        when:
        def result = barcodeService.createCode128Image(data)
        then:
        null != result
    }

    def "test creating a code 39 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("HELLO-WORLD-%s", new Date().getTime())
        when:
        def result = barcodeService.createCode39Image(data)
        then:
        null != result
    }

    def "test creating a data matrix rectangle barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("HELLO-WORLD-%s", new Date().getTime())
        when:
        def result = barcodeService.createDataMatrixRectangleImage(data)
        then:
        null != result
    }

    def "test creating a data matrix square barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("HELLO-WORLD-%s", new Date().getTime())
        when:
        def result = barcodeService.createDataMatrixSquareImage(data)
        then:
        null != result
    }

    def "test creating a EAN 13 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime()).substring(0, 12)
        when:
        def result = barcodeService.createEAN13Image(data)
        then:
        null != result
    }

    def "test creating a EAN 8 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime()).substring(0, 7)
        when:
        def result = barcodeService.createEAN8Image(data)
        then:
        null != result
    }

    def "test creating a ITF14 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = "1234567890123"
        when:
        def result = barcodeService.createITF14Image(data)
        then:
        null != result
    }

    def "test creating a Interleaved2Of5 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = "12345678901234567890"
        when:
        def result = barcodeService.createInterleaved2Of5Image(data)
        then:
        null != result
    }

    def "test creating a PDF417 barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = "helloworld"
        when:
        def result = barcodeService.createPDF417Image(data)
        then:
        null != result
    }

    def "test creating a POSTNET barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime())
        when:
        def result = barcodeService.createPOSTNETImage(data)
        then:
        null != result
    }

    def "test creating a RoyalMailCBC barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime())
        when:
        def result = barcodeService.createRoyalMailCBCImage(data)
        then:
        null != result
    }

    def "test creating a UPCA barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime()).substring(0, 11)
        when:
        def result = barcodeService.createUPCAImage(data)
        then:
        null != result
    }

    def "test creating a UPCE barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime()).substring(0, 7)
        when:
        def result = barcodeService.createUPCEImage(data)
        then:
        null != result
    }

    def "test creating a USPS intelligent mail barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = "12345678901234567890"
        when:
        def result = barcodeService.createUSPSIntelligentMailImage(data)
        then:
        null != result
    }

    def "test scanning a barcode image"(){
        setup:
        def barcodeService = new Barcode4JBarcodeService()
        def data = String.format("%s", new Date().getTime()).substring(0, 12)
        def barcodeImage = barcodeService.createImage(data)
        when:
        def result = barcodeService.scanImage(barcodeImage)
        then:
        null == result
    }

}
