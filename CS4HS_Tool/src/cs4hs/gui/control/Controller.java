package cs4hs.gui.control;

import javax.swing.JFrame;

import cs4hs.gui.control.managers.contentmanager.*;
import cs4hs.gui.control.managers.logicmanager.*;
import cs4hs.gui.control.managers.menumanager.*;
import cs4hs.gui.control.managers.viewmanager.*;

/**
 * In order for this class to be created, it would need to utilise four
 * different controller managers.
 * 
 * <ul>
 * <li>Content manager</li>
 * <li>Logic manager</li>
 * <li>Menu manager</li>
 * <li>View manager</li>
 * </ul>
 * 
 * This class's responsibility is to act as a mediator between the two or more
 * managers.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class Controller extends JFrame {

	private LogicManager logic;
	private ViewManager view;

	public Controller(ViewManager view, ContentManager content, MenuManager menu) {
		this.view = view;
		view.setup(this);
		menu.initialiseMenu(this);
		content.initialiseContent(this);
	}

	public LogicManager getLogicManager() {
		return logic;
	}

	public ViewManager getViewManager() {
		return view;
	}

	protected void setLogicManager(LogicManager logic) {
		this.logic = logic;
	}
}
