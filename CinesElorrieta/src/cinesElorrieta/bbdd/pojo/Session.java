package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Object of the t_sesion from the DB. It represents a Session.
 */
public class Session implements Serializable {

	private static final long serialVersionUID = 346639021818786350L;

	int sessionID = 0;
	Date sessionDate = null;
	List<Room> rooms = null;

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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rooms, sessionDate, sessionID);
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
		return Objects.equals(rooms, other.rooms) && Objects.equals(sessionDate, other.sessionDate)
				&& sessionID == other.sessionID;
	}

	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", sessionDate=" + sessionDate + ", rooms=" + rooms + "]";
	}

}
