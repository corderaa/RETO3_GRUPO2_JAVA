package cinesElorrieta.views.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import cinesElorrieta.bbdd.pojo.Ticket;

public class CinemasPanel {

	private String ICON_PATH = ".\\img\\logo_transparente_negro_mini.png";

	private JPanel cinemasPanel;
	private JTable tableCinemas;
	private JTable tableMovies;
	private JTable tableTime;
	private JScrollPane scrollPaneMovies;
	private JLabel lblCinemas;
	private JLabel lblMovies;
	private JLabel lblCinemas_Background;
	private JLabel lblMovies_Background;
	private JButton btnClose;
	private JButton btnSelectSession;
	private JButton btnFinalize;
	private JScrollPane scrollPaneCinema;
	private JScrollPane scrollPaneTime;
	private DefaultTableModel cinemaModel;
	private DefaultTableModel modelMovies;
	private DefaultTableModel timeModel;
	private JButton btnSelect;

	public CinemasPanel(ArrayList<JPanel> paneles, ArrayList<Ticket> selectedSessions) {

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
		tableCinemas.removeColumn(tableCinemas.getColumn("Id Del Cine"));
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
		tableMovies.removeColumn(tableMovies.getColumn("Id de la Pelicula"));
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

		btnFinalize = new JButton("RESUMEN DE COMPRA");
		btnFinalize.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnFinalize.setBackground(Color.WHITE);
		btnFinalize.setBounds(334, 684, 256, 44);
		cinemasPanel.add(btnFinalize);

		scrollPaneTime = new JScrollPane();
		scrollPaneTime.setBounds(823, 330, 332, 345);
		cinemasPanel.add(scrollPaneTime);

		timeModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		timeModel.addColumn("Horario Emision");
		tableTime = new JTable(timeModel);
		scrollPaneTime.setViewportView(tableTime);

		btnSelectSession = new JButton("SELECCIONAR SESION");
		btnSelectSession.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 15));
		btnSelectSession.setBackground(Color.WHITE);
		btnSelectSession.setBounds(598, 684, 256, 44);
		cinemasPanel.add(btnSelectSession);

		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmCancel()) {
					selectedSessions.clear();
					paneles.get(3).setVisible(false);
					paneles.get(0).setVisible(true);
				}
			}
		});

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedCinemaId = null;

				try {
					selectedCinemaId = (String) cinemaModel.getValueAt(tableCinemas.getSelectedRow(), 0);
					modelMovies.setRowCount(0);
					displayMoviesTable(modelMovies, selectedCinemaId);
				} catch (Exception d) {
					JOptionPane.showMessageDialog(null, "Err, Selecciona un cine porfavor");// no deveria salir
				}
			}
		});

		btnFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!selectedSessions.isEmpty()) {
					paneles.get(4).setVisible(true);
					paneles.get(3).setVisible(false);
					modelMovies.setRowCount(0);
					timeModel.setRowCount(0);
				} else {
					JOptionPane.showMessageDialog(null, "Err, Todavia no hay sesiones seleccionadas");
				}
			}
		});

		tableMovies.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					timeModel.setRowCount(0);
					displayMoviesTime(timeModel, tableCinemas, cinemaModel, tableMovies, modelMovies, tableCinemas,
							timeModel);
				}
			}
		});

		tableCinemas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				modelMovies.setRowCount(0);
				timeModel.setRowCount(0);
			}
		});

		btnSelectSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SesionManager sesionManager = new SesionManager();

				if (confirmSelection()) {
					try {
						String selectedCinemaId = getSelectedCinemaId(cinemaModel, tableCinemas);
						String selectedMovieId = getSelectedMovieId(tableMovies, modelMovies);
						String selectedDateTime = null;

						if (tableTime.getSelectedRowCount() != 0) {
							selectedDateTime = tableTime.getValueAt(tableTime.getSelectedRow(), 0).toString() + " "
									+ tableTime.getValueAt(tableTime.getSelectedRow(), 0).toString();
						}

						Ticket selectedSession = new Ticket();
						selectedSession.setSession(sesionManager.getTheDataFromSelectedSession(selectedCinemaId,
								selectedMovieId, selectedDateTime));

						if (!(selectedSessions.size() > 4)) {
							selectedSessions.add(selectedSession);
						} else {
							JOptionPane.showMessageDialog(null, "Err, Has llegado al limite de peliculas por añadir");
						}

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
								"Err, No hay sessiones para seleccionar con los datos elejidos");
					}
				}
				modelMovies.setRowCount(0);
				timeModel.setRowCount(0);
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

		if (null != cinemaList) {
			for (int i = 0; i < cinemaList.size(); i++) {
				if (cinemaList.get(i) != null) {

					String idCinema = Integer.toString(cinemaList.get(i).getCinemaId());
					String[] row = { idCinema, cinemaList.get(i).getCinemaName(),
							cinemaList.get(i).getCinemaAddress() };

					cinemaModel.addRow(row);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Err, No hay Cines");
		}
	}

	/**
	 * Displays in the table rows all the data about the Movies taken from the DB.
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
							moviesFromSessions.get(i).getMovieKind(),
							formatDate(moviesFromSessions.get(i).getMovieDuration())[1] };
					modelMovies.addRow(row);
				}
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

		ArrayList<Session> dateTimesFromSessions = sesionManager.getAllTheDateTimesFromMovie(selectedCinemaId,
				selectedMovieId);

		for (int i = 0; i < dateTimesFromSessions.size(); i++) {
			if (null != dateTimesFromSessions.get(i)) {
				String[] row = { formatDate(dateTimesFromSessions.get(i).getSessionDate())[3] };

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
		if (tableCinemas.getRowCount() > 0)
			ret = (String) cinemaModel.getValueAt(tableCinemas.getSelectedRow(), 0);
		return ret;
	}

	/**
	 * Gets the mmovieId that is selected at the moment.
	 * 
	 * @param moviesTable
	 * @param modelMovies
	 * @return
	 * 
	 */
	private String getSelectedMovieId(JTable moviesTable, DefaultTableModel modelMovies) {
		String ret = null;
		if (moviesTable.getRowCount() > 0)
			ret = (String) modelMovies.getValueAt(moviesTable.getSelectedRow(), 0);

		return ret;
	}

	/**
	 * 
	 * @param i
	 * @param dateToFormat
	 * @return
	 */
	public String[] formatDate(Date dateToFormat) {

		String[] ret = dateToFormat.toString().split(" ");

		return ret;
	}

	/**
	 * Asks the user if they wan't to close the selection, then it clears all data
	 * 
	 * @return true if yes, false if no
	 */
	private boolean confirmCancel() {

		ImageIcon image = new ImageIcon(ICON_PATH);

		int res = JOptionPane.showOptionDialog(new JFrame(),
				"Estas seguro que quieres cerrar la seleccion? [TODOS LOS DATOS SE PERDERAN]", "Cine Elorrieta",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image, new Object[] { "Si", "No" },
				JOptionPane.YES_OPTION);

		return res == JOptionPane.YES_OPTION ? true : false;
	}

	/**
	 * Asks the user if they wan't to close the selection, then it clears all data
	 * 
	 * @return true if yes, false if no
	 */
	private boolean confirmSelection() {

		ImageIcon image = new ImageIcon(ICON_PATH);

		int res = JOptionPane.showOptionDialog(new JFrame(), "Estas seguro de que quieres seleccionar esta sesion?",
				"Cine Elorrieta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

		return res == JOptionPane.YES_OPTION ? true : false;
	}

	public JPanel getCinemasPanel() {
		return cinemasPanel;
	}
}