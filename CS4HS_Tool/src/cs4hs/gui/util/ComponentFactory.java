package cs4hs.gui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cs4hs.gui.control.Controller;
import cs4hs.gui.control.Controller.View;
import cs4hs.gui.views.MainView;

/**
 * This class contains methods which creates JComponents for the Controller and
 * the View.
 * 
 * @author Chris
 */
public abstract class ComponentFactory {

	public static JButton createButton(Image img) {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon(img));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorder(null);
		btn.setFocusPainted(false);
		return btn;
	}

	public static JButton createButton(String text) {
		JButton btn = new JButton(text);
		btn.setFocusable(false);
		return btn;
	}

	public static JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setName(text);
		label.setBorder(new EmptyBorder(0, 0, 25, 0));
		label.setForeground(Color.BLACK);
		label.setFocusable(false);
		return label;
	}

	public static JTextField createTextField() {
		JTextField tf = new JTextField();
		Dimension size = new Dimension(100, 25);
		tf.setPreferredSize(size);
		tf.setMaximumSize(size);
		tf.setForeground(Color.BLACK);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setEditable(true);
		return tf;
	}

	public static JComboBox<String> createStringCombo(String[] content) {
		JComboBox<String> cb = new JComboBox<String>(content);
		cb.setSelectedIndex(0);
		Dimension size = new Dimension(100, 25);
		cb.setPreferredSize(size);
		cb.setMaximumSize(size);
		return cb;
	}

	public static JTabbedPane createTabbedPane() {
		JTabbedPane tPane = new JTabbedPane();
		return tPane;
	}

	public static View[] createViews(Controller control) {
		int size = 1;
		View[] tmp = new View[size];
		tmp[0] = new MainView(control);
		return tmp;
	}
}
