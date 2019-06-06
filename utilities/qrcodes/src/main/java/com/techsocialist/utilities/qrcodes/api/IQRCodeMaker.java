package com.techsocialist.utilities.qrcodes.api;

import java.io.File;
import java.io.IOException;

import com.google.zxing.WriterException;

public interface IQRCodeMaker {

	public File create(String data, String fileName, String directoryPath,
                       String charset, int imageWidth, int imageHeight)
			throws WriterException, IOException;

}
