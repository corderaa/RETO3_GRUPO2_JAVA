package cinesElorrieta.views;

import java.util.ArrayList;

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
public class MainFrame {

	private JFrame frame;
	private ArrayList<JPanel> paneles = null;

	private MoviesPanel moviesPanel;
	private CinemasPanel cinemasPanel;
	private WelcomePanel welcomePanel;
	private CheckoutPanel checkoutPanel;

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
		
		RegisterPanel gestorpanel1 = new RegisterPanel(paneles);
		JPanel panelRegister = gestorpanel1.getPanel();
		panelRegister.setVisible(true);
		
		paneles.add(panelRegister);
		frame.getContentPane().add(panelRegister);
		
		LoginPanel gestorpanel2 = new LoginPanel(paneles);
		JPanel loginPanel = gestorpanel2.getLoginPanel();
		loginPanel.setVisible(false);

		paneles.add(loginPanel);
		frame.getContentPane().add(loginPanel);
		
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		
		// WelcomePanel welcomePanel = new WelcomePanel();
		// contentPane.add(welcomePanel.getWelcomePanel());

		/*RegisterPanel registerPanel = new RegisterPanel();
		contentPane.add(registerPanel.getRegisterPanel());

		LoginPanel loginPanel = new LoginPanel();
		contentPane.add(loginPanel.getLoginPanel());
		 */
	}
}
