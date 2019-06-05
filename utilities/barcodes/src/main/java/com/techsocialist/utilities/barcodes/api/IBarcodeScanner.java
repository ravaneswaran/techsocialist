package com.techsocialist.utilities.barcodes.api;

import java.io.IOException;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

public interface IBarcodeScanner {

	public String scan(String fileName, String directoryPath)
			throws IOException, NotFoundException, ChecksumException,
			FormatException;

}
