package cinesElorrieta.views.panels;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import cinesElorrieta.bbdd.managers.UserManager;
import cinesElorrieta.bbdd.pojo.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class RegisterPanel {

	private JPanel panelRegister = null;
	private JPanel panelFormulario = null;
	private JLabel lblTitulo = null;
	private JTextField textFieldUser = null;
	private JLabel lblUsuario = null;
	private JTextField textFieldMail = null;
	private JLabel lblCorreo = null;
	private JTextField textFieldPassword = null;
	private JLabel lblContrasea = null;
	private JButton btnRegistrarse = null;
	private JLabel lblDni = null;
	private JTextField textFieldDNI = null;
	private JCheckBox chckbxMale = null;
	private JCheckBox chckbxFemale = null;
	private JTextField textFieldLasName = null;
	private JLabel lblApellidos = null;
	private JPanel panelFormulario_fondo = null;

	public RegisterPanel(ArrayList<JPanel> paneles) {

		panelRegister = new JPanel();
		panelRegister.setBackground(new Color(255, 66, 70));
		panelRegister.setBounds(0, 0, 1234, 741);
		panelRegister.setLayout(null);

		panelFormulario = new JPanel();
		panelFormulario.setBounds(394, 102, 426, 522);
		panelRegister.add(panelFormulario);
		panelFormulario.setLayout(null);

		lblTitulo = new JLabel("R E G I S T R A R S E");
		lblTitulo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(79, 30, 267, 57);
		panelFormulario.add(lblTitulo);

		textFieldUser = new JTextField();
		textFieldUser.setBounds(47, 119, 131, 40);
		panelFormulario.add(textFieldUser);
		textFieldUser.setColumns(10);

		lblUsuario = new JLabel("Nombre:");
		lblUsuario.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblUsuario.setBounds(47, 89, 76, 20);
		panelFormulario.add(lblUsuario);

		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(47, 291, 331, 40);
		panelFormulario.add(textFieldMail);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblCorreo.setBounds(47, 260, 76, 20);
		panelFormulario.add(lblCorreo);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(47, 370, 331, 40);
		panelFormulario.add(textFieldPassword);

		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblContrasea.setBounds(47, 342, 115, 20);
		panelFormulario.add(lblContrasea);

		btnRegistrarse = new JButton("ENTRAR");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(255, 51, 51));
		btnRegistrarse.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnRegistrarse.setBounds(47, 459, 331, 40);
		panelFormulario.add(btnRegistrarse);

		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblDni.setBounds(47, 178, 76, 20);
		panelFormulario.add(lblDni);

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(47, 209, 331, 40);
		panelFormulario.add(textFieldDNI);

		chckbxMale = new JCheckBox("Hombre");
		chckbxMale.setBounds(47, 424, 97, 23);
		panelFormulario.add(chckbxMale);

		chckbxFemale = new JCheckBox("Mujer");
		chckbxFemale.setBounds(146, 424, 97, 23);
		panelFormulario.add(chckbxFemale);

		textFieldLasName = new JTextField();
		textFieldLasName.setColumns(10);
		textFieldLasName.setBounds(247, 119, 131, 40);
		panelFormulario.add(textFieldLasName);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellidos.setBounds(247, 89, 76, 20);
		panelFormulario.add(lblApellidos);

		panelFormulario_fondo = new JPanel();
		panelFormulario_fondo.setLayout(null);
		panelFormulario_fondo.setBackground(Color.BLACK);
		panelFormulario_fondo.setBounds(423, 71, 436, 529);
		panelRegister.add(panelFormulario_fondo);

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManager userManager = new UserManager();
				User newUser = new User();

				newUser.setUserName(textFieldUser.getText().trim());
				newUser.setUserLasName(textFieldLasName.getText());
				newUser.setUserId(textFieldDNI.getText().trim());
				newUser.setUserEmail(textFieldMail.getText().trim());
				newUser.setUserPassword(textFieldPassword.getText().trim());
				newUser.setUserSex(getUserGenre());

				userManager.insertUser(newUser);

				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
		
			}

			/**
			 * Gets the selected GENDER of the user. Returns the appropriate STRING for the
			 * DB
			 * 
			 * @return
			 */

			public String getUserGenre() {

				if (chckbxMale.isSelected()) {
					return "hombre";
				} else if (chckbxFemale.isSelected()) {
					return "mujer";
				} else {
					return null;
				}
			}

		});

	}

	public JPanel getPanel() {

		return panelRegister;
	}
}
