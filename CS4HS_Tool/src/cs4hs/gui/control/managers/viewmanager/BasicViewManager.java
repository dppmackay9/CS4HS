package cs4hs.gui.control.managers.viewmanager;

import cs4hs.gui.control.managers.viewmanager.builders.BasicViewBuilder;

/**
 * This class provides the base implementation for changing views.
 * 
 * @author Chris
 */
public class BasicViewManager extends ViewManager {

	public BasicViewManager() {
		super(new BasicViewBuilder());
	}

	@Override
	public void changeView(int index) {
		if (index < 0 || index >= views.length) {
			return;
		}
		if (views[index] == null) {
			return;
		}
		// Record the previous index.
		this.prev = this.cur;
		this.cur = index;
		// Remove and replace the view.
		frame.getContentPane().removeAll();
		frame.getContentPane().add(views[cur]);
		// Setting the focus allows event listeners to be activated
		views[index].repaint();
		views[index].setFocus();
		// Redraw the whole frame
		frame.revalidate();
	}

	@Override
	public void updateView() {
		views[cur].update();
	}

}
