package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import org.krysalis.barcode4j.impl.code39.Code39Bean;

public class BC4JCode39BarcodeMaker extends AbstractBC4JBarcodeMaker {

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		Code39Bean code39Bean = new Code39Bean();
		code39Bean.setWideFactor(3);
		return this.getFile(code39Bean, data, directoryPath);
	}

}
