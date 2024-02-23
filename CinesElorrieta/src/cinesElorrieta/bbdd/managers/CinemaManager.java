package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cinesElorrieta.bbdd.pojo.Cinema;
import cinesElorrieta.bbdd.utils.DBUtils;

/**
 * Manager of the table t_cines. It contains all the methods for that table.
 */
public class CinemaManager {

	/**
	 * Gets the cinema especified by the ID.
	 * 
	 * @param id
	 * @return
	 */
	public Cinema getCinema(int id) {

		Cinema ret = null;

		String sql = "SELECT * from t_cinema";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret && resultSet.getInt("cinemaId") == id) {
					ret = new Cinema();
				}

				int idAdd = resultSet.getInt("cinemaId");
				String nameAdd = resultSet.getString("cinemaName");
				String addressAdd = resultSet.getString("cinemaAddress");

				ret.setCinemaId(idAdd);
				ret.setCinemaName(nameAdd);
				ret.setCinemaAddress(addressAdd);
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

	/**
	 * Gets all cinemas of the table t_cines. Returns a LIST of cinemas.
	 * 
	 * @return
	 */
	public ArrayList<Cinema> getAllCinemas() {
		ArrayList<Cinema> ret = null;
		Cinema cinemaAdd = null;

		String sql = "SELECT * from t_cinema";

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
					ret = new ArrayList<Cinema>();
				}

				cinemaAdd = new Cinema();

				int idAdd = resultSet.getInt("cinemaId");
				String nameAdd = resultSet.getString("cinemaName");
				String addressAdd = resultSet.getString("cinemaAddress");

				cinemaAdd.setCinemaId(idAdd);
				cinemaAdd.setCinemaName(nameAdd);
				cinemaAdd.setCinemaAddress(addressAdd);

				ret.add(cinemaAdd);
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