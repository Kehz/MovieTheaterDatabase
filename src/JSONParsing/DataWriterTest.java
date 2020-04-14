package JSONParsing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Movie;
import main.Play;
import main.Theaters;
import main.User;

class DataWriterTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSaveMovies() {
		Movie movie = new Movie(0, null, 0, null, null, 0, null, null, null, null, 0);
		DataWriter dataWriter = new DataWriter();
		dataWriter.saveMovies();
	}
	
	@Test
	void testSavePlays() {
		Play plays = new Play(0, null, 0, null, null, 0, null, null, null, 0, 0);
		DataWriter dataWriter = new DataWriter();
		dataWriter.savePlays();
	}
	
	@Test
	void testSaveUsers() {
		User users = new User(null, null, null, 0, 0, 0, 0, null, null);
		DataWriter dataWriter = new DataWriter();
		dataWriter.saveUsers();
	}
	
	@Test
	void testSaveTheaters() {
		Theaters theaters = new Theaters(0, null, 0, null, 0);
		DataWriter dataWriter = new DataWriter();
		dataWriter.saveTheaters();
	}

}
