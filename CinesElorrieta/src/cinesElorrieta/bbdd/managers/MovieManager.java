package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cinesElorrieta.bbdd.pojo.Movie;
import cinesElorrieta.bbdd.utils.DBUtils;

/**
 * Manager of the table t_movie. It contains all the methods for that table.
 */
public class MovieManager {

	/**
	 * Gets all the movies from a selected cinema
	 * 
	 * @param cinemaId The selected Cinema
	 * @return The ArrayList of Movies
	 */
	public ArrayList<Movie> getAllMoviesFromCinema(String cinemaId) {
		ArrayList<Movie> ret = null;
		Movie movie = null;

		String sql = "SELECT DISTINCT m.movieId ,m.movieName, m.movieDuration, m.movieGenre FROM t_session AS s JOIN t_movie m ON s.movieId = m.movieId WHERE s.cinemaId = "
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

				if (null == ret)
					ret = new ArrayList<Movie>();

				movie = new Movie();

				int movieId = resultSet.getInt("movieId");
				Timestamp movieDuration = resultSet.getTimestamp("movieDuration");
				String movieGenre = resultSet.getString("movieGenre");
				String movieName = resultSet.getString("movieName");

				movie.setMovieId(movieId);
				movie.setMovieDuration(movieDuration);
				movie.setMovieKind(movieGenre);
				movie.setMovieName(movieName);

				ret.add(movie);
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
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {

			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {

			}
		}
		return ret;
	}
}