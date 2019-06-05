package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JDataMatrixRectangleBarcodeMaker extends TestCase {

	private BC4JDataMatrixRectangleBarcodeMaker dataMatrixRectangleBarCodeCreator;

	@Override
	protected void setUp() throws Exception {
		this.dataMatrixRectangleBarCodeCreator = new BC4JDataMatrixRectangleBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.dataMatrixRectangleBarCodeCreator = null;
	}

	public void testCreate() throws IOException {
		String data = "helloworld";
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.dataMatrixRectangleBarCodeCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
