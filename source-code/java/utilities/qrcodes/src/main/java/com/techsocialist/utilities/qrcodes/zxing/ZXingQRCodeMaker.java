package com.techsocialist.utilities.qrcodes.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.techsocialist.utilities.qrcodes.api.IQRCodeMaker;

import java.io.File;
import java.io.IOException;

public class ZXingQRCodeMaker implements IQRCodeMaker {

	@Override
	public File create(String data, String fileName, String directoryPath,
			String charset, int imageWidth, int imageHeight)
			throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(
				new String(data.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, imageWidth, imageHeight);
		File qrCodeImageFile = new File(directoryPath + "/" +fileName);
		MatrixToImageWriter.writeToFile(matrix,
				fileName.substring(fileName.lastIndexOf('.') + 1),
				qrCodeImageFile);
		return qrCodeImageFile;
	}

}
