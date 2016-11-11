/*	File: Tool.java
 * 	
 * 	Date				Author				Changes
 * 	19 Oct 16			Chris Rabe			created Tool.java
 * 	21 Oct 16			Chris Rabe			implemented functionalities to the tool
 */
package cs4hs.tool;

import java.util.Collections;
import java.util.List;

import cs4hs.tool.nodes.FNode;
import cs4hs.tool.options.Options;
import cs4hs.tool.util.Searcher;
import cs4hs.tool.util.Sorter;

/**
 * This class keeps track of all the steps taken by the algorithm. It provides
 * functionalities such as "step", "undo", and "run". "Step" executes one
 * function node. "Undo" moves back one step. "Run" goes through the whole
 * algorithm.
 * 
 * This also acts as a bridge between the searcher and sorter classes and
 * utilises their methods to retrieve the steps taken to achieve their goal.
 * 
 * 
 * @author Chris
 */
public class Tool {

	public static enum Algorithm {
		LINEAR, BINARY, SELECTION, INSERTION
	}

	private List<FNode> steps;

	private int cur = 0;

	/**
	 * Performs the appropriate algorithm based on the 'algorithm' parameter.
	 * Throws a runtime exception if the algorithm is not recognised. If the
	 * algorithm is a sorting algorithm, only the data parameter is used and
	 * must never be null.
	 * 
	 * @param algorithm
	 * @param item
	 * @param data
	 */
	public void performAlgorithm(Algorithm algorithm, int item, List<Integer> data) {
		switch (algorithm) {
		case BINARY:
			if (Options.SAFETY_MODE) {
				// If safety mode is on, always ensure that the data is sorted.
				Collections.sort(data);
			}
			steps = Searcher.binarySearch(item, data);
			break;
		case INSERTION:
			steps = Sorter.insertionSort(data);
			break;
		case LINEAR:
			steps = Searcher.linearSearch(item, data);
			break;
		case SELECTION:
			steps = Sorter.selectionSort(data);
			break;
		default:
			throw new RuntimeException("Unrecognised algorithm.");
		}
	}

	/**
	 * Returns true if the current point is at the end of the steps list.
	 * 
	 * @return
	 */
	public boolean atEnd() {
		if (steps == null) {
			return true;
		}
		return cur == steps.size();
	}

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
