package main;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.lang.reflect.Method; 

import Commands.InputHandler;
import Commands.TheaterCommands;

import org.junit.jupiter.api.Test;

class TheaterDriverTest {

	@Test
	public void testUserCommand() {
		TheaterDriver thing= new TheaterDriver();
		int okay = thing.testUserCommand(3,1);
		System.out.println(okay);
		System.out.println();
	}
	
	@Test
	public void testSecondUserCommand() {
		TheaterDriver thing= new TheaterDriver();
		int okay = thing.testUserCommand(2,0);
		System.out.println(okay);
		System.out.println();
	}
	
	@Test
	public void testLogin() {
		TheaterDriver thing= new TheaterDriver();
		thing.loginMenu();
	}

}
