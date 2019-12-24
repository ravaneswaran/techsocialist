package com.techsocialist.utilities.qrcodes.api;

import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;

public interface IQRCodeMaker {

	public File create(String data, String fileName, String directoryPath,
                       String charset, int imageWidth, int imageHeight)
			throws WriterException, IOException;

}
