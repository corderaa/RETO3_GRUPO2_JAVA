package cinesElorrieta.views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cinesElorrieta.views.panels.CheckoutPanel;
import cinesElorrieta.views.panels.CinemasPanel;
import cinesElorrieta.views.panels.LoginPanel;

import cinesElorrieta.views.panels.RegisterPanel;
import cinesElorrieta.views.panels.WelcomePanel;

/**
 * The main JFrame
 */
public class MainFrame {

	private JFrame frame;
	private ArrayList<JPanel> panels = null;

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

		panels = new ArrayList<JPanel>();

		// Panel 0
		WelcomePanel gestorpanel0 = new WelcomePanel(panels);
		JPanel welcomePanel = gestorpanel0.getPanel();
		welcomePanel.setVisible(true);

		panels.add(welcomePanel);
		frame.getContentPane().add(welcomePanel);

		// Panel 1
		RegisterPanel gestorpanel1 = new RegisterPanel(panels);
		JPanel panelRegister = gestorpanel1.getPanel();
		panelRegister.setVisible(false);

		panels.add(panelRegister);
		frame.getContentPane().add(panelRegister);

		// Panel 2
		LoginPanel gestorpanel2 = new LoginPanel(panels);
		JPanel loginPanel = gestorpanel2.getLoginPanel();
		loginPanel.setVisible(false);

		panels.add(loginPanel);
		frame.getContentPane().add(loginPanel);

		// Panel 3
		CinemasPanel gestorpanel3 = new CinemasPanel(panels);
		JPanel cinemasPanel = gestorpanel3.getCinemasPanel();
		cinemasPanel.setVisible(false);

		panels.add(cinemasPanel);
		frame.getContentPane().add(cinemasPanel);

		// Panel 4
		CheckoutPanel gestorpanel4 = new CheckoutPanel(panels, gestorpanel3.getSelectedSessions());
		JPanel checkoutPanel = gestorpanel4.getCheckoutPanel();
		checkoutPanel.setVisible(false);

		panels.add(checkoutPanel);
		frame.getContentPane().add(checkoutPanel);
	}

	public ArrayList<JPanel> getPanels() {
		return panels;
	}
}
