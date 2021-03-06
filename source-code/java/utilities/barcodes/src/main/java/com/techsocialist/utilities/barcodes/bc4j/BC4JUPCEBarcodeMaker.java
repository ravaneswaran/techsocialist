package com.techsocialist.utilities.barcodes.bc4j;

import org.krysalis.barcode4j.impl.upcean.UPCEBean;

import java.io.File;
import java.io.IOException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JUPCEBarcodeMaker extends AbstractBC4JBarcodeMaker{

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		return this.getFile(new UPCEBean(), data, directoryPath);
	}

}
