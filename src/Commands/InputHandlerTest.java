package Commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testInputEntered() {
		TheaterCommands theater = new TheaterCommands();
		InputHandler input = new InputHandler(theater);
		input.inputEntered(null);
	}

}
