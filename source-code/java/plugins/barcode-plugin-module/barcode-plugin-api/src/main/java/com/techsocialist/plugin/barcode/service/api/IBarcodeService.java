package com.techsocialist.plugin.barcode.service.api;

import java.awt.image.BufferedImage;
import java.io.File;

public interface IBarcodeService {

    public BufferedImage createImage(String data) throws Exception;

    public String scanImage(File file) throws Exception;
}
