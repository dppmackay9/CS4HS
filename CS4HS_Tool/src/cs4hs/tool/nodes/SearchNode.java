/*	File: SearchNode.java
 * 
 * 	Date				Author			Changes
 * 	19 Oct 16			Chris Rabe		created SearchNode.java
 */
package cs4hs.tool.nodes;

import java.util.List;

/**
 * This node stores the value of the item being searched for in the data.
 * 
 * @author Chris
 */
public class SearchNode extends FNode {

	private int item;

	public SearchNode(List<Integer> data, int mainPtr) {
		super(data, mainPtr);
		item = -1;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}
}
