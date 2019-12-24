package com.techsocialist.utilities.temp;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Temporary {

	private static Temporary temporary;

	private Temporary() {
	}

	public String tempDirectoryPath() {
		return System.getProperty("java.io.tmpdir");
	}

	public File tempFile(String prefix, String suffix, String targeDirPath)
			throws IOException {
		return File.createTempFile(prefix, suffix, new File(targeDirPath));
	}

	public File tempFile(String prefix, String suffix) throws IOException {
		return this.tempFile(prefix, suffix, this.tempDirectoryPath());
	}

	public File tempFile() throws IOException {
		String prefix = String.format("file-%s", new Date().getTime());
		String suffix = "temp";
		return this.tempFile(prefix, suffix);
	}

	public static String getTempDirectoryPath() {
		return Temporary.temporary.tempDirectoryPath();
	}

	public static File createTempFile() throws IOException {
		return Temporary.temporary.tempFile();
	}

	public static File createTempFile(String prefix, String suffix)
			throws IOException {
		return Temporary.temporary.tempFile(prefix, suffix);
	}

	public static File createTempFile(String prefix, String suffix,
			String targeDirPath) throws IOException {
		return Temporary.temporary.tempFile(prefix, suffix,
				targeDirPath);
	}

	static {
		Temporary.temporary = new Temporary();
	}
}
