package JSONParsing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Movie;
import main.Play;
import main.Theaters;
import main.User;

class DataLoaderTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLoadMovies() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movies = DataLoader.loadMovies();
		ArrayList<Movie> movieCompare = dataLists.getMovie();
		movies = movieCompare;
		assertEquals(movies,movieCompare);
	}
	
	@Test
	void testLoadPlays() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Play> plays = DataLoader.loadPlays();
		ArrayList<Play> playsCompare = dataLists.getPlays();
		plays = playsCompare;
		assertEquals(plays,playsCompare);
	}
	
	@Test
	void testLoadUsers() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> users = DataLoader.loadUsers();
		ArrayList<User> usersCompare = dataLists.getUsers();
		DataLoader.loadUsers();
		users = usersCompare;
		assertEquals(users,usersCompare);
	}
	
	@Test
	void testLoadTheaters() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaters = DataLoader.loadTheaters();
		ArrayList<Theaters> theatersCompare = dataLists.getTheaters();
		DataLoader.loadTheaters();
		theaters = theatersCompare;
		assertEquals(theaters,theatersCompare);
	}

}
