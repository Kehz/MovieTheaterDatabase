package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testGetReleaseYear() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		String ageRating = "R";
		int releaseYear = 2012;
		
		Movie movie = new Movie(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		int fact = movie.getReleaseYear();
		assertEquals(2012,fact);
	}
	
	@Test
	public void testSetReleaseYear() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		String ageRating = "R";
		int releaseYear = 2012;
		
		Movie movie = new Movie(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		movie.setReleaseYear(2009);
		int fact = movie.getReleaseYear();
		assertEquals(2009,fact);
	}
	
	@Test
	public void testGetAgeRating() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		String ageRating = "R";
		int releaseYear = 2012;
		
		Movie movie = new Movie(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		String test = movie.getAgeRating();
		assertEquals("R",test);
	}
	
	@Test
	public void testSetAgeRating() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		String ageRating = "R";
		int releaseYear = 2012;
		
		Movie movie = new Movie(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		movie.setAgeRating("PG");
		String fact = movie.getAgeRating();
		assertEquals("PG",fact);
	}

}
