/*	File: Assets.java
 * 	
 * 	Date				Author					Changes
 * 	19 Oct 16			Chris Rabe				created Assets.java
 */
package cs4hs.assets;

import java.io.InputStream;

/**
 * This class implements the Singleton design pattern. It contains static
 * methods for retrieving the file assets in the jar file.
 * 
 * @author Chris
 */
public class Assets {
	// Path
	private static final String FILE_STORAGE_PATH = "/cs4hs/assets/files";

	// File Getters

	public static InputStream getData10() {
		return getFile("data-10");
	}

	public static InputStream getData100() {
		return getFile("data-100");
	}

	public static InputStream getData1k() {
		return getFile("data-1k");
	}

	public static InputStream getData10k() {
		return getFile("data-10k");
	}

	public static InputStream getData100k() {
		return getFile("data-100k");
	}

	// Helper Methods

	private static InputStream getFile(String filename) {
		return Assets.class.getResourceAsStream(FILE_STORAGE_PATH + "/%s.txt");
	}
}
