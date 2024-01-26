package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Object of the t_salas from the DB. It represents a Room.
 */
public class Room implements Serializable {

	private static final long serialVersionUID = 7008417407809251211L;

	int roomId = 0;
	String roomName = null;
	int cinemaId = 0;

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

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cinemaId, roomId, roomName);
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
		return cinemaId == other.cinemaId && roomId == other.roomId && Objects.equals(roomName, other.roomName);
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", cinemaId=" + cinemaId + "]";
	}

}
