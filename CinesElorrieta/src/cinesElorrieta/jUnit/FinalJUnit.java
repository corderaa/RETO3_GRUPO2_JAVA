package cinesElorrieta.jUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Test;

import cinesElorrieta.bbdd.managers.CinemaManager;
import cinesElorrieta.bbdd.managers.MovieManager;
import cinesElorrieta.bbdd.managers.SesionManager;
import cinesElorrieta.bbdd.pojo.Cinema;
import cinesElorrieta.bbdd.pojo.Movie;
import cinesElorrieta.bbdd.pojo.Session;

public class FinalJUnit {

	@Test
	public void testMovieDate() {

		String cinemaId = "1";
		String movieId = "1";
		String dateTime = "15:41:09";

		SesionManager sesionManager = new SesionManager();
		Session session = sesionManager.getTheDataFromSelectedSession(cinemaId, movieId, dateTime);

		assertNotNull(session.getSessionDate());

	}

	@Test
	public void testFilmSpecificDate() {

		String cinemaId = "1";
		String movieId = "1";
		String dateTime = "15:41:09";

		SesionManager sesionManager = new SesionManager();
		Session session = sesionManager.getTheDataFromSelectedSession(cinemaId, movieId, dateTime);

		assertNotNull(session.getSessionID());

	}

	@Test
	public void testGetAllCinemas() {
		ArrayList<Cinema> cinemas = null;
		Movie testMovie = new Movie();
		CinemaManager cinemaManager = new CinemaManager();
		cinemas = cinemaManager.getAllCinemas();
		for (int i = 0; i < cinemas.size(); i++) {
			// (testCinema, cinemas.get(i));
			assertNotSame(cinemas.get(i), testMovie);
		}
	}

	@Test
	public void testGetMovieFromCinema() {
		String cinemaId = "1";
		ArrayList<Movie> movies = null;
		MovieManager movieManager = new MovieManager();
		movies = movieManager.getAllMoviesFromCinema(cinemaId);
		assertNotNull(movies);
	}

	@Test
	public void testGetAllMoviesPrices() {
		String cinemaId = "1";
		String movieId = "1";
		String dateTime = "15:41:09";

		SesionManager sesionManager = new SesionManager();
		Session session = new Session();

		session = sesionManager.getTheDataFromSelectedSession(cinemaId, movieId, dateTime);
		assertNotEquals(session.getMovie().getMoviePrice(), 0);
	}

	@Test
	public void getRoomMovieForDateTime() {
		String cinemaId = "1";
		String movieId = "1";
		String dateTime = "2024-02-02 15:41:09";

		SesionManager sesionManager = new SesionManager();

		Session session = sesionManager.getTheDataFromSelectedSession(cinemaId, movieId, dateTime);
		assertNotNull(session.getRoom().getRoomId());
	}
}
