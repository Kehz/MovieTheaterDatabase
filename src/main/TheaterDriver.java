package main;
/*
 * This is the driver class for our theater project 
 * WIP
 * @Author Devin Adams, Logan Etheredge, Brandon Carter
 * Trello Board - https://trello.com/b/FDiXCUV5/insertgoodnameheremoviedatabase
 * Repository	- https://github.com/adevin0/MovieTheaterDatabase
 */
import java.util.Scanner;

import Commands.InputHandler;
import Commands.TheaterCommands;
public class TheaterDriver {
	private static final String WELCOME_MESSAGE = "Welcome to the MovieApp";
	private String[] mainLoginMenu = {"Create Account", "Continue as Guest", "Login", "Exit"}; 
	/**
	 * This command runs the main app after login is exectuted and passes
	 */
	public void runTheaterDriver() {
		User user = new User(null, null, null, 0, 0, 0, 0, null, null);
		Scanner in = new Scanner(System.in);
		TheaterCommands theater = new TheaterCommands();
		InputHandler inHandler = new InputHandler(theater);
		while(true) {
			user.userMainMenu();
			String command = getInputLine("Enter Command", in);
			if(command.contentEquals("logout"))break;
			inHandler.inputEntered(command);
		}
	}
	
	private String getInputLine(String prompt, Scanner in) {
		System.out.print(prompt + ": ");
		return in.nextLine().toLowerCase().trim();
	}
	/**
	 * Provides the applications greeting menu with login options for the
	 * user to choose from
	 */
	public void runLogin() {
		System.out.println(WELCOME_MESSAGE);
		TheaterInterface ti = new TheaterInterface();

		while(true) {
			printLoginMenu();

			int userCommand = getUserCommand(mainLoginMenu.length);

			if (userCommand == -1) {
				System.out.println("Invalid Command. Please try again");
				continue;
			}
			if(userCommand == mainLoginMenu.length -1) break;
			switch(userCommand) {
			case(0):
				ti.addUser();
				break;
			case(1):
				System.out.println("Proceeding as a Guest User\nSome features will be inaccessible");
				runTheaterDriver();
				break;
			case(2):
				if(ti.login() == true) {
					runTheaterDriver();
				} else {
					break;	
				}
		}
		System.out.println("Exiting Program");
		}
	}

	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		
		int command = Integer.parseInt(input) - 1;

		if(command >= 0 && command <= numCommands -1) return command; 
		
		return -1;
	}

	private void printLoginMenu() {
		System.out.println("\n******************* Login Menu *******************");

		for (int i = 0; i < mainLoginMenu.length; i++) {
			System.out.println((i+1) + ". " + mainLoginMenu[i]);
		}
		System.out.println("\n");

	}
	/**
	 * Executing the runLogin command so we can begin the app
	 */
	public static void main(String[] args) {
		TheaterDriver tDriver = new TheaterDriver();
		tDriver.runLogin();
	}
}
