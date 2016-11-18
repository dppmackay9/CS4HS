package cs4hs.tool.values;

/**
 * Contains helper values which assists in drawing
 * 
 * @author Chris
 */
public abstract class Values {

	public static enum Algorithm {
		LINEAR, BINARY, SELECTION, INSERTION
	}

	public static enum Speed {
		FAST, MEDIUM, SLOW, VERY_SLOW
	}

	public static final int FAST = 10;

	public static final int MEDIUM = 100;

	public static final int SLOW = 250;

	public static final int VERY_SLOW = 500;

	public static final int PADDING = 20;

}
