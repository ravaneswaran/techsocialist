package com.techsocialist.plugin.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.techsocialist.plugin.qrcode.impl.AbstractQRCodePlugin;

import java.awt.image.BufferedImage;

public class GoogleZxingQRCodePlugin extends AbstractQRCodePlugin {

    @Override
    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, imageWidth, imageHeight);

        return MatrixToImageWriter.toBufferedImage(matrix);
    }

    @Override
    public String scanImage(BufferedImage bufferedImage) throws Exception {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bufferedImage)));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
        return qrCodeResult.getText();
    }
}
