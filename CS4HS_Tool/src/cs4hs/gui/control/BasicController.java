package cs4hs.gui.control;

import cs4hs.gui.control.managers.contentmanager.*;
import cs4hs.gui.control.managers.logicmanager.BasicLogicManager;
import cs4hs.gui.control.managers.menumanager.*;
import cs4hs.gui.control.managers.viewmanager.BasicViewManager;
import cs4hs.tool.Tool;

/**
 * This controller uses all the basic content, logic, menu and view managers.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class BasicController extends Controller {

	public BasicController() {
		super(new BasicViewManager(), new BasicContentManager(), new BasicMenuManager());
		this.setLogicManager(new BasicLogicManager(new Tool(), this));
	}
}
