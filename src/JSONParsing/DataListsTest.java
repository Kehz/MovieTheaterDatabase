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

}
