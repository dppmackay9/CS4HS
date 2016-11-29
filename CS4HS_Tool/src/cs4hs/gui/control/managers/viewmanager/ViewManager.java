package cs4hs.gui.control.managers.viewmanager;

import cs4hs.gui.control.Controller;
import cs4hs.gui.control.managers.viewmanager.builders.ViewBuilder;
import cs4hs.gui.views.View;

/**
 * This class is responsible for changing the view of the controller. You MUST
 * call the setup method after this class is constructed.
 * 
 * @author Chris
 */
public abstract class ViewManager {
	private ViewBuilder builder;
	protected Controller frame;

	protected View[] views;
	protected int cur;
	protected int prev;

	public ViewManager(ViewBuilder builder) {
		this.prev = 0;
		this.cur = 0;
		this.builder = builder;
	}

	public void setup(Controller frame) {
		this.views = builder.createViews(frame);
		this.frame = frame;
	}

	/**
	 * Changes the view at the specified index.
	 * 
	 * @param index
	 */
	public abstract void changeView(int index);

	/**
	 * Updates the state of the view
	 * 
	 */
	public abstract void updateView();

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
