/*	File: DataNode.java
 * 	
 * 	Date				Author				Changes
 * 	19 Oct 16			Chris Rabe			created DataNode.java
 */

package cs4hs.tool.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a list of integers. When a list of integer is passed
 * through the constructor, it creates a clone and stores it in its field.
 * 
 * @author Chris
 */
public class DataNode {
	private List<Integer> data;

	public DataNode(List<Integer> data) {
		this.data = new ArrayList<Integer>(data);
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}
