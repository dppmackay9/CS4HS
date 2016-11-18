/*	File: Searcher.java
 * 
 * 	Date			Author				Changes
 * 	11 Nov 16		Chris Rabe			implemented linearSearch
 * 	11 Nov 16		Chris Rabe			implemented binarySearch
 */
package cs4hs.tool.util;

import java.util.ArrayList;
import java.util.List;

import cs4hs.tool.nodes.BinaryNode;
import cs4hs.tool.nodes.FNode;
import cs4hs.tool.nodes.SearchNode;

/**
 * Contains various searching algorithms which returns a list of FNodes. Each
 * FNode represents the steps taken by the algorithm which should be displayed.
 * 
 * @author Chris
 */
public abstract class Searcher {

	/**
	 * Performs a linear search algorithm to find the given item. It returns the
	 * steps taken by the algorithm to find the item.
	 * 
	 * @param item
	 * @param data
	 * @return
	 * @throws SearchException
	 */
	public static List<FNode> linearSearch(int item, List<Integer> data) {
		List<FNode> steps = new ArrayList<FNode>();
		// go through the data one by one...
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) == item) {
				SearchNode node = new SearchNode(data, i);
				node.setItem(i);
				steps.add(node);
				return steps;
			}
			steps.add(new SearchNode(data, i));
		}
		return steps;
	}

	/**
	 * Uses binary search to find the index of the item and returns a list of
	 * steps taken to find the item. This function requires the data to be
	 * sorted from smallest to biggest values.
	 * 
	 * @param item
	 * @param data
	 * @return
	 */
	public static List<FNode> binarySearch(int item, List<Integer> data) {
		List<FNode> steps = new ArrayList<FNode>();
		int low = 0;
		int high = data.size() - 1;

		while (low < high) {
			int mid = (low + high + 1) / 2;
			steps.add(new BinaryNode(data, mid, high, low));
			if (item == data.get(mid)) {
				steps.add(new BinaryNode(data, mid, high, low));
				return steps;
			}
			if (item > data.get(mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return steps;
	}
}
