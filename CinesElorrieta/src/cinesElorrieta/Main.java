package cinesElorrieta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cinesElorrieta.bbdd.utils.DBUtils;
import cinesElorrieta.views.MainFrame;

/**
 * Main de la clase
 */
public class Main {

	public static void main(String[] args) {
		if (new Main().isDataBaseValid()) {
			new MainFrame().run();
		}

		// si = new Main().isDataBaseValid() ? new MainFrame().run() : null);
	}

	private boolean isDataBaseValid() {
		boolean ret = false;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			ret = connection.isValid(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Err, Fallo al conectarse a la BD");
		}

		return ret;
	}
}