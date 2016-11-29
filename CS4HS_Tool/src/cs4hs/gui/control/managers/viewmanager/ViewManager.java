package cs4hs.gui.control.managers.viewmanager;

import cs4hs.gui.control.Controller;
import cs4hs.gui.control.managers.viewmanager.builders.ViewBuilder;
import cs4hs.gui.views.View;

/**
 * This class is responsible for changing the view of the controller.
 * 
 * @author Chris
 */
public abstract class ViewManager {
	protected View[] views;
	protected int cur;
	protected int prev;

	public ViewManager(Controller frame, ViewBuilder builder) {
		this.prev = 0;
		this.cur = 0;
		views = builder.createViews(frame);
	}

	/**
	 * Changes the view at the specified index.
	 * 
	 * @param index
	 */
	public abstract void changeView(int index);

	/**
	 * Returns the previous view
	 * 
	 * @return
	 */
	public int getPrev() {
		return prev;
	}

	/**
	 * Returns the current view
	 * 
	 * @return
	 */
	public View getCurrentView() {
		if (views != null) {
			return views[cur];
		}
		return null;
	}
}
