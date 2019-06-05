package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JPDF417BarcodeMaker extends TestCase {

	private BC4JPDF417BarcodeMaker pdf417BarCodeCreator;

	@Override
	protected void setUp() throws Exception {
		this.pdf417BarCodeCreator = new BC4JPDF417BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.pdf417BarCodeCreator = null;
	}

	public void testCreate() throws IOException {
		String data = "helloworld";
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.pdf417BarCodeCreator.create(data, directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
