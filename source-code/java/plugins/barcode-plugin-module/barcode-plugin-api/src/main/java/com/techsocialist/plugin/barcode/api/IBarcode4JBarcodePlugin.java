package com.techsocialist.plugin.barcode.api;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IBarcode4JBarcodePlugin {

    public BufferedImage createCodabarImage(String data) throws IOException;

    public BufferedImage createCode128Image(String data) throws IOException;

    public BufferedImage createCode39Image(String data) throws IOException;

    public BufferedImage createDataMatrixRectangleImage(String data) throws IOException;

    public BufferedImage createDataMatrixSquareImage(String data) throws IOException;

    public BufferedImage createEAN13Image(String data) throws IOException;

    public BufferedImage createEAN8Image(String data) throws IOException;

    public BufferedImage createITF14Image(String data) throws IOException;

    public BufferedImage createInterleaved2Of5Image(String data) throws IOException;

    public BufferedImage createPDF417Image(String data) throws IOException;

    public BufferedImage createPOSTNETImage(String data) throws IOException;

    public BufferedImage createRoyalMailCBCImage(String data) throws IOException;

    public BufferedImage createUPCAImage(String data) throws IOException;

    public BufferedImage createUPCEImage(String data) throws IOException;

    public BufferedImage createUSPSIntelligentMailImage(String data) throws IOException;

}
