package cs4hs.gui.control.managers.menumanager;

import cs4hs.gui.control.Controller;

/**
 * This class is responsible for creating the menu bar on the controller.
 * 
 * @author Chris
 */
public abstract class MenuManager {

	/**
	 * Creates a JMenuBar and attaches it to the given controller.
	 * 
	 * @param frame
	 */
	public abstract void initialiseMenu(Controller frame);

	/**
	 * Adds some action listeners to the menu items.
	 */
	protected abstract void addActionListeners();
}
