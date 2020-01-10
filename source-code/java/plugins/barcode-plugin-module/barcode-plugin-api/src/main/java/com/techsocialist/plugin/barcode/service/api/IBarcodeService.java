package com.techsocialist.plugin.barcode.service.api;

import java.awt.image.BufferedImage;

public interface IBarcodeService {

    public BufferedImage createImage(String data) throws Exception;

    public String scanImage(BufferedImage bufferedImage) throws Exception;
}
