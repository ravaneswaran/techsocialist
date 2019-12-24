package com.techsocialist.utilities.barcodes.bc4j;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.techsocialist.utilities.barcodes.api.IBarcodeMaker;
import com.techsocialist.utilities.barcodes.api.IBarcodeScanner;
import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestCode39BarcodeScanner extends TestCase{
	
	private IBarcodeMaker barcodeMaker = new BC4JCode39BarcodeMaker();
	private IBarcodeScanner barcodeScanner = new Code39BarcodeScanner();
	
	
	public void testInstance(){
		Assert.assertTrue(this.barcodeScanner instanceof IBarcodeScanner);
	}
	
	public void testScan() throws IOException, NotFoundException, ChecksumException, FormatException{
		String data = String.format("%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();
		File file = this.barcodeMaker.create(data,
				directoryPath);
		
		String result = this.barcodeScanner.scan(file.getName(), directoryPath);
		
		Assert.assertEquals(data, result);
	}

}
