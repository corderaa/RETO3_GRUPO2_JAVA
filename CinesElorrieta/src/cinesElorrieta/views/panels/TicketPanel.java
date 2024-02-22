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

	/**
	 * 
	 * @param panels
	 * @param selectedSessions arraylist with all selected data
	 */
	public TicketPanel(ArrayList<JPanel> panels, ArrayList<Ticket> selectedSessions) {

		ticketPanel = new JPanel();
		ticketPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		ticketPanel.setBackground(new Color(255, 66, 70));
		ticketPanel.setBounds(0, 0, 1234, 741);

		ticketPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("GRACIAS POR SU COMPRA");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(360, 287, 529, 29);
		ticketPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("GRACIAS POR SU COMPRA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblNewLabel_1.setBounds(360, 287, 539, 29);
		ticketPanel.add(lblNewLabel_1);

		JButton btnSaveTicket = new JButton("Guardar ticket");
		btnSaveTicket.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				ArrayList<Ticket> tickets = new ArrayList<Ticket>();
				FilesManager gestor = new FilesManager();
				gestor.insertTicketIntoFile(selectedSessions);
				TicketManager ticketManager = new TicketManager();
				int lastId = ticketManager.getLastTicketId();
				System.out.println(lastId);
				Ticket newTicket = null;

				for (int i = 0; i < selectedSessions.size(); i++) {

					lastId++;
					System.out.println(lastId);
					newTicket = new Ticket();

					newTicket.setTickedId(lastId);
					System.out.println(lastId);
					newTicket.setTicketPrice(selectedSessions.get(0).getTicketPrice());
					newTicket.setTicketBuyDate(selectedSessions.get(i).getTicketBuyDate());
					newTicket.setTicketDate(selectedSessions.get(i).getTicketDate());
					newTicket.setSession(selectedSessions.get(i).getSession());
					newTicket.setUser(selectedSessions.get(i).getUser());

					ticketManager.insertTicket(newTicket);
				}

				JOptionPane.showMessageDialog(btnSaveTicket, "Ticket guardado correctamente");
				tickets.clear();
				panels.get(5).setVisible(false);
				panels.get(0).setVisible(true);
			}

		});
		btnSaveTicket.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnSaveTicket.setBounds(533, 362, 167, 69);
		ticketPanel.add(btnSaveTicket);
		
		JLabel imgElorrieta = new JLabel("l");
		imgElorrieta.setIcon(new ImageIcon("D:\\Workspace\\RETO3_GRUPO2_JAVA\\CinesElorrieta\\src\\cineElorrietapng.png"));
		imgElorrieta.setBounds(517, 442, 201, 81);
		ticketPanel.add(imgElorrieta);
	}

	public JPanel getTicketPanel() {
		return ticketPanel;
	}
}
