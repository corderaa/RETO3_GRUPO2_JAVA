package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cinesElorrieta.bbdd.pojo.Cinema;
import cinesElorrieta.bbdd.pojo.Movie;
import cinesElorrieta.bbdd.pojo.Room;
import cinesElorrieta.bbdd.pojo.Session;
import cinesElorrieta.bbdd.utils.DBUtils;
import cinesElorrieta.utils.Converter;

/**
 * Manager of the table t_sesion. It contains all the methods for that table.
 */
/**
 * Manager of the table t_sesion. It contains all the methods for that table.
 */
public class SesionManager {

	Converter converter = new Converter();

	/**
	 * Gets the Session specified by the id
	 * 
	 * @param id
	 * @return
	 */
	public Session getSession(int id) {
		return null;
	}

	/**
	 * Gets all the Sessions from the table t_movie. Returns a LIST of Sessions.
	 * 
	 * @return
	 */
	public List<Session> getAllSessions() {
		return null;
	}

	/**
	 * Gets all the Sessions from the table t_movie. Returns a LIST of Sessions.
	 * 
	 * @return
	 */
	public ArrayList<Session> getAllTheDateTimesFromMovie(String cinemaId, String movieId) {
		ArrayList<Session> ret = null;

		String sql = "SELECT DISTINCT s.sessionDateTime FROM t_session AS s JOIN t_movie m ON s.movieId = m.movieId WHERE s.cinemaId = "
				+ cinemaId + " and s.movieId = " + movieId + ";";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				if (null == ret) {
					ret = new ArrayList<Session>();
				}

				Session moviesFromCinemaAdd = new Session();

				Timestamp sessionDateTimeAdd = resultSet.getTimestamp("sessionDateTime");

				moviesFromCinemaAdd.setSessionDate(converter.convertTimeStampJavaDate(sessionDateTimeAdd));

				ret.add(moviesFromCinemaAdd);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}

	/**
	 * Gets all the Sessions from the table t_movie. Returns a LIST of Sessions.
	 * 
	 * @return
	 */
	public Session getTheDataFromSelectedSession(String cinemaId, String movieId, String dateTime) {
		Session ret = null;

		String[] splitedDateTime = dateTime.split(":");

		String sql = "SELECT DISTINCT m.movieName, m.movieDuration, s.sessionDateTime, c.cinemaName, c.cinemaAddress, h.hallName,m.moviePrice FROM t_session AS s JOIN t_movie m ON s.movieId = m.movieId JOIN t_cinema c ON s.cinemaId = c.cinemaId JOIN t_hall h ON s.hallId = h.hallId WHERE s.cinemaId = '"
				+ cinemaId + "' and s.movieId = '" + movieId + "' and hour(s.sessionDateTime) = '" + splitedDateTime[0]
				+ "' and minute(s.sessionDateTime) = '" + splitedDateTime[1] + "' and second(s.sessionDateTime) = '"
				+ splitedDateTime[2] + "' ;";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				ret = new Session();

				String movieName = resultSet.getString("movieName");
				Timestamp movieDuration = resultSet.getTimestamp("movieDuration");
				Timestamp datetimeAdd = resultSet.getTimestamp("sessionDateTime");
				String cinemaName = resultSet.getString("cinemaName");
				String cinemaAddress = resultSet.getString("cinemaAddress");
				String hallName = resultSet.getString("hallName");
				Double moviePrice = resultSet.getDouble("moviePrice");

				Movie movieAdd = new Movie();
				movieAdd.setMovieName(movieName);
				movieAdd.setMoviePrice(moviePrice);
				movieAdd.setMovieDuration(converter.convertTimeStampJavaDate(movieDuration));

				Cinema cinemaAdd = new Cinema();
				cinemaAdd.setCinemaName(cinemaName);
				cinemaAdd.setCinemaAddress(cinemaAddress);
				Room roomAdd = new Room();
				roomAdd.setRoomName(hallName);

				ret.setCinema(cinemaAdd);
				ret.setRoom(roomAdd);
				ret.setMovie(movieAdd);
				ret.setSessionDate(converter.convertTimeStampJavaDate(datetimeAdd));
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {

			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
			;
		}
		return ret;
	}
}