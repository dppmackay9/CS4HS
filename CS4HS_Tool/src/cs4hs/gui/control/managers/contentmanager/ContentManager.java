package cs4hs.gui.control.managers.contentmanager;

import cs4hs.gui.control.Controller;

/**
 * This class is responsible for building the content and properties of the
 * given controller.
 * 
 * @author Chris
 */
public abstract class ContentManager {

	/**
	 * Initialises the main content of the frame and adds properties to the
	 * frame.
	 * 
	 * @param frame
	 */
	public abstract void initialiseContent(Controller frame);

	/**
	 * This sets the default close operation for the frame.
	 * 
	 * @param frame
	 */
	protected abstract void setCloseOperation(Controller frame);
}
