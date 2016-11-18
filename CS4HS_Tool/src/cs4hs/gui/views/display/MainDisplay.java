package cs4hs.gui.views.display;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import cs4hs.assets.Assets;
import cs4hs.gui.control.Controller.View;
import cs4hs.gui.util.ComponentFactory;
import cs4hs.gui.util.DialogFactory;
import cs4hs.gui.views.panels.DataPanel;
import cs4hs.tool.util.SignalException;
import cs4hs.tool.values.Options;

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
	private JTextField itemField;

	private JButton execBtn;
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
		JPanel boxControl = createInputPanel();
		// Set up the panel
		JPanel panel = new JPanel();
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		Border titleBorder = BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Control Panel"),
				blackLine);
		panel.setBorder(titleBorder);
		panel.setLayout(new GridLayout(2, 0));
		// Put everything together
		panel.add(boxControl);
		panel.add(btnControl);
		return panel;
	}

	@Override
	public JPanel createBody() {
		// Initialise variables
		data = new DataPanel(parent);
		// Create Panel
		data.setBorder(new EmptyBorder(5, 5, 5, 5)); // padding
		return data;
	}

	@Override
	public void addActionListeners() {
		execBtn.addActionListener(e -> {
			// Retrieve the selected values
			String algorithm = (String) algorithmsBox.getSelectedItem();
			String dataStr = (String) dataBox.getSelectedItem();
			int item = getItem();
			try {
				parent.getController().doAlgorithm(algorithm, dataStr, item);
			} catch (SignalException e1) {
				DialogFactory.showMessage(parent.getController(), e1.getMessage());
			}
		});

		stepBtn.addActionListener(e -> {
			try {
				parent.getController().doStep();
			} catch (SignalException e1) {
				DialogFactory.showMessage(parent.getController(), e1.getMessage());
			}
		});
		stopBtn.addActionListener(e -> {
			Options.IS_RUNNING = false;
			parent.getController().stop();
		});
		runBtn.addActionListener(e -> {
			Options.IS_RUNNING = true;
			parent.getController().doRun();
		});
		skipBtn.addActionListener(e -> {
			parent.getController().doSkip();
		});
		undoBtn.addActionListener(e -> {
			try {
				parent.getController().doUndo();
			} catch (SignalException e1) {
				DialogFactory.showMessage(parent.getController(), e1.getMessage());
			}
		});
	}

	@Override
	public void update() throws SignalException {
		data.update(parent.getController().getCurNode());
		data.repaint();
	}

	// GUI Initialisation Methods

	private JPanel createInputPanel() {
		// Initialise panels for JComboBoxes
		JPanel algoPane = createComponentPane(algorithmsBox, "Algorithm");
		JPanel dataPane = createComponentPane(dataBox, "Data");
		JPanel itemPane = createComponentPane(itemField, "Item");
		// Set up panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(0, 3));
		// Put everything together
		panel.add(dataPane);
		panel.add(algoPane);
		panel.add(itemPane);
		return panel;
	}

	private JPanel createButtonControl() {
		// Create button panels
		JPanel execPane = createComponentPane(execBtn, "Execute");
		JPanel stepPane = createComponentPane(stepBtn, "Step");
		JPanel undoPane = createComponentPane(undoBtn, "Undo");
		JPanel runPane = createComponentPane(runBtn, "Run");
		JPanel stopPane = createComponentPane(stopBtn, "Stop");
		JPanel skipPane = createComponentPane(skipBtn, "Skip");
		// Set up panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(0, 6));
		// Put everything together
		panel.add(execPane);
		panel.add(stepPane);
		panel.add(undoPane);
		panel.add(runPane);
		panel.add(stopPane);
		panel.add(skipPane);
		return panel;
	}

	private void initialiseComponents() {
		// initialise buttons
		execBtn = ComponentFactory.createButton(Assets.getExecImage());
		stepBtn = ComponentFactory.createButton(Assets.getStepImage());
		undoBtn = ComponentFactory.createButton(Assets.getUndoImage());
		runBtn = ComponentFactory.createButton(Assets.getRunImage());
		stopBtn = ComponentFactory.createButton(Assets.getStopImage());
		skipBtn = ComponentFactory.createButton(Assets.getSkipImage());
		// initialise combo boxes
		algorithmsBox = ComponentFactory.createStringCombo(Options.getAlgorithms());
		dataBox = ComponentFactory.createStringCombo(Options.DATA);
		// Initialise JTextFields
		itemField = ComponentFactory.createTextField();
		itemField.setText("0");
	}

	// Helper Methods

	/**
	 * Gets the integer value inside the items field. It ensures that a value is
	 * always returned. If the item field is blank, it returns a '0' by default.
	 * 
	 * @return
	 */
	private int getItem() {
		String item = itemField.getText();
		if (item == "") {
			item = "0";
			itemField.setText(item);
		}
		return Integer.parseInt(item);
	}
}
