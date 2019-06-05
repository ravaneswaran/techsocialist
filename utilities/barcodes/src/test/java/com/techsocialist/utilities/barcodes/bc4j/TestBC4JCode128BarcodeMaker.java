package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.techsocialist.utilities.barcodes.api.IBarcodeMaker;
import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JCode128BarcodeMaker extends TestCase {

	private BC4JCode128BarcodeMaker code128BarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.code128BarCodeImageCreator = new BC4JCode128BarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.code128BarCodeImageCreator = null;
	}

	public void testInstance() {
		Assert.assertTrue(this.code128BarCodeImageCreator instanceof IBarcodeMaker);
	}

	public void testCreate() throws IOException {
		String data = String.format("HELLO-WORLD-%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.code128BarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
