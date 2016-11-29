package cs4hs.gui.control.managers.logicmanager;

import cs4hs.gui.control.Controller;
import cs4hs.tool.Tool;
import cs4hs.tool.nodes.FNode;
import cs4hs.tool.values.Values;

/**
 * This class is responsible for all the back-end functionalities of the
 * software. It directly performs action to the tool object.
 * 
 * @author Chris
 */
public abstract class LogicManager {

	protected Tool tool;
	protected Controller control;

	public LogicManager(Tool tool, Controller parent) {
		this.tool = tool;
		this.control = parent;
	}

	/**
	 * Retrieves the current function node which the tool is pointing to.
	 * 
	 * @return
	 */
	public abstract FNode getCurNode();

	/**
	 * Performs the specified algorithm based on the string passed in the
	 * algorithmStr parameter.
	 * 
	 * @param algorithmStr
	 * @param dataStr
	 * @param item
	 */
	public abstract void doAlgorithm(String algorithmStr, String dataStr, int item);

	/**
	 * Executes exactly one iteration of the algorithm.
	 */
	public abstract void doStep();

	/**
	 * Executes exactly one iteration back of the algorithm.
	 */
	public abstract void doUndo();

	/**
	 * Executes the entire iteration of the algorithm.
	 */
	public abstract void doRun();

	/**
	 * Stops the algorithm execution.
	 */
	public abstract void doStop();

	/**
	 * Skips to the end of the algorithm execution.
	 */
	public abstract void doSkip();

	// Helper Methods

	protected Values.Algorithm determineAlgorithm(String algorithmStr) {
		switch (algorithmStr) {
		case "Linear":
			return Values.Algorithm.LINEAR;
		case "Binary":
			return Values.Algorithm.BINARY;
		case "Selection":
			return Values.Algorithm.SELECTION;
		case "Insertion":
			return Values.Algorithm.INSERTION;
		default:
			return null;
		}
	}
}
