package com.techsocialist.utilities.qrcodes.api;

import com.google.zxing.NotFoundException;

import java.io.IOException;

public interface IQRCodeScanner {
	
	public String scan(String fileName, String directoryPath)
			throws IOException, NotFoundException;

}
