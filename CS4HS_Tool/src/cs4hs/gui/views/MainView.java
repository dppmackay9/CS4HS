package cs4hs.gui.views;

import cs4hs.gui.control.Controller;
import cs4hs.gui.control.Controller.View;

/**
 * This view contains all the controls and display of the tool
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class MainView extends View {

	private static final String[] searchAlgorithms = { "Linear", "Binary" };
	private static final String[] sortAlgorithms = { "Selection", "Insertion" };
	private static final String[] availableData = { "data-10", "data-100", "data-1k", "data-10k", "data-100k" };

	public MainView(Controller controller) {
		super(controller);
	}

	@Override
	public void initialise() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}
