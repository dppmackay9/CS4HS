/*	File: FNode.java
 * 
 * 	Date				Author				Changes
 * 	19 Oct 16			Chris Rabe			created FNode.java
 */
package cs4hs.tool.nodes;

import java.util.List;

/**
 * This keeps track of all the variables which are common between the searching
 * and sorting algorithms.
 * 
 * @author Chris
 */
public abstract class FNode {

	private DataNode data;
	private int mainPtr;

	public FNode(List<Integer> data, int mainPtr) {
		this.data = new DataNode(data);
		this.mainPtr = mainPtr;
	}

	public List<Integer> getData() {
		return data.getData();
	}

	public int getMainPtr() {
		return mainPtr;
	}
}
