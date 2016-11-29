package cs4hs.gui.control.managers.menumanager;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import cs4hs.gui.control.Controller;
import cs4hs.gui.util.factories.DialogFactory;
import cs4hs.tool.values.AppInfo;
import cs4hs.tool.values.Options;
import cs4hs.tool.values.Values;
import cs4hs.tool.values.Values.Speed;

public class BasicMenuManager extends MenuManager {

	// Options Menu
	private JMenuItem safety; // safety mode option
	private JMenuItem speed; // speed of the run algorithm
	// Help Menu
	private JMenuItem about; // information about the program

	@Override
	public void initialiseMenu(Controller frame) {
		// Create Menu Items
		safety = new JMenuItem(String.format("Toggle Safety %s", Options.SAFETY_MODE ? "Off" : "On"));
		speed = new JMenuItem("Set Speed");
		about = new JMenuItem("About");
		// Make Options Menu
		JMenu options = new JMenu("Options");
		JMenu help = new JMenu("Help");
		// Add components to the menu
		options.add(safety);
		options.add(speed);
		help.add(about);
		// Put everything together in menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(options);
		menuBar.add(help);
		frame.setJMenuBar(menuBar);
	}

	@Override
	protected void addActionListeners(Controller frame) {
		safety.addActionListener(e -> {
			// Change Options Variable
			Options.SAFETY_MODE = !Options.SAFETY_MODE;
			// Change Text of Safety
			safety.setText(String.format("Toggle Safety %s", Options.SAFETY_MODE ? "Off" : "On"));
		});
		speed.addActionListener(e -> {
			Speed speed = (Speed) JOptionPane.showInputDialog(frame, "Select run speed", "", JOptionPane.PLAIN_MESSAGE,
					null, Speed.values(), Speed.FAST);
			if (speed == Speed.VERY_SLOW) {
				Options.RUN_SPEED = Values.VERY_SLOW;
			} else if (speed == Speed.MEDIUM) {
				Options.RUN_SPEED = Values.MEDIUM;
			} else if (speed == Speed.SLOW) {
				Options.RUN_SPEED = Values.SLOW;
			} else {
				Options.RUN_SPEED = Values.FAST;
			}
		});
		about.addActionListener(e -> {
			DialogFactory.showMessage(frame, AppInfo.ABOUT);
		});
	}

}
