package com.techsocialist.utilities.temp;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

public class TestTemporary extends TestCase {
	
	public void testGetTempDirectoryPath() {
		String tempDirectory = Temporary.getTempDirectoryPath();
		Assert.assertNotNull(tempDirectory);
	}

	public void testCreateTempFile_1() throws IOException {
		File tempFile = Temporary.createTempFile();
		Assert.assertNotNull(tempFile);
	}

	public void testCreateTempFile_2() throws IOException {
		String prefix = "test";
		String suffix = "temp";
		File tempFile = Temporary.createTempFile(prefix, suffix);
		Assert.assertNotNull(tempFile);
	}
	
	public void testCreateTempFile_3() throws IOException {
		String prefix = "test";
		String suffix = "temp";
		String targeDirPath = Temporary.getTempDirectoryPath();
		File tempFile = Temporary.createTempFile(prefix, suffix, targeDirPath);
		Assert.assertNotNull(tempFile);
	}
}
