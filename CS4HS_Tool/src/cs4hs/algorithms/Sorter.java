package cs4hs.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Various sorting algorithms which includes:
 * <ul>
 * <li>Selection Sort</li>
 * <li>Insertion Sort</li>
 * <li>Merge Sort</li>
 * </ul>
 * @author Chris Rabe
 * @version 0.4
 */
public class Sorter {

	/**
	 * Constructor for objects of class Sorter
	 */
	public Sorter() {
	}

	// HELPER METHODS
	
	/** Helper method which swaps two items in an array */
	private void swap(List<Integer> data, int index1, int index2) {
		if (index1 == index2)
			return;
		int temp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, temp);
	}

	// SORTING ALGORITHMS

	// [SELECTION SORT]
	/**
	 * Sorts the elements of the array of integers using selection sort
	 */
	public void selectionSort(List<Integer> data) {
		// for each position, from 0 up, find the next smallest item
		// and swap it into place
		for (int place = 0; place < data.size() - 1; place++) {
			int minIndex = place; // record the last element of the sorted set
			for (int sweep = place + 1; sweep < data.size(); sweep++) {
				if (data.get(sweep) < data.get(minIndex)) {
					minIndex = sweep;
				}
			} // At the end of this loop, you would have recorded the index of
				// the next smallest item
			swap(data, place, minIndex);
		}
	}

	// [INSERTION SORT]

	/**
	 * Sorts the elements of the array of integers using insertion sort
	 * 
	 *
	 */
	public void insertionSort(List<Integer> data) {
		// for each item, from 0, insert into place in the sorted region
		for (int i = 1; i < data.size(); i++) {
			int item = data.get(i);
			int place = i;
			while (place > 0 && (item < data.get(place - 1))) {
				data.set(place, data.get(place - 1));
				place--;
			}
			data.set(place, item);
		}
	}

	// [MERGE SORT]

	/**
	 * Wrapper method for merge sort This method calls the recursive method for
	 * merge sort.
	 */
	public void mergeSort(List<Integer> data) {
		List<Integer> other = new ArrayList<Integer>();
		/*
		 * Put all items in the other data array Why? This is because you want
		 * to alter the original data using the copy of the array. What the
		 * mergesort method essentially does is that it overwrites the elements
		 * within the original array with the copied array via the "merge"
		 * method.
		 */
		for (int i : data) {
			other.add(i);
		}
		mergeSort(data, other, 0, data.size()); // Call the recursive method
												// (this method executes merge
												// sort algorithm)
	}

	/**
	 * Merge Sort algorithm
	 * 
	 * Recursion is basically a programming technique which sort of acts like a
	 * loop and you are calling the method within itself. 
	 * @see https://en.wikipedia.org/wiki/Recursion_(computer_science)
	 */
	public void mergeSort(List<Integer> data, List<Integer> temp, int low, int high) {
		if (low < high - 1) {
			int mid = (low + high) / 2;
			mergeSort(temp, data, low, mid);
			mergeSort(temp, data, mid, high);
			merge(temp, data, low, mid, high);
		}
	}

	/**
	 * Merges two halves of the list and sorts them
	 * 
	 */
	public void merge(List<Integer> from, List<Integer> to, int low, int mid, int high) {
		int index = low; // where we will put the item into "to"
		int indxLeft = low; // index into the lower half of the "from" range
		int indxRight = mid; // index into the upper half of the "from" range
		while (indxLeft < mid && indxRight < high) {
			if (from.get(indxLeft) <= from.get(indxRight)) {
				to.set(index, from.get(indxLeft));
				index++;
				indxLeft++;
			} else {
				to.set(index, from.get(indxRight));
				index++;
				indxRight++;
			}
		}
		// copy over the remainder.
		while (indxLeft < mid) {
			to.set(index, from.get(indxLeft));
			index++;
			indxLeft++;
		}
		while (indxRight < high) {
			to.set(index, from.get(indxRight));
			index++;
			indxRight++;
		}
	}

}
