package com.techsocialist.utilities.barcodes.bc4j;

import com.techsocialist.utilities.barcodes.api.IBarcodeMaker;
import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestBC4JCodabarBarcodeMaker extends TestCase {

	private BC4JCodabarBarcodeMaker codabarBarCodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.codabarBarCodeImageCreator = new BC4JCodabarBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.codabarBarCodeImageCreator = null;
	}

	public void testInstance() {
		Assert.assertTrue(this.codabarBarCodeImageCreator instanceof IBarcodeMaker);
	}

	public void testCreate() throws IOException {
		String data = String.format("%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.codabarBarCodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
