package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JUPCEBarcodeMaker extends TestCase {

	private BC4JUPCEBarcodeMaker upceBarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.upceBarCodeImageCreator = new BC4JUPCEBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.upceBarCodeImageCreator = null;
	}

	public void testCreate() throws IOException {
		// the data should be 8 chars long
		String data = String.format("%s", new Date().getTime()).substring(0, 7);
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.upceBarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
