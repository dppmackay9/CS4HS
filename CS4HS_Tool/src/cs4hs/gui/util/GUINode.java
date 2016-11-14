package cs4hs.gui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import cs4hs.tool.nodes.FNode;

/**
 * This class provides a method which represents the FNode. The GUINode draws in
 * the center of the
 * 
 * @author Chris
 */
public class GUINode {

	private static final int PADDING = 20;

	private static final Color BAR_COLOUR = new Color(102, 204, 255);
	// Pointer Colours
	private static final Color A_COLOUR = new Color(255, 153, 0);
	private static final Color B_COLOUR = new Color(51, 204, 51);
	private static final Color C_COLOUR = new Color(204, 102, 255);

	private FNode node;

	public GUINode(FNode node) {
		this.node = node;
	}

	/**
	 * Draws the function node data and scales the data based on the size of the
	 * parent JPanel.
	 * 
	 * @param parent
	 * @param g
	 */
	public void draw(JPanel parent, Graphics g) {
		Dimension size = parent.getSize();
		// Draw the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, size.width, size.height);
		// Draw the data representation
		if (node != null) {
			// Find the width, height scale, mid and bot line
			int width = (size.width - (PADDING * 2)) / node.getData().size();
			int scale = (size.height - (PADDING * 2)) / node.getData().size();
			int mid = size.height / 2;
			int bot = mid + ((node.getData().size() * scale) / 2);
			drawBars(g, width, scale, bot);
		}
	}

	/**
	 * Draws the data bars. The node must not be null
	 * 
	 * @param g
	 * @param width
	 * @param scale
	 * @param bot
	 */
	private void drawBars(Graphics g, int width, int scale, int bot) {
		List<Integer> data = node.getData();
		g.setColor(BAR_COLOUR);
		for (int i = 0; i < data.size(); i++) {
			int height = data.get(i) * scale;
			int x = (i * width) + PADDING;
			int y = bot - height;
			g.fillRect(x, y, width, height);
		}
	}
}
