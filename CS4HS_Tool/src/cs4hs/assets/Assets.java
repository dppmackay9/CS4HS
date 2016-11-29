/*	File: Assets.java
 * 	
 * 	Date				Author					Changes
 * 	19 Oct 16			Chris Rabe				created Assets.java
 */
package cs4hs.assets;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * This class implements the Singleton design pattern. It contains static
 * methods for retrieving the file assets in the jar file.
 * 
 * @author Chris
 */
public abstract class Assets {

	// Paths

	private static final String FILE_STORAGE_PATH = "/cs4hs/assets/files/";

	private static final String IMAGE_STORAGE_PATH = "/cs4hs/assets/img/";

	// Cached images

	private static Map<String, BufferedImage> cachedImages = new HashMap<String, BufferedImage>();

	// File Getters

	public static List<Integer> getDataList(String filename) {
		return getListFromFile(getFile(filename));
	}

	// Image Getters

	public static BufferedImage getExecuteImage() {
		String imgName = "execute-btn.png";
		return getCachedImage(imgName);
	}

	public static BufferedImage getRunImage(boolean active) {
		String imgName = getImageName("run-btn", active);
		return getCachedImage(imgName);
	}

	public static BufferedImage getSkipImage(boolean active) {
		String imgName = getImageName("skip-btn", active);
		return getCachedImage(imgName);
	}

	public static BufferedImage getStepImage(boolean active) {
		String imgName = getImageName("step-btn", active);
		return getCachedImage(imgName);
	}

	public static BufferedImage getStopImage(boolean active) {
		String imgName = getImageName("stop-btn", active);
		return getCachedImage(imgName);
	}

	public static BufferedImage getUndoImage(boolean active) {
		String imgName = getImageName("undo-btn", active);
		return getCachedImage(imgName);
	}

	// Helper Methods

	/**
	 * Converts the input stream file into a list of integers by reading it
	 * 
	 * @param file
	 * @return
	 */
	private static List<Integer> getListFromFile(InputStream file) {
		List<Integer> data = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(file));
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				data.add(Integer.parseInt(line));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Retrieves the file stream of the given filename
	 * 
	 * @param filename
	 * @return
	 */
	private static InputStream getFile(String filename) {
		return Assets.class.getResourceAsStream(String.format(FILE_STORAGE_PATH + "%s.txt", filename));
	}

	/**
	 * Retrieves the image inside the cache. If the image is not cache, it loads
	 * it once and that value will be retrieved repeatedly.
	 * 
	 * @param imgName
	 * @return
	 */
	private static BufferedImage getCachedImage(String imgName) {
		if (!cachedImages.containsKey(imgName)) {
			cachedImages.put(imgName, getImage(imgName));
		}
		return cachedImages.get(imgName);
	}

	private static String getImageName(String file, boolean active) {
		return String.format("%s-%s.png", file, active ? "active" : "inactive");
	}

	/**
	 * Retrieves the image of the given file name. Exits the program if the file
	 * doesn't exist.
	 * 
	 * @param filename
	 * @return
	 */
	private static BufferedImage getImage(String filename) {
		try {
			return ImageIO.read(Assets.class.getResource(IMAGE_STORAGE_PATH + filename));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
