package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.techsocialist.utilities.temp.Temporary;
import org.junit.Assert;

import junit.framework.TestCase;

public class TestBC4JEAN13BarcodeMaker extends TestCase {

	private BC4JEAN13BarcodeMaker ean13BarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.ean13BarCodeImageCreator = new BC4JEAN13BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.ean13BarCodeImageCreator = null;
	}

	public void testCreate() throws IOException {
		// data should have the length of 13
		String data = String.format("%s", new Date().getTime())
				.substring(0, 12);
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.ean13BarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
