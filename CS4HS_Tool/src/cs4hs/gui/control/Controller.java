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

	public Controller(ContentManager content, LogicManager logic, MenuManager menu, ViewManager view) {
		content.initialiseContent(this);
		menu.initialiseMenu(this);
		this.logic = logic;
		this.view = view;
	}

	public LogicManager getLogic() {
		return logic;
	}

	public ViewManager getView() {
		return view;
	}

}
