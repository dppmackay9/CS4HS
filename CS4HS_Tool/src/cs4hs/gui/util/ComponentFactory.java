package cs4hs.gui.util;

import cs4hs.gui.control.Controller;
import cs4hs.gui.control.Controller.View;
import cs4hs.gui.views.MainView;

/**
 * This class contains methods which creates JComponents for the Controller and
 * the View.
 * 
 * @author Chris
 */
public abstract class ComponentFactory {

	public static View[] createViews(Controller control) {
		int size = 1;
		View[] tmp = new View[size];
		tmp[0] = new MainView(control);
		return tmp;
	}
}
