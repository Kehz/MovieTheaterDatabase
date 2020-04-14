package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import JSONParsing.DataLists;

class TheaterInterfaceTest {

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
	public void testAddMovie() {
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

		DataLists dataLists = DataLists.getInstance();
		dataLists.addMovie(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		Movie fact = new Movie(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		assertEquals(dataLists,fact);
	}
	
	@Test
	public void testAddPlay() {
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
		
		DataLists dataLists = DataLists.getInstance();
		dataLists.addPlay(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		Play fact = new Play(id, title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		assertEquals(dataLists,fact);
	}
	
	@Test
	public void testAddTheater() {
		int id = 1;
		String title = "Theater";
		int ratings = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		int employeeId = 1;
		
		Theaters fact = new Theaters(id, title, ratings, reviews, employeeId);
		DataLists dataLists = DataLists.getInstance();
		dataLists.addTheater(id, title, ratings, reviews, employeeId);
		assertEquals(dataLists,fact);
	}
	
	@Test
	public void testAddUser() {
		String username = "name";
		String password = "password";
		String email = "Email";
		int age = 21;
		int points = 0;
		int employeeId = 2;
		int discountType = 0;
		ArrayList<String> shoppingCart = new ArrayList<String>();
		ArrayList<String> ticketCart = new ArrayList<String>();
		
		User fact = new User(username, password, email , age, points, employeeId, discountType, shoppingCart, ticketCart);
		DataLists dataLists = DataLists.getInstance();
		dataLists.addUser(username, password, email , age, points, employeeId, discountType, shoppingCart, ticketCart);
		assertEquals(dataLists,fact);
	}
	
}
