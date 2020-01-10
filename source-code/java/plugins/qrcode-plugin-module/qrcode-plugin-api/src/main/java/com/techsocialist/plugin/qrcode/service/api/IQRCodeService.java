package com.techsocialist.plugin.qrcode.service.api;

import java.awt.image.BufferedImage;

public interface IQRCodeService {

    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception;

    public String scanImage(BufferedImage bufferedImage) throws Exception;

}
