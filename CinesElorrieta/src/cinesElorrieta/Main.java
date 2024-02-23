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