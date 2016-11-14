package cs4hs.gui.views.panels;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import cs4hs.gui.control.Controller.View;
import cs4hs.gui.util.GUINode;
import cs4hs.tool.nodes.FNode;

/**
 * This panel displays the data as bar graphs. It highlights important indices
 * in a different colour than the rest of the data.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DataPanel extends JPanel {

	private GUINode node;
	private View parent;

	public DataPanel(View parent) {
		this.parent = parent;
	}

	public void update(FNode node) {
		this.node = new GUINode(node);
	}

	@Override
	public Dimension getPreferredSize() {
		return parent.getPreferredSize();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		node.draw(this, g);
	}
}
