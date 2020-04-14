package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShowTest {

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
	public void testGetTitle() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		String fact = show.getTitle();
		assertEquals("Movie Title",fact);
	}
	
	@Test
	public void testSetTitle() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		show.setTitle("New Title");
		String fact = show.getTitle();
		assertEquals("New Title",fact);
	}
	
	@Test
	public void testGetLength() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		int fact = show.getLength();
		assertEquals(60,fact);
	}
	
	@Test
	public void testSetLength() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		show.setLength(70);
		int fact = show.getLength();
		assertEquals(70,fact);
	}
	
	@Test
	public void testGetGenre() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		String fact = show.getGenre();
		assertEquals("Action",fact);
	}
	
	@Test
	public void testSetGenre() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		show.setGenre("Romance");
		String fact = show.getGenre();
		assertEquals("Romance",fact);
	}
	
	@Test
	public void testGetDirector() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		String fact = show.getDirector();
		assertEquals("A director",fact);
	}
	
	@Test
	public void testSetDirector() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		show.setDirector("New Director");
		String fact = show.getDirector();
		assertEquals("New Director",fact);
	}
	
	@Test
	public void testGetRating() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		int fact = show.getRating();
		assertEquals(5,fact);
	}
	
	@Test
	public void testSetRating() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		show.setRating(4);
		int fact = show.getRating();
		assertEquals(4,fact);
	}
	
	@Test
	public void testGetReviews() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		ArrayList<String> fact = show.getReviews();
		assertEquals(reviews,fact);
	}
	
	@Test
	public void testSetReviews() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		ArrayList<String> reviews2 = new ArrayList<String>();
		reviews2.add("New Review");
		show.setReviews(reviews2);
		ArrayList<String> fact = show.getReviews();
		assertEquals(reviews2, fact);
	}
	
	@Test
	public void testGetShowTimes() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		ArrayList<String> fact = show.getShowTimes();
		assertEquals(showTimes,fact);
	}
	
	@Test
	public void testSetShowTimes() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		ArrayList<String> showTimes2 = new ArrayList<String>();
		showTimes2.add("New Time");
		show.setShowTimes(showTimes2);
		ArrayList<String> fact = show.getShowTimes();
		assertEquals(showTimes2, fact);
	}
	
	@Test
	public void testGetId() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		int fact = show.getId();
		assertEquals(2,fact);
	}
	
	@Test
	public void testSetId() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		show.setId(3);
		int fact = show.getId();
		assertEquals(3,fact);
	}
	
	@Test
	public void testGetInTheaters() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);

		ArrayList<String> fact = show.getInTheaters();
		assertEquals(inTheaters, fact);
	}
	
	@Test
	public void testSetInTheaters() {
		int id = 2;
		String title = "Movie Title";
		int length = 60;
		String genre = "Action";
		String director = "A director";
		int rating = 5;
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("Review");
		ArrayList<String> showTimes = new ArrayList<String>();
		showTimes.add("Show time");
		ArrayList<String> inTheaters = new ArrayList<String>();
		inTheaters.add("In theater");
		
		Show show = new Show(id, title, length, genre, director, rating, reviews, showTimes, inTheaters);
		ArrayList<String> inTheaters2 = new ArrayList<String>();
		inTheaters2.add("Now in theater");
		show.setInTheaters(inTheaters2);
		ArrayList<String> fact = show.getInTheaters();
		assertEquals(inTheaters2, fact);
	}
	
}
