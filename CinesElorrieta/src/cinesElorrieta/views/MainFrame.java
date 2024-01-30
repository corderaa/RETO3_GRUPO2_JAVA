package cinesElorrieta.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cinesElorrieta.views.panels.CheckoutPanel;
import cinesElorrieta.views.panels.CinemasPanel;
import cinesElorrieta.views.panels.LoginPanel;
import cinesElorrieta.views.panels.MoviesPanel;
import cinesElorrieta.views.panels.WelcomePanel;

/**
 * The main JFrame
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MoviesPanel moviesPanel;
	private LoginPanel loginPanel;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		welcomePanel = new WelcomePanel();
		setContentPane(welcomePanel);

		cinemasPanel = new CinemasPanel();
		setContentPane(cinemasPanel);

		loginPanel = new LoginPanel();
		setContentPane(loginPanel);

		moviesPanel = new MoviesPanel();
		setContentPane(moviesPanel);

		checkoutPanel = new CheckoutPanel();
		setContentPane(checkoutPanel);
	}

}
