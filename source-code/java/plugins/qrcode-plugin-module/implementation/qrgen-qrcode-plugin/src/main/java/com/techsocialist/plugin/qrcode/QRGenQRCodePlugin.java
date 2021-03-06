package com.techsocialist.plugin.qrcode;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class QRGenQRCodePlugin extends GoogleZxingQRCodePlugin {

    @Override
    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception {
        File file = QRCode.from(data).withCharset(charset).withSize(imageWidth, imageHeight).to(ImageType.PNG).file();
        return ImageIO.read(file);
    }

    @Override
    public String scanImage(BufferedImage bufferedImage) throws Exception {
        return super.scanImage(bufferedImage);
    }
}
