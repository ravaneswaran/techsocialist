package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import org.krysalis.barcode4j.impl.code128.Code128Bean;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JCode128BarcodeMaker extends AbstractBC4JBarcodeMaker {

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		return this.getFile(new Code128Bean(), data, directoryPath);
	}

}
