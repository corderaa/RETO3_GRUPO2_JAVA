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
	// int roomId = 0; Esto es la relacion no se como hacerla

	public int getSessionID() {
		return 0;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public Date getSessionDate() {
		return null;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sessionDate, sessionID);
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
		return Objects.equals(sessionDate, other.sessionDate) && sessionID == other.sessionID;
	}

	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", sessionDate=" + sessionDate + "]";
	}

}
