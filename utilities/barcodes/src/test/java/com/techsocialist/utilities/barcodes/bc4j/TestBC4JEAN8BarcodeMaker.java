package com.techsocialist.utilities.barcodes.bc4j;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestBC4JEAN8BarcodeMaker extends TestCase {

	private BC4JEAN8BarcodeMaker ean8BarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.ean8BarCodeImageCreator = new BC4JEAN8BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.ean8BarCodeImageCreator = null;
	}

	public void testCreate() throws IOException {
		// the data should be 8 chars long
		String data = String.format("%s", new Date().getTime()).substring(0, 7);
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.ean8BarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
