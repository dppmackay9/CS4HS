/*	File: SortNode.java
 * 
 * 	Date					Author				Changes
 * 	19 Oct 16				Chris Rabe			created SortNode.java
 */
package cs4hs.tool.nodes;

import java.util.List;

/**
 * This node stores the index which holds the minimum value of the algorithm.
 * 
 * @author Chris
 */
public class SortNode extends FNode {

	private int minPtr;

	public SortNode(List<Integer> data, int mainPtr, int minPtr) {
		super(data, mainPtr);
		this.minPtr = minPtr;
	}

	public int getMinPtr() {
		return minPtr;
	}

	public void setMinPtr(int minPtr) {
		this.minPtr = minPtr;
	}
}
