package com.techsocialist.utilities.barcodes.bc4j;

import org.krysalis.barcode4j.impl.int2of5.ITF14Bean;

import java.io.File;
import java.io.IOException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JITF14BarcodeMaker extends AbstractBC4JBarcodeMaker {

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		ITF14Bean itf14Bean = new ITF14Bean();
		return this.getFile(itf14Bean, data, directoryPath);
	}

}