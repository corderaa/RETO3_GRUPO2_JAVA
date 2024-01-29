package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Object of the t_sesion from the DB. It represents a Session.
 */
public class Session implements Serializable {

	private static final long serialVersionUID = 346639021818786350L;

	int sessionID = 0;
	Date sessionDate = null;
	int idRoom = 0;
	int idCinema = 0;

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

	public int getRooms() {
		return 0;
	}

	public void setRooms(int idroom) {
		this.idRoom = idroom;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCinema, idRoom, sessionDate, sessionID);
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
		return idCinema == other.idCinema && idRoom == other.idRoom && Objects.equals(sessionDate, other.sessionDate)
				&& sessionID == other.sessionID;
	}

	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", sessionDate=" + sessionDate + ", idRoom=" + idRoom + ", idCinema="
				+ idCinema + "]";
	}

}
