package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.bbdd.pojo.Ticket;

public class CheckoutPanel {

	private JPanel checkoutPanel;
	private JTable tableSummary;
	private JTextField textBuyTotal;
	private JTextField textFieldAfterDiscounts;
	private JLabel lblBuyingSummary;
	private JLabel lblBuyingSummary_Background;
	private JScrollPane scrollPaneSummary;
	private JLabel lblBuyTotal;
	private JLabel lblAfterDisconts;
	private JLabel lblBuyTotal_Background;
	private JLabel lblAfterDisconts_Background;
	private JButton btnCancel;
	private JButton btnBuy;
	private DefaultTableModel modelSummary;

	public CheckoutPanel(ArrayList<JPanel> paneles, ArrayList<Ticket> selectedSessions) {

		checkoutPanel = new JPanel();
		checkoutPanel.setBackground(new Color(255, 66, 70));
		checkoutPanel.setBounds(0, 0, 1234, 741);
		checkoutPanel.setLayout(null);

		lblBuyingSummary = new JLabel("R E S U M E N   D E   C O M P R A");
		lblBuyingSummary.setForeground(new Color(255, 255, 255));
		lblBuyingSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyingSummary.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
		lblBuyingSummary.setBounds(243, 35, 738, 116);
		checkoutPanel.add(lblBuyingSummary);

		lblBuyingSummary_Background = new JLabel("R E S U M E N   D E   C O M P R A");
		lblBuyingSummary_Background.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyingSummary_Background.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
		lblBuyingSummary_Background.setBounds(243, 35, 731, 116);
		checkoutPanel.add(lblBuyingSummary_Background);

		scrollPaneSummary = new JScrollPane();
		scrollPaneSummary.setBounds(21, 162, 1192, 390);
		checkoutPanel.add(scrollPaneSummary);

		modelSummary = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		modelSummary.addColumn("NOMBRE DE LA PELICULA");
		modelSummary.addColumn("FECHA DE LA EMISION");
		modelSummary.addColumn("NOMBRE DEL CINE");
		modelSummary.addColumn("NOMBRE DE LA SALA");
		modelSummary.addColumn("PRECIO DE LA PELICULA");

		tableSummary = new JTable(modelSummary);
		scrollPaneSummary.setViewportView(tableSummary);

		lblBuyTotal = new JLabel("TOTAL:");
		lblBuyTotal.setForeground(new Color(255, 255, 255));
		lblBuyTotal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblBuyTotal.setBounds(1074, 583, 67, 43);
		checkoutPanel.add(lblBuyTotal);

		textBuyTotal = new JTextField();
		textBuyTotal.setBounds(1151, 580, 59, 46);
		checkoutPanel.add(textBuyTotal);
		textBuyTotal.setColumns(10);
		textBuyTotal.setText("0.00");
		textBuyTotal.setEditable(false);

		lblAfterDisconts = new JLabel("DESPUES DE DESCUENTOS:");
		lblAfterDisconts.setForeground(Color.WHITE);
		lblAfterDisconts.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblAfterDisconts.setBounds(910, 637, 231, 43);
		checkoutPanel.add(lblAfterDisconts);

		textFieldAfterDiscounts = new JTextField();
		textFieldAfterDiscounts.setColumns(10);
		textFieldAfterDiscounts.setBounds(1151, 637, 59, 46);
		checkoutPanel.add(textFieldAfterDiscounts);
		textFieldAfterDiscounts.setText("0.00");
		textFieldAfterDiscounts.setEditable(false);

		lblBuyTotal_Background = new JLabel("TOTAL:");
		lblBuyTotal_Background.setForeground(new Color(0, 0, 0));
		lblBuyTotal_Background.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblBuyTotal_Background.setBounds(1072, 583, 67, 43);
		checkoutPanel.add(lblBuyTotal_Background);

		lblAfterDisconts_Background = new JLabel("DESPUES DE DESCUENTOS:");
		lblAfterDisconts_Background.setForeground(new Color(0, 0, 0));
		lblAfterDisconts_Background.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblAfterDisconts_Background.setBounds(908, 637, 231, 43);
		checkoutPanel.add(lblAfterDisconts_Background);

		btnCancel = new JButton("CANCELAR");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(243, 572, 212, 71);
		checkoutPanel.add(btnCancel);

		btnBuy = new JButton("PAGAR");
		btnBuy.setBackground(new Color(255, 255, 255));
		btnBuy.setBounds(21, 572, 212, 71);
		checkoutPanel.add(btnBuy);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(false);
				paneles.get(3).setVisible(true);
				selectedSessions.clear();
				modelSummary.setRowCount(0);
				textBuyTotal.setText("0.00");
				textFieldAfterDiscounts.setText("0.00");
			}
		});

		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(true);

			}

		});

		checkoutPanel.addComponentListener(new ComponentAdapter() {
			public void componentHidden(ComponentEvent e) {
			}

			public void componentShown(ComponentEvent e) {
				displaySelectedSessionsOnTable(modelSummary, selectedSessions);
				setBuyTotal();
				setDiscountedTotal(textBuyTotal, modelSummary, selectedSessions);
			}
		});

	}

	public JPanel getCheckoutPanel() {
		return checkoutPanel;
	}

	private void displaySelectedSessionsOnTable(DefaultTableModel modelSummary, ArrayList<Ticket> selectedSessions) {
		if (selectedSessions != null) {
			for (int i = 0; i < selectedSessions.size(); i++) {
				if (selectedSessions.get(i) != null) {

					String moviePrice = Double
							.toString(selectedSessions.get(i).getSession().getMovie().getMoviePrice());

					String[] row = { selectedSessions.get(i).getSession().getMovie().getMovieName(),
							selectedSessions.get(i).getSession().getSessionDate(),
							selectedSessions.get(i).getSession().getCinema().getCinemaName(),
							selectedSessions.get(i).getSession().getRoom().getRoomName(), moviePrice };

					modelSummary.addRow(row);
				}
			}
		}
	}

	private String getBuyTotal(JTable tableSummary) {
		String ret = null;

		double d = 0.00;
		for (int i = 0; i < modelSummary.getRowCount(); i++) {
			String n = (String) modelSummary.getValueAt(i, 4);

			d += Double.parseDouble(n);
		}

		ret = Double.toString(d);

		return ret;
	}

	private void setBuyTotal() {
		String buyTotal = getBuyTotal(tableSummary);
		textBuyTotal.setText(buyTotal);

	}

	private String getDiscountedTotal(JTextField textBuyTotal, DefaultTableModel modelSummary) {
		String ret = textBuyTotal.getText().trim();
		if (tableSummary.getRowCount() != 1) {
			double n = 0.00;

			n = Double.parseDouble(ret);

			double discountedTotalDouble = 0.00;
			discountedTotalDouble = n - (n * tableSummary.getRowCount() / 10);

			ret = Double.toString(discountedTotalDouble);
		}

		return ret;
	}

	private void setDiscountedTotal(JTextField textBuyTotal, DefaultTableModel modelSummary,
			ArrayList<Ticket> selectedSessions) {
		String discountedTotal = getDiscountedTotal(textBuyTotal, modelSummary);
		textFieldAfterDiscounts.setText(discountedTotal);
		selectedSessions.get(0).setTicketPrice(Double.parseDouble(textFieldAfterDiscounts.getText()));
	}
}