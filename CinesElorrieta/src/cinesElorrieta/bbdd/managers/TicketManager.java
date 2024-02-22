package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import cinesElorrieta.bbdd.pojo.Ticket;
import cinesElorrieta.bbdd.utils.DBUtils;
import cinesElorrieta.utils.Converter;

/**
 * Manager of the table t_Ticket. It contains all the methods for that table.
 */
public class TicketManager {

	/**
	 * Gets the Ticket specified by the id
	 * 
	 * @param id
	 * @return
	 */
	public Ticket getTicket(int id) {
		return null;
	}

	/**
	 * Gets all the Tickets from the table t_ticket. Returns a LIST of Tickets.
	 * 
	 * @return
	 */
	public List<Ticket> getAllTicket() {
		return null;
	}

	public void insertTicket(Ticket ticket) {
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

			Converter converter = new Converter();
			// Montamos la SQL
			System.out.println(converter.convertJavaDateToTimeStamp(ticket.getTicketBuyDate()));
			System.out.println(converter.convertJavaDateToTimeStamp(ticket.getTicketDate()));
			String sql = "insert into t_ticket (ticketId, ticketPrice, ticketPurchaseDate, ticketPrintDate, sessionId, userDNI) VALUES ("
					+ ticket.getTickedId() + ", " + ticket.getTicketPrice() + ", "
					+ converter.convertJavaDateToTimeStamp(ticket.getTicketBuyDate()) + ","
					+ converter.convertJavaDateToTimeStamp(ticket.getTicketDate()) + ", "
					+ ticket.getSession().getSessionID() + ", " + ticket.getUser().getUserId() + ")";

			// La ejecutamos...
			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Err, Algun dato introducido esta incorrecto");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Err, Algun dato introducido ya existe");
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

	public int getLastTicketId() {
		int ret = 0;

		String sql = "SELECT t_ticket.ticketId FROM t_ticket ORDER BY ticketId DESC;";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			resultSet.next();

			ret = resultSet.getInt("ticketId");

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
