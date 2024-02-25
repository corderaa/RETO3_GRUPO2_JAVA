package cinesElorrieta;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cinesElorrieta.bbdd.utils.DBUtils;
import cinesElorrieta.views.MainFrame;

/**
 * Main de la clase
 */
public class Main {

	/**
	 * Verifies if the database is Up then if true it starts the program, if false
	 * it doesn't.
	 * 
	 * @return true or false
	 */
	private boolean isDataBaseValid() {
		boolean ret = false;
		try {
			ret = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS).isValid(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Err, Fallo al conectarse a la BD");
		}
		return ret;
	}

	public static void main(String[] args) {
		Main main = new Main();
		if (main.isDataBaseValid()) {
			new MainFrame();
		}
	}
}