package cs4hs.gui.nodedrawer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import cs4hs.tool.nodes.FNode;
import cs4hs.tool.values.Colours;
import cs4hs.tool.values.Values;

/**
 * This class provides a method which represents the FNode. The GUINode draws in
 * the center of the JPanel. This class is responsible for drawing the bars.
 * 
 * @author Chris
 */
public class GUINode {

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
		if (node != null) {
			Dimension size = parent.getSize();
			// Draw the data representation
			// Find the width, height scale, mid and bot line
			int width = (size.width - (Values.PADDING * 2)) / node.getData().size();
			int scale = (size.height - (Values.PADDING * 2)) / node.getData().size();
			int mid = size.height / 2;
			int bot = mid + ((node.getData().size() * scale) / 2);
			// draw the bars and highlights
			drawBars(g, width, scale, bot);
			Highlighter.draw(node, g, width, scale, bot);
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
		for (int i = 0; i < data.size(); i++) {
			int height = data.get(i) * scale;
			int x = (i * width) + Values.PADDING;
			int y = bot - height;
			// draws the bar
			drawBar(g, x, y, width, height);
		}
	}

	private void drawBar(Graphics g, int x, int y, int width, int height) {
		g.setColor(Colours.BAR_COLOUR);
		g.fillRect(x, y, width, height);
		g.setColor(Colours.OUTLINE_COLOUR);
		g.drawRect(x, y, width, height);
	}
}
