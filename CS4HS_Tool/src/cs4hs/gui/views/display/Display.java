package cs4hs.gui.views.display;

import java.awt.Dimension;

import javax.swing.JPanel;

import cs4hs.gui.views.View;

@SuppressWarnings("serial")
public abstract class Display extends JPanel {
	protected View parent;

	public Display(View parent) {
		this.parent = parent;
	}

	public Dimension getPreferredSize() {
		return parent.getPreferredSize();
	}

	public abstract void update();
}
