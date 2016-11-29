package cs4hs.gui.control.managers.logicmanager;

import java.util.List;

import cs4hs.assets.Assets;
import cs4hs.gui.control.Controller;
import cs4hs.gui.util.factories.DialogFactory;
import cs4hs.tool.Tool;
import cs4hs.tool.nodes.FNode;
import cs4hs.tool.util.ToolException;
import cs4hs.tool.values.Options;
import cs4hs.tool.values.Values;

/**
 * Provides basic implementation of the logic for the controller.
 * 
 * @author Chris
 */
public class BasicLogicManager extends LogicManager implements Runnable {

	private Thread updater;

	public BasicLogicManager(Tool tool, Controller parent) {
		super(tool, parent);
	}

	// Tool Interaction Methods

	@Override
	public FNode getCurNode() {
		try {
			return tool.getCurNode();
		} catch (ToolException e) {
			DialogFactory.showError(control, e.getMessage());
			return null;
		}
	}

	@Override
	public void doAlgorithm(String algorithmStr, String dataStr, int item) {
		Values.Algorithm algorithm = determineAlgorithm(algorithmStr);
		if (algorithm == null) {
			return;
		}
		List<Integer> data = Assets.getDataList(dataStr);
		tool.performAlgorithm(algorithm, item, data);
		control.getViewManager().updateView();
	}

	@Override
	public void doStep() {
		tool.step();
		control.getViewManager().updateView();
	}

	@Override
	public void doUndo() {
		tool.undo();
		control.getViewManager().updateView();
	}

	@Override
	public void doRun() {
		if (updater == null) {
			updater = new Thread(this);
			updater.start();
		}
	}

	@Override
	public void doStop() {
		updater = null;
		control.getViewManager().updateView();
	}

	@Override
	public void doSkip() {
		doStop();
		tool.skip();
		control.getViewManager().updateView();
	}

	// Run Methods

	@Override
	public void run() {
		while (updater != null) {
			doStep();
			control.getViewManager().updateView();
			if (tool.cursorAtEnd()) {
				Options.IS_RUNNING = false;
				break;
			}
			try {
				Thread.sleep(Options.RUN_SPEED);
			} catch (InterruptedException e) {
				Options.IS_RUNNING = false;
				break;
			}
		}
		updater = null;
	}

}
