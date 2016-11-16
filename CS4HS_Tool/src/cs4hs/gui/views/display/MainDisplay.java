package cs4hs.gui.views.display;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cs4hs.assets.Assets;
import cs4hs.gui.control.Controller.View;
import cs4hs.gui.util.ComponentFactory;
import cs4hs.gui.views.panels.DataPanel;
import cs4hs.tool.options.Options;
import cs4hs.tool.util.SignalException;

/**
 * This is the display which contains a panel for controlling which algorithm is
 * selected and which data to display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class MainDisplay extends Display {

	private JComboBox<String> algorithmsBox;
	private JComboBox<String> dataBox;

	private JButton stepBtn;
	private JButton stopBtn;
	private JButton runBtn;
	private JButton skipBtn;
	private JButton undoBtn;

	private DataPanel data;

	public MainDisplay(View parent) {
		super(parent);
	}

	@Override
	public JPanel createControl() {
		initialiseComponents();
		// Create the two control panels
		JPanel btnControl = createButtonControl();
		JPanel boxControl = createBoxControl();
		// Set up the panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		// Put everything together
		panel.add(boxControl);
		panel.add(btnControl);
		return panel;
	}

	@Override
	public JPanel createBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addActionListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() throws SignalException {
		data.update(parent.getController().getCurNode());
	}

	private JPanel createBoxControl() {
		// Initialise panels for JComboBoxes
		JPanel algoPane = createComponentPane(algorithmsBox, "Algorithm");
		JPanel dataPane = createComponentPane(dataBox, "Data");
		// Set up panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(0, 2));
		// Put everything together
		panel.add(dataPane);
		panel.add(algoPane);
		return panel;
	}

	private JPanel createButtonControl() {
		// Create button panels
		JPanel stepPane = createComponentPane(stepBtn, "Step");
		JPanel undoPane = createComponentPane(undoBtn, "Undo");
		JPanel runPane = createComponentPane(runBtn, "Run");
		JPanel stopPane = createComponentPane(stopBtn, "Stop");
		JPanel skipPane = createComponentPane(skipBtn, "Skip");
		// Set up panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(0, 5));
		// Put everything together
		panel.add(stepPane);
		panel.add(undoPane);
		panel.add(runPane);
		panel.add(stopPane);
		panel.add(skipPane);
		return panel;
	}

	private void initialiseComponents() {
		// initialise buttons
		stepBtn = ComponentFactory.createButton(Assets.getStepImage());
		undoBtn = ComponentFactory.createButton(Assets.getUndoImage());
		runBtn = ComponentFactory.createButton(Assets.getRunImage());
		stopBtn = ComponentFactory.createButton(Assets.getStopImage());
		skipBtn = ComponentFactory.createButton(Assets.getSkipImage());
		// initialise combo boxes
		algorithmsBox = ComponentFactory.createStringCombo(Options.getAlgorithms());
		dataBox = ComponentFactory.createStringCombo(Options.DATA);
	}
}
