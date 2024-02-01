package cinesElorrieta.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cinesElorrieta.views.panels.CheckoutPanel;
import cinesElorrieta.views.panels.CinemasPanel;
import cinesElorrieta.views.panels.LoginPanel;
import cinesElorrieta.views.panels.MoviesPanel;
import cinesElorrieta.views.panels.RegisterPanel;
import cinesElorrieta.views.panels.WelcomePanel;

/**
 * The main JFrame
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MoviesPanel moviesPanel;
	private CinemasPanel cinemasPanel;
	private WelcomePanel welcomePanel;
	private CheckoutPanel checkoutPanel;

	/**
	 * Initializes the frame
	 */
	public void run() {
		try {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Defines the components of the main JFrame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		RegisterPanel registerPanel = new RegisterPanel();
		contentPane.add(registerPanel.getRegisterPanel());

		// LoginPanel loginPanel = new LoginPanel();
		// contentPane.add(loginPanel.getLoginPanel());
	}
}
