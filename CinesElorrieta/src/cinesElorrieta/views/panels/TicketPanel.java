package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import cinesElorrieta.Files.FilesManager;
import cinesElorrieta.bbdd.managers.TicketManager;
import cinesElorrieta.bbdd.pojo.Ticket;
import javax.swing.ImageIcon;

public class TicketPanel {

	private JPanel ticketPanel;

	private static String ICON_PATH = ".\\img\\cineElorrietapng.png";

	public TicketPanel(ArrayList<JPanel> panels, ArrayList<Ticket> selectedSessions) {

		ticketPanel = new JPanel();
		ticketPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		ticketPanel.setBackground(new Color(255, 66, 70));
		ticketPanel.setBounds(0, 0, 1234, 741);

		ticketPanel.setLayout(null);

		JLabel lblThanksForBuying = new JLabel("GRACIAS POR SU COMPRA");
		lblThanksForBuying.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblThanksForBuying.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForBuying.setBounds(360, 287, 529, 29);
		ticketPanel.add(lblThanksForBuying);

		JLabel lblThanksForBuyingBackground = new JLabel("GRACIAS POR SU COMPRA");
		lblThanksForBuyingBackground.setForeground(new Color(255, 255, 255));
		lblThanksForBuyingBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForBuyingBackground.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblThanksForBuyingBackground.setBounds(360, 287, 539, 29);
		ticketPanel.add(lblThanksForBuyingBackground);

		JButton btnSaveTicket = new JButton("Guardar ticket");
		btnSaveTicket.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnSaveTicket.setBounds(533, 362, 167, 69);
		ticketPanel.add(btnSaveTicket);

		JLabel imgElorrieta = new JLabel("l");
		imgElorrieta.setIcon(new ImageIcon(ICON_PATH));
		imgElorrieta.setBounds(517, 442, 201, 81);
		ticketPanel.add(imgElorrieta);

		btnSaveTicket.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FilesManager gestor = new FilesManager();
				gestor.insertTicketIntoFile(selectedSessions);
				TicketManager ticketManager = new TicketManager();
				int lastId = ticketManager.getLastTicketId();
				Ticket newTicket = null;

				for (int i = 0; i < selectedSessions.size(); i++) {

					lastId++;
					newTicket = new Ticket();

					newTicket.setTickedId(lastId);
					newTicket.setTicketPrice(selectedSessions.get(0).getTicketPrice());
					newTicket.setTicketBuyDate(selectedSessions.get(i).getTicketBuyDate());
					newTicket.setTicketDate(selectedSessions.get(i).getTicketDate());
					newTicket.setSession(selectedSessions.get(i).getSession());
					newTicket.setUser(selectedSessions.get(i).getUser());

					ticketManager.insertTicket(newTicket);
				}

				JOptionPane.showMessageDialog(null, "Ticket guardado correctamente");

				panels.get(0).setVisible(true);
				panels.get(1).setVisible(false);
				panels.get(2).setVisible(false);
				panels.get(3).setVisible(false);
				panels.get(4).setVisible(false);
				panels.get(5).setVisible(false);
				selectedSessions.clear();
			}
		});
	}

	public JPanel getTicketPanel() {
		return ticketPanel;
	}
}
