package cinesElorrieta.views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



import cinesElorrieta.views.panels.LoginPanel;

import cinesElorrieta.views.panels.RegisterPanel;
import cinesElorrieta.views.panels.WelcomePanel;

/**
 * The main JFrame
 */
public class MainFrame {

	private JFrame frame;
	private ArrayList<JPanel> paneles = null;

	/**
	 * Initializes the frame
	 */
	public void run() {
		try {
			new MainFrame().frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MainFrame() {
		initialize();
	}

	/**
	 * Defines the components of the main JFrame.
	 */
	public void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1250, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		paneles = new ArrayList<JPanel>();

		// Panel 0
		WelcomePanel gestorpanel0 = new WelcomePanel(paneles);
		JPanel welcomePanel = gestorpanel0.getPanel();
		welcomePanel.setVisible(true);

		paneles.add(welcomePanel);
		frame.getContentPane().add(welcomePanel);

		// Panel 1
		RegisterPanel gestorpanel1 = new RegisterPanel(paneles);
		JPanel panelRegister = gestorpanel1.getPanel();
		panelRegister.setVisible(false);

		paneles.add(panelRegister);
		frame.getContentPane().add(panelRegister);

		// Panel 2
		LoginPanel gestorpanel2 = new LoginPanel(paneles);
		JPanel loginPanel = gestorpanel2.getLoginPanel();
		loginPanel.setVisible(false);

		paneles.add(loginPanel);
		frame.getContentPane().add(loginPanel);

	}
}
