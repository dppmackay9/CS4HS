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
import java.util.List;

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

	private static BufferedImage STEP_IMAGE;

	private static BufferedImage UNDO_IMAGE;

	private static BufferedImage RUN_IMAGE;

	private static BufferedImage STOP_IMAGE;

	private static BufferedImage SKIP_IMAGE;

	private static BufferedImage EXEC_IMAGE;

	// File Getters

	public static List<Integer> getDataList(String filename) {
		return getListFromFile(getFile(filename));
	}

	// Image Getters

	public static BufferedImage getExecImage() {
		if (EXEC_IMAGE == null) {
			EXEC_IMAGE = getImage("execute-img.png");
		}
		return EXEC_IMAGE;
	}

	public static BufferedImage getStepImage() {
		if (STEP_IMAGE == null) {
			STEP_IMAGE = getImage("step-img.png");
		}
		return STEP_IMAGE;
	}

	public static BufferedImage getUndoImage() {
		if (UNDO_IMAGE == null) {
			UNDO_IMAGE = getImage("undo-img.png");
		}
		return UNDO_IMAGE;
	}

	public static BufferedImage getRunImage() {
		if (RUN_IMAGE == null) {
			RUN_IMAGE = getImage("run-img.png");
		}
		return RUN_IMAGE;
	}

	public static BufferedImage getStopImage() {
		if (STOP_IMAGE == null) {
			STOP_IMAGE = getImage("stop-img.png");
		}
		return STOP_IMAGE;
	}

	public static BufferedImage getSkipImage() {
		if (SKIP_IMAGE == null) {
			SKIP_IMAGE = getImage("skip-img.png");
		}
		return SKIP_IMAGE;
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
