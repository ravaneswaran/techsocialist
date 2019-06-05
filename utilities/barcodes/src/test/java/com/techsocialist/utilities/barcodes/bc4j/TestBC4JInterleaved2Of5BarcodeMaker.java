package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JInterleaved2Of5BarcodeMaker extends TestCase {

	private BC4JInterleaved2Of5BarcodeMaker interleaved2Of5BarCodeCreator;

	@Override
	protected void setUp() throws Exception {
		this.interleaved2Of5BarCodeCreator = new BC4JInterleaved2Of5BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.interleaved2Of5BarCodeCreator = null;
	}

	public void testCreate() throws IOException {
		String data = "12345678901234567890";
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.interleaved2Of5BarCodeCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}
}
