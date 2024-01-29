package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Object of the t_entrada from the DB. It represents a ticket.
 */

public class Ticket implements Serializable {

	private static final long serialVersionUID = 6484501230287264913L;

	int tickedId = 0;
	Date ticketBuyDate = null;
	Date ticketDate = null;
	double ticketPrice = 0;

	private Cinema cinema = null;
	private Movie movie = null;
	private Room room = null;
	private Session session = null;
	private User user = null;

	public int getTickedId() {
		return tickedId;
	}

	public void setTickedId(int tickedId) {
		this.tickedId = tickedId;
	}

	public Date getTicketBuyDate() {
		return ticketBuyDate;
	}

	public void setTicketBuyDate(Date ticketBuyDate) {
		this.ticketBuyDate = ticketBuyDate;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cinema, movie, room, session, tickedId, ticketBuyDate, ticketDate, ticketPrice, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(cinema, other.cinema) && Objects.equals(movie, other.movie)
				&& Objects.equals(room, other.room) && Objects.equals(session, other.session)
				&& tickedId == other.tickedId && Objects.equals(ticketBuyDate, other.ticketBuyDate)
				&& Objects.equals(ticketDate, other.ticketDate)
				&& Double.doubleToLongBits(ticketPrice) == Double.doubleToLongBits(other.ticketPrice)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Ticket [tickedId=" + tickedId + ", ticketBuyDate=" + ticketBuyDate + ", ticketDate=" + ticketDate
				+ ", ticketPrice=" + ticketPrice + ", cinema=" + cinema + ", movie=" + movie + ", room=" + room
				+ ", session=" + session + ", user=" + user + "]";
	}

}
