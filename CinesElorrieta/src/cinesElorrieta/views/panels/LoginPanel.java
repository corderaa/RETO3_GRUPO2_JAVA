package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cinesElorrieta.bbdd.managers.UserManager;
import cinesElorrieta.bbdd.pojo.Ticket;
import cinesElorrieta.bbdd.pojo.User;

public class LoginPanel {

	private JPanel loginPanel = null;
	private JTextField textFieldMail = null;
	private JTextField textFieldPassword = null;
	private JPanel panelForm = null;
	private JLabel lblTitle = null;
	private JLabel lblMain = null;
	private JLabel lblPassword = null;
	private JButton btnLogin = null;
	private JButton btnClose = null;
	private JButton btnRegister = null;
	private JPanel panelFormBackground = null;

	public LoginPanel(ArrayList<JPanel> paneles, ArrayList<Ticket> selectedSessions) {

		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255, 66, 70));
		loginPanel.setBounds(0, 0, 1234, 741);
		loginPanel.setLayout(null);

		panelForm = new JPanel();
		panelForm.setBounds(394, 102, 426, 522);
		loginPanel.add(panelForm);
		panelForm.setLayout(null);

		lblTitle = new JLabel("I N I C I A R  S E S I O N");
		lblTitle.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(53, 59, 320, 57);
		panelForm.add(lblTitle);

		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(47, 197, 331, 40);
		panelForm.add(textFieldMail);

		lblMain = new JLabel("Correo:");
		lblMain.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblMain.setBounds(47, 166, 76, 20);
		panelForm.add(lblMain);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(47, 296, 331, 40);
		panelForm.add(textFieldPassword);

		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblPassword.setBounds(47, 265, 115, 20);
		panelForm.add(lblPassword);

		btnRegister = new JButton("REGISTRATE SI NO TIENES CUENTA");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(255, 51, 51));
		btnRegister.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnRegister.setBounds(47, 434, 331, 57);
		panelForm.add(btnRegister);

		btnLogin = new JButton("ENTRAR");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(255, 51, 51));
		btnLogin.setBounds(47, 366, 331, 57);
		panelForm.add(btnLogin);

		panelFormBackground = new JPanel();
		panelFormBackground.setLayout(null);
		panelFormBackground.setBackground(Color.BLACK);
		panelFormBackground.setBounds(423, 71, 436, 529);
		loginPanel.add(panelFormBackground);

		btnClose = new JButton("CERRAR");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(204, 51, 51));
		btnClose.setBounds(1135, 686, 89, 44);
		loginPanel.add(btnClose);

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextFields(textFieldMail, textFieldPassword);
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);
			}
		});

		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextFields(textFieldMail, textFieldPassword);
				selectedSessions.clear();
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(false);
				paneles.get(3).setVisible(false);
				paneles.get(4).setVisible(false);
				paneles.get(5).setVisible(false);

			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (null != new UserManager().getUser(textFieldMail.getText(), textFieldPassword.getText())) {
					JOptionPane.showMessageDialog(null, "Bienvenido:" + textFieldMail.getText());
					User loggedUser = new UserManager().getUser(textFieldMail.getText(), textFieldPassword.getText());

					for (int i = 0; i < selectedSessions.size(); i++) {
						selectedSessions.get(i).setUser(loggedUser);
					}

					clearTextFields(textFieldMail, textFieldPassword);
					paneles.get(0).setVisible(false);
					paneles.get(1).setVisible(false);
					paneles.get(2).setVisible(false);
					paneles.get(3).setVisible(false);
					paneles.get(4).setVisible(false);
					paneles.get(5).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
					textFieldPassword.setText(null);
				}
			}
		});
	}

	/**
	 * Clears the text fields
	 * 
	 * @param textFieldMail
	 * @param textFieldPassword
	 */
	private void clearTextFields(JTextField textFieldMail, JTextField textFieldPassword) {
		textFieldMail.setText(null);
		textFieldPassword.setText(null);
	}

	public JPanel getLoginPanel() {
		return loginPanel;
	}
}
