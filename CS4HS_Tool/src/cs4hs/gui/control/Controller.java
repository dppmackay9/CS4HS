package cs4hs.gui.control;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cs4hs.Main;
import cs4hs.assets.Assets;
import cs4hs.gui.util.ComponentFactory;
import cs4hs.gui.util.DialogFactory;
import cs4hs.tool.Tool;
import cs4hs.tool.nodes.FNode;
import cs4hs.tool.util.SignalException;
import cs4hs.tool.util.ToolException;
import cs4hs.tool.values.AppInfo;
import cs4hs.tool.values.Options;
import cs4hs.tool.values.Values;
import cs4hs.tool.values.Values.Speed;

/**
 * Controls all the different views of the program and calls methods from the
 * Tool class.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Controller extends JFrame implements Runnable {

	/**
	 * Views are essentially JPanels with different content. This abstract class
	 * should be extended by other classes.
	 */
	public static abstract class View extends JPanel {
		protected Controller controller;

		public View(Controller controller) {
			this.controller = controller;
			this.setFocusable(false);
			initialise();
		}

		public Controller getController() {
			return controller;
		}

		/**
		 * Adds components to the view or performs special actions on creation.
		 */
		public abstract void initialise();

		/**
		 * Gives the focus of the key listener to the appropriate component.
		 */
		public abstract void setFocus();

		/**
		 * Updates any components inside the View when any data changed in the
		 * Model
		 * 
		 * @throws SignalException
		 */
		public abstract void update() throws SignalException;

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(600, 600);
		}
	}

	private View[] views;
	private Thread updater;
	private Tool tool;
	private int cur;
	private int prev;

	public Controller() {
		super(String.format("CS4HS Tool v%.2f", Main.VERSION));
		initialise();
	}

	// Getters for Views

	public int getPrev() {
		return prev;
	}

	// View Manipulaton Methods

	/**
	 * Changes view on the specified index. Should be within the boundaries of
	 * the view, otherwise it exits out.
	 * 
	 * @param index
	 */
	public void changeView(int index) {
		if (index < 0 || index >= views.length) {
			return;
		}
		if (views[index] == null) {
			return;
		}
		// Record the previous index
		this.prev = this.cur;
		this.cur = index;
		// Remove and replace the view
		getContentPane().removeAll();
		getContentPane().add(views[cur]);
		// Setting the focus allows event listeners to be activated
		views[index].repaint();
		views[index].setFocus();
		// Redraw the whole frame
		revalidate();
	}

	// Methods for Views to Use

	public void doAlgorithm(String algorithmStr, String dataStr, int item) throws SignalException {
		Values.Algorithm algorithm = determineAlgorithm(algorithmStr);
		if (algorithm == null) {
			return;
		}
		List<Integer> data = Assets.getDataList(dataStr);
		tool.performAlgorithm(algorithm, item, data);
		views[cur].update();
	}

	/**
	 * Retrieves the current function node in the tool
	 * 
	 * @return
	 * @throws ToolException
	 * @throws SignalException
	 */
	public FNode getCurNode() throws SignalException {
		try {
			return tool.getCurNode();
		} catch (ToolException e) {
			DialogFactory.showError(this, e.getMessage());
			return null;
		}
	}

	/**
	 * Moves the cursor forward. If no steps are performed, it displays a
	 * JDialog error box and returns null.
	 * 
	 * @return
	 * @throws SignalException
	 */
	public void doStep() throws SignalException {
		tool.step();
		views[cur].update();
	}

	/**
	 * Moves the cursor back. If no steps are performed, it displays a JDialog
	 * error box and returns null.
	 * 
	 * @return
	 * @throws SignalException
	 */
	public void doUndo() throws SignalException {
		tool.undo();
		views[cur].update();
	}

	/**
	 * Activates an updater thread which updates the current view of the
	 * controller.
	 */
	public void doRun() {
		if (updater == null) {
			updater = new Thread(this);
			updater.start();
		}
	}

	/**
	 * Skips to the very end of the algorithm
	 */
	public void doSkip() {
		stop();
		tool.skip();
		try {
			views[cur].update();
		} catch (SignalException e) {
		}
	}

	// Thread Methods

	/**
	 * Stops the updater from running
	 */
	public void stop() {
		updater = null;
		try {
			views[cur].update();
		} catch (SignalException e) {
		}
	}

	/**
	 * Steps through the algorithm and display the data.
	 */
	@Override
	public void run() {
		while (updater != null) {
			try {
				doStep();
				views[cur].update();
			} catch (SignalException e) {
				break;
			}
			try {
				Thread.sleep(Options.RUN_SPEED);
			} catch (InterruptedException e) {
				break;
			}
		}
		updater = null;
	}

	// Helper Methods

	/**
	 * Returns the appropriate algorithm enumeration based on the algorithm
	 * string. Returns null if it does not exist.
	 * 
	 * @param algorithmStr
	 * @return
	 */
	private Values.Algorithm determineAlgorithm(String algorithmStr) {
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

	// Variable Initialisation

	private void initialise() {
		initialiseVars();
		initialiseGUI();
	}

	private void initialiseVars() {
		this.tool = new Tool();
		this.views = ComponentFactory.createViews(this);
		this.cur = 0;
		this.prev = 0;

	}

	// ============= GUI INITIALISATION BELOW =======================

	// Options Menu
	private JMenuItem safety; // safety mode option
	private JMenuItem speed; // speed of the run algorithm
	private JMenuItem about; // information about the program

	private void initialiseGUI() {
		initialiseMenu();
		initialiseContent();
		initialiseListeners();
	}

	private void initialiseContent() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int result = DialogFactory.showConfirm(Controller.this, "Are you sure you want to quit?");
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		getContentPane().add(views[cur]);
		pack();
		setResizable(false);
		setVisible(true);
	}

	private void initialiseMenu() {
		// Create Menu Items
		safety = new JMenuItem(String.format("Toggle Safety %s", Options.SAFETY_MODE ? "Off" : "On"));
		speed = new JMenuItem("Set Speed");
		about = new JMenuItem("About");
		// Make Options Menu
		JMenu options = new JMenu("Options");
		JMenu help = new JMenu("Help");
		// Add components to the menu
		options.add(safety);
		options.add(speed);
		help.add(about);
		// Put everything together in menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(options);
		menuBar.add(help);
		this.setJMenuBar(menuBar);
	}

	private void initialiseListeners() {
		safety.addActionListener(e -> {
			// Change Options Variable
			Options.SAFETY_MODE = !Options.SAFETY_MODE;
			// Change Text of Safety
			safety.setText(String.format("Toggle Safety %s", Options.SAFETY_MODE ? "Off" : "On"));
		});
		speed.addActionListener(e -> {
			Speed speed = (Speed) JOptionPane.showInputDialog(this, "Select run speed", "", JOptionPane.PLAIN_MESSAGE,
					null, Speed.values(), Speed.FAST);
			if (speed == Speed.VERY_SLOW) {
				Options.RUN_SPEED = Values.VERY_SLOW;
			} else if (speed == Speed.MEDIUM) {
				Options.RUN_SPEED = Values.MEDIUM;
			} else if (speed == Speed.SLOW) {
				Options.RUN_SPEED = Values.SLOW;
			} else {
				Options.RUN_SPEED = Values.FAST;
			}
		});
		about.addActionListener(e -> {
			DialogFactory.showMessage(this, AppInfo.ABOUT);
		});
	}
}
