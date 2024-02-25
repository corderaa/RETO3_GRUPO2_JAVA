package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.bbdd.pojo.Ticket;

/**
 * javadoc
 * 
 */
public class CheckoutPanel {

	private String ICON_PATH = ".\\img\\logo_transparente_negro_mini.png";

	private JPanel checkoutPanel;
	private JTable tableSummary;
	private JTextField textBuyTotal;
	private JTextField textFieldAfterDiscounts;
	private JLabel lblBuyingSummary;
	private JLabel lblBuyingSummaryBackground;
	private JScrollPane scrollPaneSummary;
	private JLabel lblBuyTotal;
	private JLabel lblAfterDisconts;
	private JLabel lblBuyTotalBackground;
	private JLabel lblAfterDiscontsBackground;
	private JButton btnCancel;
	private JButton btnBuy;
	private JButton btnKeepBuying;
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

		lblBuyingSummaryBackground = new JLabel("R E S U M E N   D E   C O M P R A");
		lblBuyingSummaryBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyingSummaryBackground.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 32));
		lblBuyingSummaryBackground.setBounds(243, 35, 731, 116);
		checkoutPanel.add(lblBuyingSummaryBackground);

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

		lblBuyTotalBackground = new JLabel("TOTAL:");
		lblBuyTotalBackground.setForeground(new Color(0, 0, 0));
		lblBuyTotalBackground.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblBuyTotalBackground.setBounds(1072, 583, 67, 43);
		checkoutPanel.add(lblBuyTotalBackground);

		lblAfterDiscontsBackground = new JLabel("DESPUES DE DESCUENTOS:");
		lblAfterDiscontsBackground.setForeground(new Color(0, 0, 0));
		lblAfterDiscontsBackground.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblAfterDiscontsBackground.setBounds(908, 637, 231, 43);
		checkoutPanel.add(lblAfterDiscontsBackground);

		btnCancel = new JButton("CANCELAR");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(243, 572, 212, 71);
		checkoutPanel.add(btnCancel);

		btnKeepBuying = new JButton("SEGUIR COMPRANDO");

		btnKeepBuying.setBackground(Color.WHITE);
		btnKeepBuying.setBounds(465, 572, 212, 71);
		checkoutPanel.add(btnKeepBuying);

		btnBuy = new JButton("PAGAR");
		btnBuy.setBackground(new Color(255, 255, 255));
		btnBuy.setBounds(21, 572, 212, 71);
		checkoutPanel.add(btnBuy);

		btnKeepBuying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(true);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);

			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmCancel()) {
					paneles.get(0).setVisible(false);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(false);
					paneles.get(3).setVisible(true);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(false);

					selectedSessions.clear();
					modelSummary.setRowCount(0);
					textBuyTotal.setText("0.00");
					textFieldAfterDiscounts.setText("0.00");
				}
			}
		});

		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmBuy()) {
					paneles.get(0).setVisible(false);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(true);
					paneles.get(3).setVisible(false);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(false);

					selectedSessions.get(0)
							.setTicketPrice(Double.parseDouble(formatPrices(textFieldAfterDiscounts.getText())));
				}
			}
		});

		checkoutPanel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				modelSummary.setRowCount(0);
				displaySelectedSessionsOnTable(selectedSessions);
				setBuyTotal();
				setDiscountedTotal(textBuyTotal, modelSummary);
			}
		});

	}

	public JPanel getCheckoutPanel() {
		return checkoutPanel;
	}

	/**
	 * Displays the selectedSessions on the table
	 * 
	 * @param modelSummary
	 * @param selectedSessions
	 */
	private void displaySelectedSessionsOnTable(ArrayList<Ticket> selectedSessions) {
		if (selectedSessions != null) {
			for (int i = 0; i < selectedSessions.size(); i++) {
				if (selectedSessions.get(i) != null) {

					String moviePrice = Double
							.toString(selectedSessions.get(i).getSession().getMovie().getMoviePrice());

					String[] row = { selectedSessions.get(i).getSession().getMovie().getMovieName(),
							selectedSessions.get(i).getSession().getSessionDate().toString(),
							selectedSessions.get(i).getSession().getCinema().getCinemaName(),
							selectedSessions.get(i).getSession().getRoom().getRoomName(), moviePrice };

					modelSummary.addRow(row);
				}
			}
		}
	}

	/**
	 * Calculates the sum of all prices
	 * 
	 * @param tableSummary
	 * @return the total price
	 */
	private String calculateBuyTotal(JTable tableSummary) {
		String ret = null;
		DecimalFormat df = new DecimalFormat("0.00");
		double doubleNumer = 0.00;
		for (int i = 0; i < modelSummary.getRowCount(); i++) {
			String num = (String) modelSummary.getValueAt(i, 4);
			doubleNumer += Double.parseDouble(num);
		}
		ret = df.format(doubleNumer);

		return ret;
	}

	/**
	 * Sets the calculated buy total in the panel
	 */
	private void setBuyTotal() {
		String buyTotal = calculateBuyTotal(tableSummary);
		textBuyTotal.setText(buyTotal);

	}

	/**
	 * Calculates the discounted total
	 * 
	 * @param textBuyTotal
	 * @param modelSummary
	 * @return the discounted price
	 */
	private String calculateDiscountedTotal(JTextField textBuyTotal, DefaultTableModel modelSummary) {
		String ret = formatPrices(textBuyTotal.getText());
		DecimalFormat decimalFormat = new DecimalFormat("0.00");

		Double discountedTotal = Double.parseDouble(ret);

		if (modelSummary.getRowCount() != 1) {

			discountedTotal = discountedTotal - (discountedTotal * tableSummary.getRowCount() / 10);

			ret = decimalFormat.format(discountedTotal);
		}

		ret = decimalFormat.format(discountedTotal);

		return ret;
	}

	/**
	 * Sets the discounted total in the panel
	 * 
	 * @param textBuyTotal
	 * @param modelSummary
	 */
	private void setDiscountedTotal(JTextField textBuyTotal, DefaultTableModel modelSummary) {
		try {
			String discountedTotal = calculateDiscountedTotal(textBuyTotal, modelSummary);
			textFieldAfterDiscounts.setText(discountedTotal);
		} catch (Exception e) {
			// it shouldn't do anything
		}
	}

	/**
	 * Ask the user a if he wants to proceed to the buy
	 * 
	 * @return true if yes, false if anything else
	 */
	private boolean confirmBuy() {

		ImageIcon image = new ImageIcon(ICON_PATH);

		int res = JOptionPane.showOptionDialog(new JFrame(), "Estas seguro que quieres proceder al pago?",
				"Cine Elorrieta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

		return res == JOptionPane.YES_OPTION ? true : false;
	}

	/**
	 * Ask the user a if he wants to proceed to the calcelation of the buy
	 * 
	 * @return true if yes, false if anything else
	 */
	private boolean confirmCancel() {
		ImageIcon image = new ImageIcon(ICON_PATH);

		int res = JOptionPane.showOptionDialog(new JFrame(), "Estas seguro que quieres cancelar la compra?",
				"Cine Elorrieta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

		return res == JOptionPane.YES_OPTION ? true : false;
	}

	/**
	 * formats prices, getting rid of the , and changing it for a .
	 * 
	 * @param priceText
	 * @return formated number
	 */
	private String formatPrices(String priceText) {
		String ret = null;
		try {
			String[] retSlited = priceText.split(",");
			ret = retSlited[0] + "." + retSlited[1];
		} catch (Exception e) {
			// it shouldn't do anything
		}
		return ret;
	}
}