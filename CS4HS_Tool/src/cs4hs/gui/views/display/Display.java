package cs4hs.gui.views.display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cs4hs.gui.control.Controller.View;
import cs4hs.gui.util.ComponentFactory;
import cs4hs.tool.util.SignalException;

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
	 * 
	 * @throws SignalException
	 */
	public abstract void update() throws SignalException;

	private void initialise() {
		JPanel controlPanel = createControl();
		//JPanel bodyPanel = createBody();
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.NORTH);
		//this.add(bodyPanel, BorderLayout.CENTER);
		this.addActionListeners();
	}

	@Override
	public Dimension getPreferredSize() {
		return parent.getPreferredSize();
	}

	protected JPanel createComponentPane(JComponent component, String text) {
		// setup components
		JLabel label = ComponentFactory.createLabel(text);
		// setup panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// put everything together
		panel.add(label);
		panel.add(component);
		return panel;
	}

}
