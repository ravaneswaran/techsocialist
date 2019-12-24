package com.techsocialist.utilities.barcodes.api;

import java.io.File;
import java.io.IOException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public interface IBarcodeMaker {
	
	/**
	 * @param data
	 * @param directoryPath
	 * @return
	 * @throws IOException
	 */
	public File create(String data, String directoryPath) throws IOException;

}