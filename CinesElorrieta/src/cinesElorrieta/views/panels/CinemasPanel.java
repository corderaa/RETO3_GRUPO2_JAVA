package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.bbdd.managers.CinemaManager;
import cinesElorrieta.bbdd.managers.SesionManager;
import cinesElorrieta.bbdd.pojo.Cinema;
import cinesElorrieta.bbdd.pojo.Session;

public class CinemasPanel {

	private JPanel cinemasPanel;
	private JTable tableCinemas;
	private JTable tableMovies;
	private JScrollPane scrollPanePelis;
	private JLabel lblCines;
	private JLabel lblPEL;
	private JLabel lblCines_fondo;
	private JLabel lblCines_fondo_1;
	private JButton btnNewButton;
	private JButton btnFinalizar;
	private JScrollPane scrollPaneCinema;
	private DefaultTableModel cinemaModel;
	private DefaultTableModel modelMovies;
	private JButton btnSelect;

	public CinemasPanel(ArrayList<JPanel> paneles) {

		cinemasPanel = new JPanel();
		cinemasPanel.setBackground(new Color(255, 66, 70));
		cinemasPanel.setBounds(0, 0, 1234, 741);
		cinemasPanel.setLayout(null);

		lblCines = new JLabel("N U E S T R O S    C I N E S");
		lblCines.setForeground(new Color(255, 255, 255));
		lblCines.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblCines.setHorizontalAlignment(SwingConstants.CENTER);
		lblCines.setBounds(259, 11, 715, 93);
		cinemasPanel.add(lblCines);

		lblCines_fondo = new JLabel("N U E S T R O S    C I N E S");
		lblCines_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCines_fondo.setForeground(new Color(0, 0, 0));
		lblCines_fondo.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblCines_fondo.setBounds(264, 11, 695, 93);
		cinemasPanel.add(lblCines_fondo);

		btnNewButton = new JButton("CERRAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(204, 51, 51));
		btnNewButton.setBounds(1135, 686, 89, 44);
		cinemasPanel.add(btnNewButton);

		scrollPaneCinema = new JScrollPane();
		scrollPaneCinema.setBounds(78, 90, 1077, 93);
		cinemasPanel.add(scrollPaneCinema);

		cinemaModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		tableCinemas = new JTable(cinemaModel);

		cinemaModel.addColumn("Id Del Cine");
		cinemaModel.addColumn("Nombre Del Cine");
		cinemaModel.addColumn("Direccion");
		scrollPaneCinema.setViewportView(tableCinemas);

		displayCinemasTable(cinemaModel);

		btnSelect = new JButton("SELECCIONAR CINE");
		btnSelect.setBackground(new Color(255, 255, 255));
		btnSelect.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnSelect.setBounds(479, 194, 256, 44);
		cinemasPanel.add(btnSelect);

		scrollPanePelis = new JScrollPane();
		scrollPanePelis.setBounds(78, 330, 1077, 345);
		cinemasPanel.add(scrollPanePelis);

		modelMovies = new DefaultTableModel();
		modelMovies.addColumn("Nombre de la Pelicula");
		modelMovies.addColumn("Genero de la pelicula");
		modelMovies.addColumn("Duracion");
		modelMovies.addColumn("Fecha Emision");
		tableMovies = new JTable(modelMovies);
		scrollPanePelis.setViewportView(tableMovies);

		lblPEL = new JLabel("P E L I C U L A S   D I S P O N I B L E S");
		lblPEL.setHorizontalAlignment(SwingConstants.CENTER);
		lblPEL.setForeground(Color.WHITE);
		lblPEL.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblPEL.setBounds(259, 245, 715, 93);
		cinemasPanel.add(lblPEL);

		lblCines_fondo_1 = new JLabel("P E L I C U L A S   D I S P O N I B L E S");
		lblCines_fondo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCines_fondo_1.setForeground(Color.BLACK);
		lblCines_fondo_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblCines_fondo_1.setBounds(264, 245, 695, 93);
		cinemasPanel.add(lblCines_fondo_1);

		btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnFinalizar.setBackground(Color.WHITE);
		btnFinalizar.setBounds(479, 686, 256, 44);
		cinemasPanel.add(btnFinalizar);

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selectedCinemaId = (String) cinemaModel.getValueAt(tableCinemas.getSelectedRow(), 0);

				displayMoviesPanel(modelMovies, selectedCinemaId);
			}
		});
	}

	public JPanel getCinemasPanel() {

		return cinemasPanel;
	}

	/**
	 * Displays in the table ROWS all the data about the Cinemas taken from the DB.
	 * 
	 * @param cinemaModel
	 */
	private void displayCinemasTable(DefaultTableModel cinemaModel) {

		CinemaManager cinemaManager = new CinemaManager();

		ArrayList<Cinema> cinemaList = cinemaManager.getAllCinemas();

		for (int i = 0; i < cinemaList.size(); i++) {
			if (cinemaList.get(i) != null) {

				String idCinema = Integer.toString(cinemaList.get(i).getCinemaId());
				String[] row = { idCinema, cinemaList.get(i).getCinemaName(), cinemaList.get(i).getCinemaAddress() };

				cinemaModel.addRow(row);
			}
		}
	}

	private void displayMoviesPanel(DefaultTableModel modelMovies, String cinemaId) {

		SesionManager sessionManager = new SesionManager();

		ArrayList<Session> moviesFromSessions = sessionManager.getAllMoviesFromSessionContainingCinema(cinemaId);

		for (int i = 0; i < moviesFromSessions.size(); i++) {
			if (null != moviesFromSessions.get(i)) {
				String[] row = { moviesFromSessions.get(i).getMovie().getMovieName(),
						moviesFromSessions.get(i).getMovie().getMovieKind(),
						moviesFromSessions.get(i).getMovie().getMovieDuration(),
						moviesFromSessions.get(i).getSessionDate() };

				modelMovies.addRow(row);
			}
		}
	}
}