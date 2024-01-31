package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cinesElorrieta.bbdd.pojo.User;
import cinesElorrieta.bbdd.utils.DBUtils;

/**
 * Manager of the table t_User. It contains all the methods for that table.
 */
public class UserManager {

	/**
	 * Gets the User specified by the id
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		return null;
	}

	/**
	 * Gets all the Users from the table t_movie. Returns a LIST of Users.
	 * 
	 * @return
	 */
	public List<User> getAllUser() {
		return null;
	}

	public void insertUser(User newUser) {
		// La conexion con BBDD
		Connection connection = null;

		// Vamos a lanzar una sentencia SQL contra la BBDD
		Statement statement = null;

		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);

			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();

			// Montamos la SQL
			String sql = "insert into t_user (userDNI, userName, userSurname, userGender, userPassword, userMail) VALUES ('"
					+ newUser.getUserId() + "', '" + newUser.getUserName() + "', '" + newUser.getUserLasName() + "','"
					+ newUser.getUserSex() + "', '" + newUser.getUserPassword() + "', '" + newUser.getUserEmail()
					+ "')";

			// La ejecutamos...
			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
	}
}
