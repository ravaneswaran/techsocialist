package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;

public class TestBC4JUSPSIntelligentMailBarcodeMaker extends TestCase {

	private BC4JUSPSIntelligentMailBarcodeMaker uspsIntelligentMailBarCodeCreator;

	@Override
	protected void setUp() throws Exception {
		this.uspsIntelligentMailBarCodeCreator = new BC4JUSPSIntelligentMailBarcodeMaker();
	}

	@Override
	protected void tearDown() throws Exception {
		this.uspsIntelligentMailBarCodeCreator = null;
	}

	public void testCreate() throws IOException {
		// data must be atlease 20 digits
		String data = "12345678901234567890";
		String directoryPath = Temporary.getTempDirectoryPath();

		File imageFile = this.uspsIntelligentMailBarCodeCreator.create(data,
				directoryPath);

		Assert.assertTrue(imageFile.exists());
	}

}
