package cs4hs.gui.control.managers.contentmanager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import cs4hs.gui.control.Controller;
import cs4hs.gui.util.factories.DialogFactory;

/**
 * This class provides the base implementation for giving the controller
 * properties.
 * 
 * @author Chris
 */
public class BasicContentManager extends ContentManager {

	@Override
	public void initialiseContent(Controller frame) {
		setCloseOperation(frame);
		frame.getContentPane().add(frame.getViewManager().getCurrentView());
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	protected void setCloseOperation(Controller frame) {
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				int result = DialogFactory.showConfirm(frame, "Are you sure you want to quit?");
				if(result == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
	}
}
