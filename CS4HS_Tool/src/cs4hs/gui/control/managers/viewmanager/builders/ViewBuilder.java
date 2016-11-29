package cs4hs.gui.control.managers.viewmanager.builders;

import cs4hs.gui.control.Controller;
import cs4hs.gui.views.View;

/**
 * This class is responsible for the initialisation of the views.
 * 
 * @author Chris
 *
 */
public abstract class ViewBuilder {

	/**
	 * Initialises the views
	 * 
	 * @param control
	 * @return
	 */
	public abstract View[] createViews(Controller control);
}
