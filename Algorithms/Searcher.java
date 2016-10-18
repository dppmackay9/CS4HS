import java.util.List;

/**
 * This class contains static method which utilises different searching
 * algorithms. This class cannot be instantiated.
 * 
 * Search algorithms:
 * <ul>
 * <li>linear Search</li>
 * <li>binary search</li>
 * <li>interpolation search</li>
 * </ul>
 * 
 * @author Chris Rabe
 * @version 0.4
 */
public class Searcher {

	/**
	 * Searches through the collection linearly. Returns -1 if nothing was found
	 * 
	 */
	public static int linearSearch(int item, List<Integer> data) {
		int index = 0;
		for (int num : data) { // iterate through the list
			if (num == item) { // if item is found
				return index; // return the item
			}
			index++;
		}
		return -1;
	}

	/**
	 * Uses binary search to find the index of the item or returns the position
	 * of where the item should be
	 * 
	 * 
	 */
	public static int binarySearch(int item, List<Integer> data) {
		int low = 0;
		int high = data.size() - 1;

		while (low < high) {
			int mid = (low + high + 1) / 2;
			if (item == data.get(mid)) {
				return mid;
			}
			if (item > data.get(mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	/**
	 * Utilises interpolation search to find the item passed.
	 */
	public static int interpolationSearch(int item, List<Integer> data) {
		int low = 0;
		int high = data.size() - 1;

		while (low <= high) {
			if (low == high) {
				if (data.get(low) == item) {
					return low;
				} else {
					return -1;
				}
			}
			int k = (item - data.get(low)) / (data.get(high) - data.get(low));
			if (k < 0 || k > 1) {
				return -1;
			}
			int mid = Math.round(low + k * (high - low));
			if (item == data.get(mid)) {
				return mid;
			}
			if (item < data.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private Searcher() {
		// Only access to methods is required
	}
}
