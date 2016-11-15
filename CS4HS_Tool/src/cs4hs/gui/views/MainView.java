package cs4hs.gui.views;

import cs4hs.gui.control.Controller;
import cs4hs.gui.control.Controller.View;
import cs4hs.gui.views.display.Display;
import cs4hs.gui.views.display.MainDisplay;

/**
 * This view contains all the controls and display of the tool
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class MainView extends View {

	private Display display;

	public MainView(Controller controller) {
		super(controller);
		this.display = new MainDisplay(this);
	}

	@Override
	public void initialise() {
		this.add(display);
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void update() {
		display.update();
	}

}
