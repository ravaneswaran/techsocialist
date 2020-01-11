package com.techsocialist.plugin.barcode.api;

import java.awt.image.BufferedImage;

public interface IBarcodePlugin {

    public BufferedImage createImage(String data) throws Exception;

    public String scanImage(BufferedImage bufferedImage) throws Exception;
}
