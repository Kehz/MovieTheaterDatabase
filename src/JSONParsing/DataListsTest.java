package JSONParsing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Play;
/*
 * Actually have no clue what is even going on
 */
class DataListsTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetInstance() {
		DataLists dataLists = DataLists.getInstance();
		dataLists.getInstance();
	}
	
	@Test
	void testGetPlays() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Play> plays = dataLists.getPlays();
		assertEquals(dataLists.getPlays(),plays);
	}
	
	@Test
	void testGetMovies() {
		DataLists dataLists = DataLists.getInstance();
		dataLists.getMovie();
	}
	
	@Test
	void testGetUsers() {
		DataLists dataLists = DataLists.getInstance();
		dataLists.getUsers();
	}
	
	@Test
	void testGetTheaters() {
		DataLists dataLists = DataLists.getInstance();
		dataLists.getTheaters();
	}
	
	@Test
	void testAddPlay() {
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		reviews.add("Nice");
		showTimes.add("8pm-3am");
		inTheaters.add("Spark Theater");
		DataLists dataLists = DataLists.getInstance();
		dataLists.addPlay(1, "Frozen 2", 120, "Comedy", "John", 3, reviews, showTimes, inTheaters, 12, 12);
	}
	
	@Test
	void testAddMovie() {
		ArrayList<String> reviews = new ArrayList<String>();
		ArrayList<String> showTimes = new ArrayList<String>();
		ArrayList<String> inTheaters = new ArrayList<String>();
		reviews.add("Nice");
		showTimes.add("8pm-3am");
		inTheaters.add("Spark Theater");
		DataLists dataLists = DataLists.getInstance();
		dataLists.addMovie(1, "test", 24, "Comedy", "mark", 3, reviews, showTimes, inTheaters, "pg-13", 2020);
	}
	
	@Test
	void testAddTheater() {
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Alright");
		DataLists dataLists = DataLists.getInstance();
		dataLists.addTheater(1, "Lame", 2, reviews, 123123);
	}
	
	@Test
	void testAddUser() {
		ArrayList<String> shoppingCart = new ArrayList<String>();
		ArrayList<String> ticketCart = new ArrayList<String>();
		DataLists dataLists = DataLists.getInstance();
		dataLists.addUser("Tester", "password", "email@email.com", 12, 1222, 032, 0, shoppingCart, ticketCart);
	}

}
