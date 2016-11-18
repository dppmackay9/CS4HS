package cs4hs.tool.values;

/**
 * This class contains static variables which represents the settings for this
 * application
 * 
 * @author Chris
 */
public abstract class Options {

	// Note: data-1k, data-10k, data-100k are available. However due to
	// performance issues, I've disabled them for now.
	public static final String[] DATA = { "data-10", "data-100" };

	public static String[] getAlgorithms() {
		return new String[] { "Linear", "Binary", "Selection", "Insertion" };
	}

	public static boolean IS_RUNNING = false;

	public static int RUN_SPEED = Values.FAST;

	/**
	 * If safety mode is true, then it means that the tool would try to verify
	 * if the pre-condition of the algorithm is met and always gives the
	 * appropriate data for method before calling it.
	 */
	public static boolean SAFETY_MODE = true;

}
