package cs4hs.gui.util.factories;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs4hs.gui.control.Controller;

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

	public static int showConfirm(Controller control, String msg) {
		return JOptionPane.showConfirmDialog(control, msg, "", JOptionPane.YES_NO_OPTION);
	}
}
