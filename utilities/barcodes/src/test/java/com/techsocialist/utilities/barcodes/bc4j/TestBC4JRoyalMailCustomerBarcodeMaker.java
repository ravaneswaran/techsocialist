package com.techsocialist.utilities.barcodes.bc4j;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestBC4JRoyalMailCustomerBarcodeMaker extends TestCase {

	private BC4JRoyalMailCustomerBarcodeMaker royalMailCustomerBarcodeImageCreator;

	@Override
	protected void setUp() throws Exception {
		this.royalMailCustomerBarcodeImageCreator = new BC4JRoyalMailCustomerBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.royalMailCustomerBarcodeImageCreator = null;
	}

	public void testCreate() throws IOException {
		// the data should be 12 chars long
		String data = String.format("%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.royalMailCustomerBarcodeImageCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
