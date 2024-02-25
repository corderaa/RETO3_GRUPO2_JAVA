package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

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
	 * @return Logged user
	 */
	public User getUser(String mail, String password) {
		User ret = null;

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "SELECT * FROM t_user WHERE userMail = ? AND userPassword = ?";

			statement = connection.prepareStatement(sql);
			statement.setString(1, mail);
			statement.setString(2, password);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {

				ret = new User();

				ret.setUserId(resultSet.getString("userDNI"));
				ret.setUserName(resultSet.getString("userName"));
				ret.setUserLasName(resultSet.getString("userSurname"));
				ret.setUserSex(resultSet.getString("userGender"));
				ret.setUserPassword(resultSet.getString("userPassword"));
				ret.setUserEmail(resultSet.getString("userMail"));
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
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
	 * Inserts the registered user into the DB
	 * 
	 * @param newUser reggistered user
	 */
	public void insertUser(User newUser) {
		Connection connection = null;

		Statement statement = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			String sql = "insert into t_user (userDNI, userName, userSurname, userGender, userPassword, userMail) VALUES ('"
					+ newUser.getUserId() + "', '" + newUser.getUserName() + "', '" + newUser.getUserLasName() + "','"
					+ newUser.getUserSex() + "', '" + newUser.getUserPassword() + "', '" + newUser.getUserEmail()
					+ "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Err, Algun dato introducido esta incorrecto");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Err, Algun dato introducido ya existe");
		} finally {
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
	}

}
