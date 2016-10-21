/*	File: Sorter.java
 * 
 * 	Date			Author				Changes
 * 	12 Oct 16		Chris Rabe			implemented selectionSort
 */
package cs4hs.tool.util;

import java.util.ArrayList;
import java.util.List;

import cs4hs.tool.nodes.FNode;
import cs4hs.tool.nodes.SelectionNode;

/**
 * Contains various sorting algorithms which returns a list of FNodes. Each
 * FNode represents the steps taken by the algorithm which should be displayed.
 * 
 * @author Chris
 */
public class Sorter {

	public static List<FNode> selectionSort(List<Integer> data) {
		List<FNode> steps = new ArrayList<FNode>();
		// for each position, from 0 up, find the next smallest item
		// and swap it into place
		for (int place = 0; place < data.size() - 1; place++) {
			int minIndex = place; // record the last element of the sorted set
			steps.add(new SelectionNode(data, place, minIndex));
			for (int sweep = place + 1; sweep < data.size(); sweep++) {
				if (data.get(sweep) < data.get(minIndex)) {
					minIndex = sweep;
				}
				steps.add(new SelectionNode(data, place, minIndex, sweep));
			} // At the end of this loop, you would have recorded the index of
				// the next smallest item
			steps.add(new SelectionNode(data, place, minIndex));
			swap(data, place, minIndex);
		}
		return steps;
	}

	/** Helper method which swaps two items in an array */
	private static void swap(List<Integer> data, int index1, int index2) {
		if (index1 == index2)
			return;
		int temp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, temp);
	}
}
