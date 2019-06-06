package com.techsocialist.utilities.qrcodes.api;

import java.io.IOException;

import com.google.zxing.NotFoundException;

public interface IQRCodeScanner {
	
	public String scan(String fileName, String directoryPath)
			throws IOException, NotFoundException;

}
