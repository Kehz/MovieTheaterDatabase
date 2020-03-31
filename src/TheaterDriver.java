/*
 * This is the driver class for our theater project 
 * WIP
 * @Author Devin Adams, Logan Etheredge, Brandon Carter
 * Trello Board - https://trello.com/b/FDiXCUV5/insertgoodnameheremoviedatabase
 * Repository	- https://github.com/adevin0/MovieTheaterDatabase
 */

public class TheaterDriver {
	private static final String WELCOME_MESSAGE = "Welcome to the MovieApp";
	private String[] mainLoginMenu = {"Create Account", "Continue as Guest", "Login", "Employee Login", "Exit"}; 
	
	public void run() {
		printLoginMenu();
	}
	
	private void printLoginMenu() {
		System.out.println("\n******************* Main Menu *******************");
		
		for (int i = 0; i < mainLoginMenu.length; i++) {
			System.out.println((i+1) + ". " + mainLoginMenu[i]);
		}
		
	}

	public static void main(String[] args) {
		TheaterDriver theaterInterface = new TheaterDriver();
		theaterInterface.run();
	}
}
