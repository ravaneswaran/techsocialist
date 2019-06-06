package com.techsocialist.utilities.barcodes.bc4j;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestBC4JUPCABarcodeMaker extends TestCase {

	private BC4JUPCABarcodeMaker upcaBarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.upcaBarCodeImageCreator = new BC4JUPCABarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.upcaBarCodeImageCreator = null;
	}

	public void testCreate() throws IOException {
		// the data should be 12 chars long
		String data = String.format("%s", new Date().getTime())
				.substring(0, 11);
		String directoryPath = Temporary.getTempDirectoryPath();
		File imageFile = this.upcaBarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
