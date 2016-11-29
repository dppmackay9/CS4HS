package cs4hs.gui.views;

import java.awt.Dimension;

import javax.swing.JPanel;

import cs4hs.gui.control.Controller;

/**
 * Views are essentially JPanels with different content. This abstract class
 * should be extended by other classes.
 */
@SuppressWarnings("serial")
public abstract class View extends JPanel {
	/** Represents the resolution of the application */
	private final Dimension RESOLUTION = new Dimension(1024, 768);

	protected Controller controller;

	public View(Controller controller) {
		this.controller = controller;
		this.setFocusable(false);
		initialise();
	}

	public Controller getController() {
		return controller;
	}

	/**
	 * Adds components to the view or performs special actions on creation.
	 */
	public abstract void initialise();

	/**
	 * Gives the focus of the key listener to the appropriate component.
	 */
	public abstract void setFocus();

	/**
	 * Updates any components inside the View when any data changed in the Model
	 * 
	 */
	public abstract void update();

	@Override
	public Dimension getPreferredSize() {
		return RESOLUTION;
	}
}