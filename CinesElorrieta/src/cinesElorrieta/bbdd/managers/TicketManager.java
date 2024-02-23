package cinesElorrieta.bbdd.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import cinesElorrieta.bbdd.pojo.Ticket;
import cinesElorrieta.bbdd.utils.DBUtils;
import cinesElorrieta.utils.Converter;

/**
 * Manager of the table t_Ticket. It contains all the methods for that table.
 */
public class TicketManager {

	/**
	 * Insert the ticket parameters into the database
	 * 
	 * @param ticket
	 * @return
	 */
	public void insertTicket(Ticket ticket) {

		Converter converter = null;

		Connection connection = null;

		Statement statement = null;

		try {

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();

			converter = new Converter();

			String sql = "insert into t_ticket (ticketId, ticketPrice, ticketPurchaseDate, ticketPrintDate, sessionId, userDNI) VALUES ("
					+ ticket.getTickedId() + ", " + ticket.getTicketPrice() + ", '"
					+ converter.convertJavaDateToTimeStamp(ticket.getTicketBuyDate()) + "','"
					+ converter.convertJavaDateToTimeStamp(ticket.getTicketDate()) + "', "
					+ ticket.getSession().getSessionID() + ", '" + ticket.getUser().getUserId() + "')";

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

	/**
	 * Select the id of a single ticket from the database
	 * 
	 * @return last ticket Id
	 */
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
