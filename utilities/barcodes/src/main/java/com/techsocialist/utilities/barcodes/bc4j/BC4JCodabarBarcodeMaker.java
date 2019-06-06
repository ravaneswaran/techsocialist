package com.techsocialist.utilities.barcodes.bc4j;

import org.krysalis.barcode4j.impl.codabar.CodabarBean;

import java.io.File;
import java.io.IOException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JCodabarBarcodeMaker extends AbstractBC4JBarcodeMaker {

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		return this.getFile(new CodabarBean(), data, directoryPath);
	}

}
