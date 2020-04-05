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
	private String[] mainLoginMenu = {"Create Account", "Continue as Guest", "Login", "Employee Login", "Exit"}; 
	private Scanner scanner;
	
	/**
	 * This is the function for executing our commands
	 */
	public void runTheaterDriver() {
		Scanner in = new Scanner(System.in);
		TheaterCommands theater = new TheaterCommands();
		InputHandler inHandler = new InputHandler(theater);
		System.out.println("Current commands are: show movies,show theaters, enter movie, enter theater");
		
		while(true) {
			String command = getInputLine("Enter Command", in);
			if(command.contentEquals("logout"))break;
			inHandler.inputEntered(command);
		}
	}
	
	private String getInputLine(String prompt, Scanner in) {
		System.out.print(prompt + ": ");
		return in.nextLine().toLowerCase().trim();
	}
	
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
			/**
			 * These are temp print outs but the idea will be to branch
			 * off to other parts of the program after executing these
			 * commands.
			 */
			switch(userCommand) {
			case(0):
				ti.addUser();
				break;
			case(1):
				System.out.println("Proceeding as a Guest User \n Some features will be inaccessible");
				runTheaterDriver();
				break;
			case(2):
				if(ti.login() == true) {
					runTheaterDriver();
				} else {
					break;	
				}
			case(3):
				System.out.println("Enter Employee Login Details: Username / Theater ID / Password");
				break;
			}

		}
		System.out.println("Exiting Program");
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
		System.out.println("\n******************* Main Menu *******************");

		for (int i = 0; i < mainLoginMenu.length; i++) {
			System.out.println((i+1) + ". " + mainLoginMenu[i]);
		}
		System.out.println("\n");

	}

	public static void main(String[] args) {
		TheaterDriver tDriver = new TheaterDriver();
		tDriver.runLogin();
		tDriver.runTheaterDriver();
		
		
		//theaterInterface.run();
		//testing.play();
	}
}
