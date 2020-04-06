package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import JSONParsing.DataWriter;
import JSONParsing.DataLists;

/**
 * 
 * @author Devin Adams
 * This class is the main apps interfacing which holds our main functions
 * involving interating with our user login and displaying/adding theaters and shows.
 */
public class TheaterInterface {
	private Scanner scanner;
	
	public TheaterInterface() {
		scanner = new Scanner(System.in);
	}
	/**
	 * Displays current shows and adds them to our arraylist
	 */
	public void addMovie() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		System.out.println("****** Displaying Current Movies In The Database ******");
		while(addShows()) {
			int id = movieList.size()+1;
			String title = getField("Title");
			String genre = getField("Genre");
			String director = getField("Director");
			String ageRating = getField("Age Rating [G,PG,PG-13,R]");
			ArrayList<String> reviews = getArrayField("Reviews");
			ArrayList<String> showTimes = getArrayField("Show Times");
			ArrayList<String> inTheaters = getArrayField("Theaters Shown in");
			int rating = getIntField("Rating [5/5]");
			int length = getIntField("Length [Minutes]");
			int releaseYear = getIntField("Release Year");
			
			dataLists.addMovie(id,title, length, genre, director, rating, reviews, showTimes, inTheaters, ageRating, releaseYear);
		}
	}
	
	
	public void addPlay() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Play> playList = dataLists.getPlays();
		System.out.println("****** Adding a Play to the Database ******");
		while(addShows()) {
			int id = playList.size()+1;
			String title = getField("Title");
			String genre = getField("Genre");
			String director = getField("Director");
			ArrayList<String> reviews = getArrayField("Reviews");
			ArrayList<String> showTimes = getArrayField("Show Times");
			ArrayList<String> inTheaters = getArrayField("Theaters Shown in");
			int rating = getIntField("Rating [5/5]");
			int length = getIntField("Length [Minutes]");
			int amountActors = getIntField("Actor Amount");
			int timesPerformed = getIntField("Times Performed");
			
			dataLists.addPlay(id,title, length, genre, director, rating, reviews, showTimes, inTheaters, amountActors, timesPerformed);
		}
	}
	/**
	 * Displays current theaters and adds them to our arraylist
	 */
	public void addTheater() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaterList = dataLists.getTheaters();
		System.out.println("****** Displaying Current Theaters In The Database ******");
		displayTheaters();
		while(addTheaters()) {
			int id = theaterList.size()+1;
			String title = getField("Title");;
			ArrayList<String> reviews = getArrayField("Reviews");
			int rating = getIntField("Rating");
			int employeeID = getIntField("Employee ID");
			dataLists.addTheater(id,title, rating, reviews, employeeID);
		}
	}
	/**
	 * Function for handling creating an account and adding it into our arraylist
	 */
	public void addUser() {
		DataLists dataLists = DataLists.getInstance();
		System.out.println("Are you creating an employee account? y/n");
		String input = scanner.nextLine();
		int employeeID = 0;
		int discountType = 0;
		if(input.toLowerCase().trim().equals("y")) {
			System.out.println("Enter your employee ID: ");
			employeeID = scanner.nextInt();
			scanner.nextLine();
			if (isValidEmployee(employeeID)) {
				discountType = 1;
				System.out.println("You're a valid employee for a theater!");
			} else {
				employeeID = 0;
				discountType = 0;
				System.out.println("Invalid employee ID. Contact Admin to add your Theater id or input a valid id");
				return;
			}
		} else if (input.toLowerCase().trim().equals("n")) {
			employeeID = 0;
			discountType = 0;
		}
		System.out.println("Create an account by entering following credentials");
		ArrayList<String> shoppingCart = new ArrayList<String>();
		ArrayList<String> ticketCart = new ArrayList<String>();
		ticketCart.add("Empty Cart");
		shoppingCart.add("Empty Cart");
		String username = getField("Enter Username: ");
		String password = getField("Enter Password: ");
		String email = getField("Enter email: ");
		int age = getIntField("Enter age: ");
		int points = 0;
		dataLists.addUser(username, password, email, age, points,employeeID,discountType,shoppingCart,ticketCart);
	}
	
	private ArrayList<String> getArrayField(String prompt) {
		System.out.println(prompt + "(type 'end' to stop adding elements): ");
		ArrayList<String> input = new ArrayList<String>();
		boolean loop = true;
		while(loop) {
			String str = scanner.nextLine();
			if(str.contentEquals("end")) {
				loop = false;
			} else {
				input.add(str);
			}
		}
		return input;
	}
	
	private String getField(String prompt) {
		System.out.println(prompt + ": ");
		return scanner.nextLine();
	}
	
	private int getIntField(String prompt) {
		System.out.println(prompt + ": ");
		return scanner.nextInt();
	}
	
	private boolean addShows() {
		System.out.println("Would you like to add a show?");
		
		String input = scanner.nextLine();
		
		if(input.toLowerCase().trim().equals("y")) return true;
		return false;
	}
	
	private boolean addTheaters() {
		System.out.println("Would you like to add a theater?");
		
		String input = scanner.nextLine();
		
		if(input.toLowerCase().trim().equals("y")) return true;
		return false;
	}
	
	 /**
	  * Prints out shows
	  */
	public void displayMovies() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		for(Movie movie : movieList) {
			System.out.println(movie.toString());
		}
	}
	
	public void displayPlays() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Play> playList = dataLists.getPlays();
		for(Play play : playList) {
			System.out.println(play.toString());
		}
	}
	/**
	 * Prints out theaters
	 */
	public void displayTheaters() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaterLists = dataLists.getTheaters();
		for(Theaters theaters : theaterLists) {
			System.out.println(theaters.toString());
		}
	}
	/**
	 * This function works as a login system for our program. 
	 * @return True if username/password match | False if username/password do not match
	 */
	public boolean login() {
		User us = new User(null, null, null, 0, 0, 0, 0, null, null);
		Scanner scanner = new Scanner(System.in);
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userLists = dataLists.getUsers();
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		// String email = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		
		boolean found = true;
		
		for(User users : userLists) {
			if((users.getUsername() != null && users.getUsername().contains(username)) && (users.getPassword() != null && users.getPassword().contains(password))) {
				System.out.println("Succesfully Logged In!");
				us.updateCurrentUser(users.getUsername(), users.getPassword(), users.getEmail(), users.getPoints(), users.getAge());
				found = true;
				if (found == true) {
					break;
				}
			} else {
				found = false;
			}
		}
		if (found == false) {
			System.out.println("Login info incorrect");
		}
		return found;
	}
	private boolean isValidEmployee(int employeeID) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaterList = dataLists.getTheaters();
		for(Theaters theater: theaterList) {
			if (theater.getEmployeeID() == employeeID) {
				return true;
			}
		}
		return false;
	}
}
