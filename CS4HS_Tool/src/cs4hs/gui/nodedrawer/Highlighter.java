package cs4hs.gui.nodedrawer;

import java.awt.Graphics;

import cs4hs.gui.nodedrawer.values.Colours;
import cs4hs.gui.nodedrawer.values.Values;
import cs4hs.tool.nodes.*;

/**
 * This class provides methods which highlights any special indices of the
 * function node.
 * 
 * @author Chris
 */
public abstract class Highlighter {

	/**
	 * This method highlights the main index
	 * 
	 * @param node
	 * @param g
	 */
	public static void draw(FNode node, Graphics g, int width, int scale, int bot) {
		int main = node.getMainPtr();
		int height = node.getData().get(main) * scale;
		int x = (main * width) + Values.PADDING;
		int y = bot - height;
		drawBar(Colours.ORANGE, g, x, y, width, height);
		drawSpecialIndices(node, g, width, scale, bot);
	}

	/**
	 * Draws the other indices related to the dynamic type of the node
	 */
	private static void drawSpecialIndices(FNode node, Graphics g, int width, int scale, int bot) {
		if (node instanceof BinaryNode) {
			drawBinaryNode((BinaryNode) node, g, width, scale, bot);
		} else if (node instanceof SearchNode) {
			drawSearchNode((SearchNode) node, g, width, scale, bot);
		} else if (node instanceof SlowSortNode) {
			drawSortNode((SlowSortNode) node, g, width, scale, bot);
		}
	}

	private static void drawSortNode(SlowSortNode node, Graphics g, int width, int scale, int bot) {
		int[] values = { node.getMinPtr(), node.getSweep() };
		for (int i = 0; i < values.length; i++) {
			if (!isValid(values[i], node.getData().size())) {
				continue;
			}
			int height = node.getData().get(values[i]) * scale;
			int x = (values[i] * width) + Values.PADDING;
			int y = bot - height;
			if (i == 0) {
				drawBar(Colours.GREEN, g, x, y, width, height);
			} else {
				drawBar(Colours.YELLOW, g, x, y, width, height);
			}
		}
	}

	private static void drawBinaryNode(BinaryNode node, Graphics g, int width, int scale, int bot) {
		int[] values = { node.getHiPtr(), node.getLoPtr(), node.getItem() };
		for (int i = 0; i < values.length; i++) {
			if (!isValid(values[i], node.getData().size())) {
				continue;
			}
			int height = node.getData().get(values[i]) * scale;
			int x = (values[i] * width) + Values.PADDING;
			int y = bot - height;
			if (i == 0) {
				drawBar(Colours.GREEN, g, x, y, width, height);
			} else if (i == 1) {
				drawBar(Colours.YELLOW, g, x, y, width, height);
			} else {
				drawBar(Colours.PURPLE, g, x, y, width, height);
			}
		}
	}

	private static void drawSearchNode(SearchNode node, Graphics g, int width, int scale, int bot) {
		int item = node.getItem();
		if (item < 0) {
			return;
		}
		int height = node.getData().get(item) * scale;
		int x = (item * width) + Values.PADDING;
		int y = bot - height;
		drawBar(Colours.PURPLE, g, x, y, width, height);
	}

	private static boolean isValid(int value, int size) {
		return 0 <= value && value < size;
	}

	private static void drawBar(int i, Graphics g, int x, int y, int width, int height) {
		switch (i) {
		case Colours.GREEN:
			g.setColor(Colours.GREEN_COLOUR);
			break;
		case Colours.ORANGE:
			g.setColor(Colours.ORANGE_COLOUR);
			break;
		case Colours.PURPLE:
			g.setColor(Colours.PURPLE_COLOUR);
			break;
		case Colours.YELLOW:
			g.setColor(Colours.YELLOW_COLOUR);
			break;
		}
		g.fillRect(x, y, width, height);
		g.setColor(Colours.OUTLINE_COLOUR);
		g.drawRect(x, y, width, height);
	}

}
