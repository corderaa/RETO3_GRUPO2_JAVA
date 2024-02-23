package cinesElorrieta.views.panels;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton btnClose;
	private JLabel lblDni = null;
	private JTextField textFieldDNI = null;
	private JCheckBox chckbxMale = null;
	private JCheckBox chckbxFemale = null;
	private JTextField textFieldLasName = null;
	private JLabel lblApellidos = null;
	private JPanel panelFormularioFondo = null;

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
		chckbxMale.setSelected(true);
		panelFormulario.add(chckbxMale);

		chckbxFemale = new JCheckBox("Mujer");
		chckbxFemale.setBounds(146, 424, 97, 23);
		chckbxMale.setSelected(false);
		panelFormulario.add(chckbxFemale);

		textFieldLasName = new JTextField();
		textFieldLasName.setColumns(10);
		textFieldLasName.setBounds(247, 119, 131, 40);
		panelFormulario.add(textFieldLasName);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblApellidos.setBounds(247, 89, 76, 20);
		panelFormulario.add(lblApellidos);

		panelFormularioFondo = new JPanel();
		panelFormularioFondo.setLayout(null);
		panelFormularioFondo.setBackground(Color.BLACK);
		panelFormularioFondo.setBounds(423, 71, 436, 529);
		panelRegister.add(panelFormularioFondo);

		btnClose = new JButton("CERRAR");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(204, 51, 51));
		btnClose.setBounds(1135, 686, 89, 44);
		panelRegister.add(btnClose);

		chckbxFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxMale.setSelected(false);
			}
		});

		chckbxMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxFemale.setSelected(false);
			}
		});

		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				paneles.get(0).setVisible(true);
				paneles.get(1).setVisible(false);
			}
		});

		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (fieldsFilled() && fieldValid()) {
					UserManager userManager = new UserManager();
					User newUser = new User();

					newUser.setUserName(textFieldUser.getText().trim());
					newUser.setUserLasName(textFieldLasName.getText());
					newUser.setUserId(textFieldDNI.getText().trim());
					newUser.setUserEmail(textFieldMail.getText().trim());
					newUser.setUserPassword(textFieldPassword.getText().trim());
					newUser.setUserSex(chckbxMale.isSelected() == true ? "hombre" : "mujer");

					userManager.insertUser(newUser);

					JOptionPane.showMessageDialog(null, "Usuario registrado con exito");

					clearFields();

					paneles.get(0).setVisible(true);
					paneles.get(1).setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Err, Algun campo esta vacio o es incorrecto");
				}

			}

			public boolean fieldsFilled() {
				return !textFieldDNI.getText().isEmpty() || !textFieldLasName.getText().isEmpty()
						|| !textFieldMail.getText().isEmpty() || !textFieldPassword.getText().isEmpty()
						|| !textFieldUser.getText().isEmpty();

			}

			public boolean fieldValid() {
				return !(textFieldDNI.getText().length() > 9) || !(textFieldLasName.getText().length() > 50
						|| !(textFieldMail.getText().length() > 100) || !(textFieldPassword.getText().length() > 100)
						|| !(textFieldUser.getText().length() > 30));
			}
		});

	}

	/**
	 * Clears the fields of the form
	 */
	private void clearFields() {
		textFieldLasName.setText("");
		textFieldMail.setText("");
		textFieldPassword.setText("");
		textFieldUser.setText("");
		textFieldDNI.setText("");

		chckbxFemale.setSelected(false);
		chckbxMale.setSelected(false);
	}

	public JPanel getPanel() {
		return panelRegister;
	}

}
