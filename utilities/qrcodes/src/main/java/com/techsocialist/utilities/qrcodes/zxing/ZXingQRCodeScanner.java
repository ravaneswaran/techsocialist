package com.techsocialist.utilities.qrcodes.zxing;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.techsocialist.utilities.qrcodes.api.IQRCodeScanner;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class ZXingQRCodeScanner implements IQRCodeScanner {

	@Override
	public String scan(String fileName, String directoryPath)
			throws IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(
						ImageIO.read(new FileInputStream(directoryPath
								+ "/" + fileName)))));
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
		return qrCodeResult.getText();
	}

}
