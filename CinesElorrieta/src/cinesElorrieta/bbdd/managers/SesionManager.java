package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cinesElorrieta.bbdd.pojo.Movie;
import cinesElorrieta.bbdd.pojo.Session;
import cinesElorrieta.bbdd.utils.DBUtils;

/**
 * Manager of the table t_sesion. It contains all the methods for that table.
 */
public class SesionManager {

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
	public ArrayList<Session> getAllMoviesFromSessionContainingCinema(String cinemaId) {
		ArrayList<Session> ret = null;

		String sql = "SELECT * FROM t_session AS s JOIN t_movie m ON s.movieId = m.movieId WHERE s.cinemaId = "
				+ cinemaId;

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

				int sessionIdAdd = resultSet.getInt("sessionId");
				String sessionDateTimeAdd = resultSet.getString("sessionDateTime");
				Movie movieAdd = new Movie();
				movieAdd.setMovieId(resultSet.getInt("movieId"));
				movieAdd.setMovieDuration(resultSet.getString("movieDuration"));
				movieAdd.setMovieKind(resultSet.getString("movieGenre"));
				movieAdd.setMovieName(resultSet.getString("movieName"));

				moviesFromCinemaAdd.setMovie(movieAdd);
				moviesFromCinemaAdd.setSessionID(sessionIdAdd);
				moviesFromCinemaAdd.setSessionDate(sessionDateTimeAdd);

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
}
