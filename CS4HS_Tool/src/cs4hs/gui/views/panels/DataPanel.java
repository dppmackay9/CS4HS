package cs4hs.gui.views.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import cs4hs.gui.control.Controller.View;
import cs4hs.gui.nodedrawer.GUINode;
import cs4hs.tool.nodes.FNode;
import cs4hs.tool.values.Colours;
import cs4hs.tool.values.Options;
import cs4hs.tool.values.Values;

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
		// Draw the background
		g.setColor(Colours.OUTLINE_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		// Draw an indicator for running threads
		drawIndicator(g);
		// Draw the data representation if it exists
		if (node != null) {
			node.draw(this, g);
		}
	}

	private void drawIndicator(Graphics g) {
		if (Options.IS_RUNNING) {
			int size = Values.PADDING;
			int pos = Values.PADDING / 2 + size;
			g.setColor(Color.RED);
			g.fillOval(pos, pos, size, size);
		}
	}
}
