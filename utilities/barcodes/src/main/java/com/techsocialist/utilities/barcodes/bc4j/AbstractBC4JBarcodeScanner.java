package com.techsocialist.utilities.barcodes.bc4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.techsocialist.utilities.barcodes.api.IBarcodeScanner;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public abstract class AbstractBC4JBarcodeScanner implements IBarcodeScanner {

	@Override
	public String scan(String fileName, String directoryPath)
			throws IOException, NotFoundException, ChecksumException,
			FormatException {
		File file = new File(directoryPath + "/" + fileName);
		InputStream barCodeInputStream = new FileInputStream(file);
		BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);
		LuminanceSource source = new BufferedImageLuminanceSource(
				barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result = new MultiFormatReader().decode(bitmap);
		return result.getText();
	}
}
