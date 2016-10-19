/*	File: MergeNode.java
 * 
 * 	Date			Author				Changes
 * 	19 Oct 16		Chris Rabe			created MergeNode.java
 */
package cs4hs.tool.nodes;

import java.util.List;

/**
 * This node keeps track of variables specific to MergeSort algorithm.
 * 
 * @author Chris
 */
public class MergeNode extends SortNode {

	private int level; // recursion level
	private int start; // start of the segment
	private int end; // end of the segment

	public MergeNode(List<Integer> data, int mainPtr, int minPtr, int level, int start, int end) {
		super(data, mainPtr, minPtr);
		this.level = level;
		this.start = start;
		this.end = end;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
