package cs4hs.gui.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class provides methods which create various JDialog Panes to display
 * error or informational messages.
 * 
 * @author Chris
 */
public abstract class DialogFactory {

	public static void showMessage(JFrame parent, String text) {
		JOptionPane.showMessageDialog(parent, text);
	}

	public static void showError(JFrame parent, String text) {
		JOptionPane.showMessageDialog(parent, text, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
