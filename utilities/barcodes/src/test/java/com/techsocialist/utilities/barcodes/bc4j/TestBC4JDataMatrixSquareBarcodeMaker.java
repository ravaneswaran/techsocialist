package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JDataMatrixSquareBarcodeMaker extends TestCase {

	private BC4JDataMatrixSquareBarcodeMaker dataMatrixSquareBarCodeCreator;

	@Override
	protected void setUp() throws Exception {
		this.dataMatrixSquareBarCodeCreator = new BC4JDataMatrixSquareBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.dataMatrixSquareBarCodeCreator = null;
	}

	public void testCreate() throws IOException {
		String data = "helloworld";
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.dataMatrixSquareBarCodeCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
