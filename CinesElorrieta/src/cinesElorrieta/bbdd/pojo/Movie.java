package cinesElorrieta.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Object of the t_pelis from the DB. It represents a Movie.
 */
public class Movie implements Serializable {

	private static final long serialVersionUID = 5115264711006430061L;

	int movieId = 0;
	Date movieDuration = null;
	String movieKind = null;
	Double moviePrice = 0.0;
	// int sesionID = 0; Esto es la relacion no se como hacerla

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Date getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(Date movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieKind() {
		return movieKind;
	}

	public void setMovieKind(String movieKind) {
		this.movieKind = movieKind;
	}

	public Double getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(Double moviePrice) {
		this.moviePrice = moviePrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieDuration, movieId, movieKind, moviePrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(movieDuration, other.movieDuration) && movieId == other.movieId
				&& Objects.equals(movieKind, other.movieKind) && Objects.equals(moviePrice, other.moviePrice);
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieDuration=" + movieDuration + ", movieKind=" + movieKind
				+ ", moviePrice=" + moviePrice + "]";
	}

}
