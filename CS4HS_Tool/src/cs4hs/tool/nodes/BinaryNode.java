/*	File: BinaryNode.java
 * 
 * 	Date				Author				Changes
 * 	19 Oct 16			Chris Rabe			created BinaryNode.java
 */

package cs4hs.tool.nodes;

import java.util.List;

/**
 * This node represents a step of the binary search algorithm.
 * 
 * @author Chris
 */
public class BinaryNode extends SearchNode {

	private int hiPtr; // high index
	private int loPtr; // low index

	private boolean interpolate;
	private int kValue; // special k value for interpolate search

	public BinaryNode(List<Integer> data, int mainPtr, int hiPtr, int loPtr) {
		super(data, mainPtr);
		this.hiPtr = hiPtr;
		this.loPtr = loPtr;
	}

	public BinaryNode(List<Integer> data, int mainPtr, int hiPtr, int loPtr, int kValue) {
		this(data, mainPtr, hiPtr, loPtr);
		this.interpolate = true;
		this.kValue = kValue;
	}

	public int getHiPtr() {
		return hiPtr;
	}

	public void setHiPtr(int hiPtr) {
		this.hiPtr = hiPtr;
	}

	public int getLoPtr() {
		return loPtr;
	}

	public void setLoPtr(int loPtr) {
		this.loPtr = loPtr;
	}

	public boolean isInterpolate() {
		return interpolate;
	}

	public void setInterpolate(boolean interpolate) {
		this.interpolate = interpolate;
	}

	public int getkValue() {
		return kValue;
	}

	public void setkValue(int kValue) {
		this.kValue = kValue;
	}

}
