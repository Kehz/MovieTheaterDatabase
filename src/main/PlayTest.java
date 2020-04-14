package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayTest {

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
	public void testGetAmountActors() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		int amountActors = 5;
		int timesPerformed = 2;
		
		Play play = new Play(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		int fact = play.getAmountActors();
		assertEquals(5,fact);
	}
	
	@Test
	public void testSetAmountActors() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		int amountActors = 5;
		int timesPerformed = 2;
		
		Play play = new Play(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		play.setAmountActors(6);
		int fact = play.getAmountActors();
		assertEquals(6,fact);
	}
	
	@Test
	public void testGetTimesPerformed() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		int amountActors = 5;
		int timesPerformed = 2;
		
		Play play = new Play(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		int fact = play.getTimesPerformed();
		assertEquals(2,fact);
	}
	
	@Test
	public void testSetTimesPerformed() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		int amountActors = 5;
		int timesPerformed = 2;
		
		Play play = new Play(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		play.setTimesPerformed(2);
		int fact = play.getTimesPerformed();
		assertEquals(2,fact);
	}
	
	@Test
	public void testToString() {
		Play play = new Play(0, null, 0, null, null, 0, null, null, null, 0, 0);
		play.toString();
	}

}
