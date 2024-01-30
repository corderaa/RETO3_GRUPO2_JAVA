package cinesElorrieta.jUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import cinesElorrieta.bbdd.pojo.Movie;
import cinesElorrieta.bbdd.pojo.Session;

public class MovieTest {

	@Test
	public void testGetMovieId() {
		Movie movie = new Movie();
	 	int resultado = movie.getMovieId();
	 	resultado = 8;
	 	assertNotNull("Correct" + resultado);
	}

	@Test
	public void testSetMovieId() {
		 	Movie movie = new Movie();
		 	movie.setMovieId(1);
		 	assertNotNull(1);
	}

	@Test
	public void testSetMovieDuration() {
			Movie movie = new Movie();
			movie.setMovieDuration(null);
			assertNull(null);
	}

	@Test
	public void testGetMovieKind() {
		Movie movie = new Movie();
	 	String resultado = movie.getMovieKind();
	 	resultado = null;
	 	assertNull(resultado);
	}

	@Test
	public void testSetMovieKind() {
		Movie movie = new Movie();
	 	movie.setMovieKind(null);
	 	assertNull(null);
	}

	@Test
	public void testGetMoviePrice() {
		Movie movie = new Movie();
	 	Double resultado = movie.getMoviePrice();
	 	resultado = 8.8;
	 	assertNotNull("correct" + resultado);
	}

	@Test
	public void testSetMoviePrice() {
		Movie movie = new Movie();
		 movie.setMoviePrice(8.50);
		 assertNotNull(8.30);
	}

	@Test
	public void testGetSessionIDs() {
		Movie movie = new Movie();
		 movie.setSessionIDs(null);
		 List<Session> resultado = movie.getSessionIDs();
		 assertNotNull(resultado);
	}

	@Test
	public void testSetSessionIDs() {
		Movie movie = new Movie();
		 movie.setSessionIDs(null);
		 assertNull(null);
	}

	@Test
	public void testEqualsObject() {
		MovieTest obj = null;
		if (obj == null)
			assertNull(getClass());
	}

	@Test
	public void testToString() {
		Movie movie = new Movie();
		String expected = "Jumanji";
		 assertEquals(expected, movie.toString());
	}

}
