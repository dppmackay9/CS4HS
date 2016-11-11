/*	File: SelectionNode.java
 * 
 * 	Date				Author				Changes
 * 	21 Oct 16			Chris Rabe			created SelectionNode.java
 */
package cs4hs.tool.nodes;

import java.util.List;

/**
 * A node which records the state of the selection sort
 * 
 * @author Chris
 */
public class SlowSortNode extends SortNode {

	private int sweep; // the one which searches for the min index

	public SlowSortNode(List<Integer> data, int mainPtr, int minPtr) {
		super(data, mainPtr, minPtr);
		this.sweep = mainPtr;
	}

	public SlowSortNode(List<Integer> data, int mainPtr, int minPtr, int sweep) {
		this(data, mainPtr, minPtr);
		this.sweep = sweep;
	}

	public int getSweep() {
		return sweep;
	}

	public void setSweep(int sweep) {
		this.sweep = sweep;
	}
}
