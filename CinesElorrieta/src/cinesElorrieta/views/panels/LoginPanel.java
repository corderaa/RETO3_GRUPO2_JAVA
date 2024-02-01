package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel {

	private JPanel loginPanel = null;

	public JPanel getLoginPanel() {

		JTextField textFieldMail;
		JTextField textFieldPassword;
		JPanel panelForm;
		JLabel lblTitle;
		JLabel lblMain;
		JLabel lblPassword;
		JButton btnLogin;
		JPanel panelForm_background;

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

		btnLogin = new JButton("ENTRAR");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 51, 51));
		btnLogin.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnLogin.setBounds(47, 409, 331, 57);
		panelForm.add(btnLogin);

		panelForm_background = new JPanel();
		panelForm_background.setLayout(null);
		panelForm_background.setBackground(Color.BLACK);
		panelForm_background.setBounds(423, 71, 436, 529);
		loginPanel.add(panelForm_background);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// codigo para cojer los datos del usuario
			}

			public boolean verifyUser() {
				// verificar que los datos estan correcto he iniciar sesion
				return false;
			}

		});

		return loginPanel;
	}
}
