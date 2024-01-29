package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Object of the t_salas from the DB. It represents a Room.
 */
public class Room implements Serializable {

	private static final long serialVersionUID = 7008417407809251211L;

	private int roomId = 0;
	private int cinemaId = 0;
	private String roomName = null;

	private List<Session> sessions = null;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomId, roomName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return roomId == other.roomId && Objects.equals(roomName, other.roomName);
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", cinema=" + cinemaId + ", sessions=" + sessions
				+ "]";
	}

}
