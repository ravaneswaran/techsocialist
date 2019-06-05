package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import org.krysalis.barcode4j.impl.upcean.EAN8Bean;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JEAN8BarcodeMaker extends AbstractBC4JBarcodeMaker{

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		return this.getFile(new EAN8Bean(), data, directoryPath);
	}

}
