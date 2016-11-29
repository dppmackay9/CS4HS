package cs4hs.gui.control.managers.viewmanager.builders;

import cs4hs.gui.control.Controller;
import cs4hs.gui.views.MainView;
import cs4hs.gui.views.View;

/**
 * This class provides the most basic implementation of creating the views.
 * 
 * @author Chris
 */
public class BasicViewBuilder extends ViewBuilder {

	@Override
	public View[] createViews(Controller control) {
		int size = 1;
		View[] tmp = new View[size];
		tmp[0] = new MainView(control);
		return tmp;
	}

}
