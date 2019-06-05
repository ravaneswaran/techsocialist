package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.techsocialist.utilities.barcodes.api.IBarcodeMaker;
import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JCode39BarcodeMaker extends TestCase {

	private BC4JCode39BarcodeMaker code39BarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.code39BarCodeImageCreator = new BC4JCode39BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.code39BarCodeImageCreator = null;
	}

	public void testInstance() {
		Assert.assertTrue(this.code39BarCodeImageCreator instanceof IBarcodeMaker);
	}

	public void testCreate() throws IOException {
		String data = String.format("HELLO-WORLD-%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.code39BarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
