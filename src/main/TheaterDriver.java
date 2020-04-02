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
import Commands.Theater;
public class TheaterDriver {
	private static final String WELCOME_MESSAGE = "Welcome to the MovieApp";
	private String[] mainLoginMenu = {"Create Account", "Continue as Guest", "Login", "Employee Login", "Exit"}; 
	private Scanner scanner;
	
	public void runTheaterDriver() {
		Scanner in = new Scanner(System.in);
		Theater theater = new Theater();
		InputHandler inHandler = new InputHandler(theater);
		System.out.println("Current commands are: show movies,show theaters, enter movie, enter theater");
		
		while(true) {
			String command = getInputLine("Enter Command", in);
			if(command.contentEquals("quit"))break;
			inHandler.inputEntered(command);
		}
	}
	
	private String getInputLine(String prompt, Scanner in) {
		System.out.print(prompt + ": ");
		return in.nextLine().toLowerCase().trim();
	}
		
//	public void run() {
//		System.out.println(WELCOME_MESSAGE);
//
//		while(true) {
//			printLoginMenu();
//
//			int userCommand = getUserCommand(mainLoginMenu.length);
//
//			if (userCommand == -1) {
//				System.out.println("Invalid Command. Please try again");
//				continue;
//			}
//			if(userCommand == mainLoginMenu.length -1) break;
//			/**
//			 * These are temp print outs but the idea will be to branch
//			 * off to other parts of the program after executing these
//			 * commands.
//			 */
//			switch(userCommand) {
//			case(0):
//				System.out.println("Enter Credentials: Username / Email / Password");
//				break;
//			case(1):
//				System.out.println("Proceeding as a Guest User \n Some features will be inaccessible");
//				break;
//			case(2):
//				System.out.println("Enter Login Details: Username / Email / Password");
//				break;
//			case(3):
//				System.out.println("Enter Employee Login Details: Username / Theater ID / Password");
//				break;
//			}
//
//		}
//		System.out.println("Exiting Program");
//	}
//
//	private int getUserCommand(int numCommands) {
//		System.out.print("What would you like to do?: ");
//		
//		String input = scanner.nextLine();
//		int command = Integer.parseInt(input) - 1;
//
//		if(command >= 0 && command <= numCommands -1) return command;
//
//		return -1;
//	}
//
	private void printLoginMenu() {
		System.out.println("\n******************* Main Menu *******************");

		for (int i = 0; i < mainLoginMenu.length; i++) {
			System.out.println((i+1) + ". " + mainLoginMenu[i]);
		}
		System.out.println("\n");

	}

	public static void main(String[] args) {
		TheaterDriver tDriver = new TheaterDriver();
		TheaterInterface testing = new TheaterInterface();
		tDriver.runTheaterDriver();
		//theaterInterface.run();
		//testing.play();
	}
}
