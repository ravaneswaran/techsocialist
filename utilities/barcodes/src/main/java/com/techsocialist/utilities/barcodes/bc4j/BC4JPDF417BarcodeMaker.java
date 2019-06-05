package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JPDF417BarcodeMaker extends AbstractBC4JBarcodeMaker {

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		return this.getFile(new PDF417Bean(), data, directoryPath);
	}

}
