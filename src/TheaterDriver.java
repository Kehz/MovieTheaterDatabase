/*
 * This is the driver class for our theater project 
 * WIP
 * @Author Devin Adams, Logan Etheredge, Brandon Carter
 * Trello Board - https://trello.com/b/FDiXCUV5/insertgoodnameheremoviedatabase
 * Repository	- https://github.com/adevin0/MovieTheaterDatabase
 */
import java.util.Scanner;
public class TheaterDriver {
	private static final String WELCOME_MESSAGE = "Welcome to the MovieApp";
	private String[] mainLoginMenu = {"Create Account", "Continue as Guest", "Login", "Employee Login", "Exit"}; 
	private Scanner scanner;
	TheaterDriver() {
		scanner = new Scanner(System.in);
	}
	public void run() {
		System.out.println(WELCOME_MESSAGE);

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
				System.out.println("Enter Credentials: Username / Email / Password");
				break;
			case(1):
				System.out.println("Proceeding as a Guest User \n Some features will be inaccessible");
				break;
			case(2):
				System.out.println("Enter Login Details: Username / Email / Password");
				break;
			case(3):
				System.out.println("Enter Employee Login Details: Username / Theater ID / Password");
				break;
			}

		}
		System.out.println("Exiting Program");
	}

	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
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
		TheaterDriver theaterInterface = new TheaterDriver();
		TestInterface testing = new TestInterface();
		//theaterInterface.run();
		testing.play();
	}
}
