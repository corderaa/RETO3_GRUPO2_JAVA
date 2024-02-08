package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import cinesElorrieta.bbdd.managers.CinemaManager;
import cinesElorrieta.bbdd.managers.MovieManager;
import cinesElorrieta.bbdd.managers.SesionManager;
import cinesElorrieta.bbdd.pojo.Cinema;
import cinesElorrieta.bbdd.pojo.Movie;
import cinesElorrieta.bbdd.pojo.Session;

public class CinemasPanel {

	private JPanel cinemasPanel;
	public ArrayList<Session> selectedSessions = new ArrayList<Session>();

	private JTable tableCinemas;
	private JTable tableMovies;
	private JTable tableDate;
	private JTable tableTableTime;
	private JScrollPane scrollPaneMovies;
	private JLabel lblCinemas;
	private JLabel lblMovies;
	private JLabel lblCinemas_Background;
	private JLabel lblMovies_Background;
	private JButton btnClose;
	private JButton btnSelectSession;
	private JButton btnFinalize;
	private JScrollPane scrollPaneCinema;
	private JScrollPane scrollPaneDate;
	private JScrollPane scrollPaneTime;
	private DefaultTableModel cinemaModel;
	private DefaultTableModel modelMovies;
	private DefaultTableModel dateModel;
	private DefaultTableModel timeModel;
	private JButton btnSelect;

	public CinemasPanel(ArrayList<JPanel> paneles) {

		cinemasPanel = new JPanel();
		cinemasPanel.setBackground(new Color(255, 66, 70));
		cinemasPanel.setBounds(0, 0, 1234, 741);
		cinemasPanel.setLayout(null);

		lblCinemas = new JLabel("S E L E C C I O N   D E   S E S I O N E S");
		lblCinemas.setForeground(new Color(255, 255, 255));
		lblCinemas.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblCinemas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinemas.setBounds(259, 11, 715, 93);
		cinemasPanel.add(lblCinemas);

		lblCinemas_Background = new JLabel("S E L E C C I O N   D E   S E S I O N E S");
		lblCinemas_Background.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinemas_Background.setForeground(new Color(0, 0, 0));
		lblCinemas_Background.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblCinemas_Background.setBounds(264, 11, 695, 93);
		cinemasPanel.add(lblCinemas_Background);

		btnClose = new JButton("CERRAR");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(204, 51, 51));
		btnClose.setBounds(1135, 686, 89, 44);
		cinemasPanel.add(btnClose);

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

		scrollPaneMovies = new JScrollPane();
		scrollPaneMovies.setBounds(78, 330, 735, 345);
		cinemasPanel.add(scrollPaneMovies);

		modelMovies = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		modelMovies.addColumn("Id de la Pelicula");
		modelMovies.addColumn("Nombre de la Pelicula");
		modelMovies.addColumn("Genero de la pelicula");
		modelMovies.addColumn("Duracion");
		tableMovies = new JTable(modelMovies);
		scrollPaneMovies.setViewportView(tableMovies);

		lblMovies = new JLabel("P E L I C U L A S   D I S P O N I B L E S");
		lblMovies.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovies.setForeground(Color.WHITE);
		lblMovies.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblMovies.setBounds(259, 245, 715, 93);
		cinemasPanel.add(lblMovies);

		lblMovies_Background = new JLabel("P E L I C U L A S   D I S P O N I B L E S");
		lblMovies_Background.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovies_Background.setForeground(Color.BLACK);
		lblMovies_Background.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 40));
		lblMovies_Background.setBounds(264, 245, 695, 93);
		cinemasPanel.add(lblMovies_Background);

		btnFinalize = new JButton("FINALIZAR");
		btnFinalize.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnFinalize.setBackground(Color.WHITE);
		btnFinalize.setBounds(334, 684, 256, 44);
		cinemasPanel.add(btnFinalize);

		scrollPaneDate = new JScrollPane();
		scrollPaneDate.setBounds(823, 330, 332, 158);
		cinemasPanel.add(scrollPaneDate);

		dateModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		dateModel.addColumn("Fecha Emision");
		tableDate = new JTable(dateModel);
		scrollPaneDate.setViewportView(tableDate);

		scrollPaneTime = new JScrollPane();
		scrollPaneTime.setBounds(823, 499, 332, 176);
		cinemasPanel.add(scrollPaneTime);

		timeModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		timeModel.addColumn("Horario Emision");
		tableTableTime = new JTable(timeModel);
		scrollPaneTime.setViewportView(tableTableTime);

		btnSelectSession = new JButton("SELECCIONAR SESION");
		btnSelectSession.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnSelectSession.setBackground(Color.WHITE);
		btnSelectSession.setBounds(598, 684, 256, 44);
		cinemasPanel.add(btnSelectSession);

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedCinemaId = null;

				try {
					selectedCinemaId = (String) cinemaModel.getValueAt(tableCinemas.getSelectedRow(), 0);

				} catch (Exception d) {
					System.err.println("Err, index para el numero de Rows"); // no deveria salir
				}

				modelMovies.setRowCount(0);
				displayMoviesTable(modelMovies, selectedCinemaId);
			}
		});

		btnFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paneles.get(4).setVisible(true);
				paneles.get(3).setVisible(false);
			}
		});

		tableMovies.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					dateModel.setRowCount(0);
					timeModel.setRowCount(0);
					displayMoviesDate(dateModel, tableCinemas, cinemaModel, tableMovies, modelMovies);
				}
			}
		});

		tableDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					timeModel.setRowCount(0);
					displayMoviesTime(timeModel, tableCinemas, cinemaModel, tableMovies, modelMovies, tableDate,
							dateModel);
				}
			}
		});

		tableCinemas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				modelMovies.setRowCount(0);
				dateModel.setRowCount(0);
				timeModel.setRowCount(0);
			}
		});

		btnSelectSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SesionManager sesionManager = new SesionManager();

				String selectedCinemaId = getSelectedCinemaId(cinemaModel, tableCinemas);
				String selectedMovieId = getSelectedMovieId(tableMovies, modelMovies);

				String selectedDateTime = tableDate.getValueAt(0, 0).toString() + " "
						+ tableTableTime.getValueAt(0, 0).toString();

				Session selectedSession = sesionManager.getTheDataFromSelectedSession(selectedCinemaId, selectedMovieId,
						selectedDateTime);

				int listSize = 0;
				listSize = selectedSessions.size();

				if (listSize >= 5) {
					selectedSessions.add(selectedSession);
				} else {
					JOptionPane.showMessageDialog(null,
							"Ya has llegado al numero maximo de peliculas que puedes seleccionar!!!");
				}
			}
		});
	}

	/**
	 * Displays in the table ROWS all the data about the Cinemas taken from the DB.
	 * 
	 * @param cinemaModel
	 */
	private void displayCinemasTable(DefaultTableModel cinemaModel) {

		CinemaManager cinemaManager = new CinemaManager();

		ArrayList<Cinema> cinemaList = cinemaManager.getAllCinemas();

		if (null == cinemaList) {
			JOptionPane.showMessageDialog(null, "Err, No hay Cines");
		} else {
			for (int i = 0; i < cinemaList.size(); i++) {
				if (cinemaList.get(i) != null) {

					String idCinema = Integer.toString(cinemaList.get(i).getCinemaId());
					String[] row = { idCinema, cinemaList.get(i).getCinemaName(),
							cinemaList.get(i).getCinemaAddress() };

					cinemaModel.addRow(row);
				}
			}
		}
	}

	/**
	 * // * Displays in the table rows all the data about the Movies taken from the
	 * DB.
	 * 
	 * @param modelMovies
	 * @param cinemaId
	 */
	private void displayMoviesTable(DefaultTableModel modelMovies, String cinemaId) {

		MovieManager movieManager = new MovieManager();

		ArrayList<Movie> moviesFromSessions = movieManager.getAllMoviesFromCinema(cinemaId);

		if (null == moviesFromSessions) {
			JOptionPane.showMessageDialog(null, "Err, No existen Sessiones para el Cine con la id: " + cinemaId);
		} else {
			for (int i = 0; i < moviesFromSessions.size(); i++) {
				if (null != moviesFromSessions.get(i)) {
					String movieId = Integer.toString(moviesFromSessions.get(i).getMovieId());
					String[] row = { movieId, moviesFromSessions.get(i).getMovieName(),
							moviesFromSessions.get(i).getMovieKind(), moviesFromSessions.get(i).getMovieDuration() };
					modelMovies.addRow(row);
				}
			}
		}
	}

	/**
	 * Displays in the table rows the date about the Movies taken from the DB.
	 * 
	 * @param moviesFromSessions
	 * @param dateModel
	 */
	private void displayMoviesDate(DefaultTableModel dateModel, JTable tableCinemas, DefaultTableModel cinemaModel,
			JTable moviesTable, DefaultTableModel modelMovies) {

		SesionManager sesionManager = new SesionManager();

		String selectedCinemaId = getSelectedCinemaId(cinemaModel, tableCinemas);
		String selectedMovieId = getSelectedMovieId(moviesTable, modelMovies);

		ArrayList<Session> dateTimesFromSessions = sesionManager.getAllTheDateTimesFromMovie(selectedCinemaId,
				selectedMovieId);

		for (int i = 0; i < dateTimesFromSessions.size(); i++) {
			if (null != dateTimesFromSessions.get(i)) {
				String[] dateTime = dateTimesFromSessions.get(i).getSessionDate().split(" ");
				String[] row = { dateTime[0] };

				dateModel.addRow(row);
			}
		}
	}

	/**
	 * Displays in the table rows the time about the DateTimes taken from the DB.
	 * 
	 * @param moviesFromSessions
	 * @param dateModel
	 */
	private void displayMoviesTime(DefaultTableModel timeModel, JTable tableCinemas, DefaultTableModel cinemaModel,
			JTable moviesTable, DefaultTableModel modelMovies, JTable tableDate, DefaultTableModel dateModel) {

		SesionManager sesionManager = new SesionManager();

		String selectedCinemaId = getSelectedCinemaId(cinemaModel, tableCinemas);
		String selectedMovieId = getSelectedMovieId(moviesTable, modelMovies);
		String selectedDateTime = getSelectedDateTime(tableDate, dateModel);

		ArrayList<Session> dateTimesFromSessions = sesionManager.getAllTheDateTimesFromMovie(selectedCinemaId,
				selectedMovieId);

		for (int i = 0; i < dateTimesFromSessions.size(); i++) {
			if (null != dateTimesFromSessions.get(i)
					&& dateTimesFromSessions.get(i).getSessionDate().contains(selectedDateTime)) {
				String[] dateTime = dateTimesFromSessions.get(i).getSessionDate().split(" ");
				String[] row = { dateTime[1] };

				timeModel.addRow(row);
			}
		}
	}

	/**
	 * Gets the cinemaId that is selected at the moment.
	 * 
	 * @param cinemaModel
	 * @param tableCinemas
	 * @return
	 */
	private String getSelectedCinemaId(DefaultTableModel cinemaModel, JTable tableCinemas) {
		String ret = null;
		try {
			ret = (String) cinemaModel.getValueAt(tableCinemas.getSelectedRow(), 0);

		} catch (Exception e) {
			System.err.println("Err, index para el numero de Rows"); // no deveria salir
		}

		return ret;
	}

	/**
	 * Gets the mmovieId that is selected at the moment.
	 * 
	 * @param moviesTable
	 * @param modelMovies
	 * @return
	 */
	private String getSelectedMovieId(JTable moviesTable, DefaultTableModel modelMovies) {
		String ret = null;
		try {
			ret = (String) modelMovies.getValueAt(moviesTable.getSelectedRow(), 0);
		} catch (Exception e) {
			System.err.println("Err, index para el numero de Rows"); // no deveria salir
		}

		return ret;
	}

	/**
	 * Gets the dateTime that is selected at the moment.
	 * 
	 * @param moviesTable
	 * @param modelMovies
	 * @return
	 */
	private String getSelectedDateTime(JTable dateTable, DefaultTableModel dateModel) {
		String ret = null;
		try {
			ret = (String) dateModel.getValueAt(dateTable.getSelectedRow(), 0);
		} catch (Exception e) {
			System.err.println("Err, index para el numero de Rows"); // no deveria salir
		}

		return ret;
	}

	public JPanel getCinemasPanel() {
		return cinemasPanel;
	}

	public ArrayList<Session> getSelectedSessions() {
		return selectedSessions;
	}
}