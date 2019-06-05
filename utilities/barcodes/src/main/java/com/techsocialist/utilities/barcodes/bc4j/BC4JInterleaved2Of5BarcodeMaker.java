package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JInterleaved2Of5BarcodeMaker extends AbstractBC4JBarcodeMaker {

	@Override
	public File create(String data, String directoryPath) throws IOException {
		return this.getFile(new Interleaved2Of5Bean(), data, directoryPath);
	}

}
