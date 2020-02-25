package com.techsocialist.plugin.image

import com.techsocialist.plugin.image.api.IImagePlugin
import spock.lang.Specification

import java.awt.image.BufferedImage

class ImagePluginTest extends Specification{

    def "test ImagePlugin instance"(){

        when:
        IImagePlugin imagePlugin = new ImagePlugin()

        then:
        imagePlugin instanceof IImagePlugin

    }

    def "test ImagePlugin -> createThumbnail"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/sample-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setFile(url).createThumnail()

        then:
        null != bufferedImage
    }

    def "test ImagePlugin -> saveImage"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/sample-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setFile(url).createThumnail()
        File imageFile = imagePlugin.saveImage(bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> clearBackground"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/sample-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setFile(url).clearBackground()
        File imageFile = imagePlugin.saveImage(bufferedImage)

        then:
        true == imageFile.exists()
    }
}
