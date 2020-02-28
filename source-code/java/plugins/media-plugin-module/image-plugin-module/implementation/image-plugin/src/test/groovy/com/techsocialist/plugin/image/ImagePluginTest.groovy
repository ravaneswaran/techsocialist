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
        BufferedImage bufferedImage = imagePlugin.setImage(url).createThumbnail()

        then:
        null != bufferedImage
    }

    def "test ImagePlugin -> saveImage"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/server-image.png")
        BufferedImage bufferedImage = imagePlugin.setImage(url).createThumbnail()
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

    def "test ImagePlugin -> applyGreyScalaFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyGreyScaleFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyNegativeFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyNegativeFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applySepiaFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applySepiaFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyRedFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyRedFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyGreenFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyGreenFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyBlueFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyBlueFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applySelfieFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applySelfieFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyWateMark"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyWaterMark("Tech Socialist")
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyBlurFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyBlurFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applySharpBlurFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applySharpBlurFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyEmbossFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyEmbossFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyPixelateFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyPixelateFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }

    def "test ImagePlugin -> applyGaussianBlurFilter"(){

        setup:
        IImagePlugin imagePlugin = new ImagePlugin()

        when:
        URL url = this.getClass().getResource("/images/color-image.jpg")
        BufferedImage bufferedImage = imagePlugin.setImage(url).applyGaussianBlurFilter()
        File imageFile = imagePlugin.saveImage(ImageType.THUMBNAIL, bufferedImage)

        then:
        true == imageFile.exists()
    }
}
