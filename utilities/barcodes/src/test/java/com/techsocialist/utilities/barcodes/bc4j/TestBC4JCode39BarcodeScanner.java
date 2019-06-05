package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.techsocialist.utilities.barcodes.api.IBarcodeScanner;
import com.techsocialist.utilities.temp.Temporary;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Ignore;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

@Ignore
public class TestBC4JCode39BarcodeScanner extends TestCase {
	
	private IBarcodeScanner code39BarcodeScanner;
	private BC4JCode39BarcodeMaker code39BarcodeMaker;
	
	@Override
	protected void setUp() throws Exception {
		this.code39BarcodeScanner = new Code39BarcodeScanner();
		this.code39BarcodeMaker = new BC4JCode39BarcodeMaker();
	}
	
	@Override
	protected void tearDown() throws Exception {
		this.code39BarcodeScanner = null;
		this.code39BarcodeMaker = null;
	}
	
	public void testInstance(){
		Assert.assertTrue(this.code39BarcodeScanner instanceof IBarcodeScanner);
	}
	
	public void testScan() throws IOException{
		String data = String.format("%s", new Date().getTime());
		String directoryPath = Temporary.getTempDirectoryPath();
		File file = this.code39BarcodeMaker.create(data,
				directoryPath);
		
		String result = null;
		try {
			result = this.code39BarcodeScanner.scan(file.getName(), directoryPath);
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (ChecksumException e) {
			e.printStackTrace();
		} catch (FormatException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(data, result);
	}

}
