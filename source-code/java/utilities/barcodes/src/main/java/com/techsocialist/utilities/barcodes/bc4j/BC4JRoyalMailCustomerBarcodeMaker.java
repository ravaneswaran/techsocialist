package com.techsocialist.utilities.barcodes.bc4j;

import org.krysalis.barcode4j.impl.fourstate.RoyalMailCBCBean;

import java.io.File;
import java.io.IOException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JRoyalMailCustomerBarcodeMaker extends AbstractBC4JBarcodeMaker{

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		return this.getFile(new RoyalMailCBCBean(), data, directoryPath);
	}

}
