package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePanel {

	private JPanel welcomePanel;

	public JPanel getWelcomePanel() {

		JLabel lblTitulo;
		JLabel lblTitulo_fondo;
		JLabel lblNewLabel;
		JLabel lblNewLabel_fondo;
		JButton btnNewButton;

		welcomePanel = new JPanel();
		welcomePanel.setBackground(new Color(255, 66, 70));
		welcomePanel.setBounds(0, 0, 1234, 741);
		welcomePanel.setLayout(null);

		lblTitulo = new JLabel("BIENVENIDO A CINES ELORRIETA");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(255, 249, 723, 130);
		welcomePanel.add(lblTitulo);

		lblTitulo_fondo = new JLabel("BIENVENIDO A CINES ELORRIETA");
		lblTitulo_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_fondo.setForeground(new Color(0, 0, 0));
		lblTitulo_fondo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 40));
		lblTitulo_fondo.setBounds(250, 249, 723, 130);
		welcomePanel.add(lblTitulo_fondo);

		lblNewLabel = new JLabel("PULSA DONDE QUIERAS PARA CONTINUAR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(379, 347, 476, 51);
		welcomePanel.add(lblNewLabel);

		lblNewLabel_fondo = new JLabel("PULSA DONDE QUIERAS PARA CONTINUAR");
		lblNewLabel_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_fondo.setForeground(Color.BLACK);
		lblNewLabel_fondo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_fondo.setBounds(379, 347, 473, 51);
		welcomePanel.add(lblNewLabel_fondo);

		btnNewButton = new JButton("login");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(0, 718, 64, 23);
		welcomePanel.add(btnNewButton);

		welcomePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		return welcomePanel;
	}

}
