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
	int movieId = 0;
	Date ticketDate = null;
	int roomId = 0;
	double ticketPrice = 0;
	int sessionId = 0;
	int userId = 0;

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

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, roomId, sessionId, tickedId, ticketBuyDate, ticketDate, ticketPrice, userId);
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
		return movieId == other.movieId && roomId == other.roomId && sessionId == other.sessionId
				&& tickedId == other.tickedId && Objects.equals(ticketBuyDate, other.ticketBuyDate)
				&& Objects.equals(ticketDate, other.ticketDate)
				&& Double.doubleToLongBits(ticketPrice) == Double.doubleToLongBits(other.ticketPrice)
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Ticket [tickedId=" + tickedId + ", ticketBuyDate=" + ticketBuyDate + ", movieId=" + movieId
				+ ", ticketDate=" + ticketDate + ", roomId=" + roomId + ", ticketPrice=" + ticketPrice + ", sessionId="
				+ sessionId + ", userId=" + userId + "]";
	}

}
