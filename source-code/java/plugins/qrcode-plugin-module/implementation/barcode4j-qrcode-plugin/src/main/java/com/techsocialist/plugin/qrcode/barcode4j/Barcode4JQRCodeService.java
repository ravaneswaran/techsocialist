package com.techsocialist.plugin.qrcode.barcode4j;

import com.techsocialist.plugin.qrcode.service.impl.AbstractQRCodeService;

import java.awt.image.BufferedImage;

public class Barcode4JQRCodeService extends AbstractQRCodeService {

    @Override
    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception {
        return null;
    }

    @Override
    public String scanImage(BufferedImage bufferedImage) throws Exception {
        return null;
    }
}
