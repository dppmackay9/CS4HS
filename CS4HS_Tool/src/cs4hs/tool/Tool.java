/*	File: Tool.java
 * 	
 * 	Date				Author				Changes
 * 	19 Oct 16			Chris Rabe			created Tool.java
 * 	21 Oct 16			Chris Rabe			implemented functionalities to the tool
 */
package cs4hs.tool;

import java.util.List;

import cs4hs.tool.nodes.FNode;

/**
 * This class keeps track of all the steps taken by the algorithm. It provides
 * functionalities such as "step", "undo", and "run". "Step" executes one
 * function node. "Undo" moves back one step. "Run" goes through the whole
 * algorithm.
 * 
 * @author Chris
 */
public class Tool {

	public static List<FNode> steps;

	private int cur = 0;

	/**
	 * Retrieves the function node which the tool is currently pointing to.
	 * 
	 * @return
	 */
	public FNode getCurNode() {
		if (steps == null || steps.isEmpty()) {
			return null;
		}
		return steps.get(cur);
	}

	/**
	 * Moves the cursor forward
	 */
	public void step() {
		if (cur < steps.size() - 1) {
			cur++;
		}
	}

	/**
	 * Moves the cursor backward
	 */
	public void undo() {
		if (cur > 0) {
			cur--;
		}
	}

}
