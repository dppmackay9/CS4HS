package cs4hs.gui.views.display;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import cs4hs.gui.control.Controller.View;

/**
 * This class provides a skeletal implementation of the display panels. It steps
 * up the panel so that the control panel is placed at the top row and the main
 * panel is centered on the panel.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class Display extends JPanel {

	protected View parent;

	public Display(View parent) {
		this.parent = parent;
		initialise();
	}

	/**
	 * Creates the control panel for all the buttons related to this display.
	 */
	public abstract JPanel createControl();

	/**
	 * Creates a panel for the main content of this display
	 */
	public abstract JPanel createBody();

	/**
	 * Adds action listeners to any components in the body or control panel
	 */
	public abstract void addActionListeners();

	/**
	 * Updates the display
	 */
	public abstract void update();

	private void initialise() {
		JPanel controlPanel = createControl();
		JPanel bodyPanel = createBody();
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(bodyPanel, BorderLayout.CENTER);
		this.addActionListeners();
	}

	@Override
	public Dimension getPreferredSize() {
		return parent.getPreferredSize();
	}
}
