package cs4hs.tool.options;

/**
 * This class contains static variables which represents the settings for this
 * application
 * 
 * @author Chris
 */
public abstract class Options {

	public static enum Algorithm {
		LINEAR, BINARY, SELECTION, INSERTION
	}

	public static final String[] DATA = { "data-10", "data-100", "data-1k", "data-10k", "data-100k" };

	/**
	 * If safety mode is true, then it means that the tool would try to verify
	 * if the pre-condition of the algorithm is met and always gives the
	 * appropriate data for method before calling it.
	 */
	public static boolean SAFETY_MODE = true;

}
