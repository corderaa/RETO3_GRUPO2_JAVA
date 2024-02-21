package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Object of the t_sesion from the DB. It represents a Session.
 */
public class Session implements Serializable {

	private static final long serialVersionUID = 346639021818786350L;

	private int sessionID = 0;
	private Date sessionDate = null;

	private Room room = null;
	private Cinema cinema = null;
	private Movie movie = null;

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public Date getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cinema, movie, room, sessionDate, sessionID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return Objects.equals(cinema, other.cinema) && Objects.equals(movie, other.movie)
				&& Objects.equals(room, other.room) && Objects.equals(sessionDate, other.sessionDate)
				&& sessionID == other.sessionID;
	}

	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", sessionDate=" + sessionDate + ", room=" + room + ", cinema="
				+ cinema + ", movie=" + movie + "]";
	}

}