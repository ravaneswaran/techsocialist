package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JPOSTNETBarcodeMaker extends TestCase {

	private BC4JPOSTNETBarcodeMaker postNETBarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.postNETBarCodeImageCreator = new BC4JPOSTNETBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.postNETBarCodeImageCreator = null;
	}

	public void testCreate() throws IOException {
		String data = String.format("%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.postNETBarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}
}
