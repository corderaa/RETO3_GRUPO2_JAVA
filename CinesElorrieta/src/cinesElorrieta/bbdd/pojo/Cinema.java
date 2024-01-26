package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Object of the t_cines from the DB. It represents a Cinema.
 */
public class Cinema implements Serializable {

	private static final long serialVersionUID = 3419524778141517579L;

	int cinemaId = 0;
	String cinemaName = null;
	String cinemaAddress = null;

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCinemaAddress() {
		return cinemaAddress;
	}

	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cinemaAddress, cinemaId, cinemaName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		return Objects.equals(cinemaAddress, other.cinemaAddress) && cinemaId == other.cinemaId
				&& Objects.equals(cinemaName, other.cinemaName);
	}

	@Override
	public String toString() {
		return "Cinema [cinemaId=" + cinemaId + ", cinemaName=" + cinemaName + ", cinemaAddress=" + cinemaAddress + "]";
	}

}
