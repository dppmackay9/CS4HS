/*	File: Sorter.java
 * 
 * 	Date			Author				Changes
 * 	12 Oct 16		Chris Rabe			implemented selectionSort
 * 	11 Nov 16		Chris Rabe			implemented insertionSort
 */
package cs4hs.tool.util;

import java.util.ArrayList;
import java.util.List;

import cs4hs.tool.nodes.FNode;
import cs4hs.tool.nodes.SlowSortNode;

/**
 * Contains various sorting algorithms which returns a list of FNodes. Each
 * FNode represents the steps taken by the algorithm which should be displayed.
 * 
 * @author Chris
 */
public class Sorter {

	/**
	 * Sorts the given data using the selection sort algorithm. It returns the
	 * steps of each node taken on every iteration.
	 * 
	 * @param data
	 * @return
	 */
	public static List<FNode> selectionSort(List<Integer> data) {
		List<FNode> steps = new ArrayList<FNode>();
		// for each position, from 0 up, find the next smallest item
		// and swap it into place
		for (int place = 0; place < data.size() - 1; place++) {
			int minIndex = place; // record the last element of the sorted set
			steps.add(new SlowSortNode(data, place, minIndex));
			for (int sweep = place + 1; sweep < data.size(); sweep++) {
				if (data.get(sweep) < data.get(minIndex)) {
					minIndex = sweep;
				}
				steps.add(new SlowSortNode(data, place, minIndex, sweep));
			} // At the end of this loop, you would have recorded the index of
				// the next smallest item
			steps.add(new SlowSortNode(data, place, minIndex));
			swap(data, place, minIndex);
		}
		return steps;
	}

	/**
	 * Sorts the given data using the insertion sort algorithm. It returns the
	 * steps of each node taken on every iteration.
	 * 
	 * @param data
	 * @return
	 */
	public static List<FNode> insertionSort(List<Integer> data) {
		List<FNode> steps = new ArrayList<FNode>();
		// for each item, from 0, insert into place in the sorted region
		for (int i = 1; i < data.size(); i++) {
			int item = data.get(i);
			int place = i;
			steps.add(new SlowSortNode(data, i, place));
			// compares the item at index i with the sorted region
			while (place > 0 && (item < data.get(place - 1))) {
				data.set(place, data.get(place - 1));
				place--;
				steps.add(new SlowSortNode(data, i, i, place));
			}
			steps.add(new SlowSortNode(data, i, place));
			data.set(place, item);
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
