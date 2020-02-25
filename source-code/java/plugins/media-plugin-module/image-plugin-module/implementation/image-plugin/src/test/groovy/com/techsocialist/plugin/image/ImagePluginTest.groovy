package com.techsocialist.plugin.image

import com.techsocialist.plugin.image.api.IImagePlugin
import com.techsocialist.plugin.image.api.ImageType
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
        URL url = this.getClass().getResource("/images/server-image.png")
        BufferedImage bufferedImage = imagePlugin.setImage(url).createThumnail()

        then:
        null != bufferedImage
    }

    def "test ImagePlugin -> saveImage"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/server-image.png")
        BufferedImage bufferedImage = imagePlugin.setImage(url).createThumnail()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> clearBackground"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/client-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).clearBackground()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> getImageResolution"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/client-image.jpg")
        String resolution = imagePlugin.setImage(url).getImageResolution()

        then:
        null != resolution
    }
}
