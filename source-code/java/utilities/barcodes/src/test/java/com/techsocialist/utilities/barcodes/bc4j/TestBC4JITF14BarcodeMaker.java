package com.techsocialist.utilities.barcodes.bc4j;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

public class TestBC4JITF14BarcodeMaker extends TestCase {

	private BC4JITF14BarcodeMaker itf14BarCodeCreator;

	@Override
	protected void setUp() throws Exception {
		this.itf14BarCodeCreator = new BC4JITF14BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.itf14BarCodeCreator = null;
	}

	public void testCreate() throws IOException {
		String data = "1234567890123";
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.itf14BarCodeCreator.create(data, directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
