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
	public void addShow() {
		DataLists dataLists = DataLists.getInstance();
		System.out.println("****** Displaying Current Movies In The Database ******");
		displayShows();
		
		while(addShows()) {
			String title = getField("Title");
			String genre = getField("Genre");
			String director = getField("Director");
			String reviews = getField("Reviews");
			int rating = getIntField("Rating");
			int length = getIntField("Length");
			int releaseYear = getIntField("Release Year");
			
			dataLists.addShow(title, length, releaseYear, genre, director, rating, reviews);
		}
	}
	/**
	 * Displays current theaters and adds them to our arraylist
	 */
	public void addTheater() {
		DataLists dataLists = DataLists.getInstance();
		System.out.println("****** Displaying Current Theaters In The Database ******");
		displayTheaters();
		
		while(addTheaters()) {
			String title = getField("Title");;
			String reviews = getField("Reviews");
			int rating = getIntField("Rating");
			dataLists.addTheater(title, rating, reviews);
		}
	}
	/**
	 * Function for handling creating an account and adding it into our arraylist
	 */
	public void addUser() {
		DataLists dataLists = DataLists.getInstance();
		System.out.println("Create an account by entering following credentials");
		boolean test = true;
		while(test) {
			String username = getField("Enter Username: ");
			String password = getField("Enter Password: ");
			String email = getField("Enter email: ");
			int age = getIntField("Enter age: ");
			int points = 0;
			dataLists.addUser(username, password, email, age, points);
			test = false;
		}
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
	public void displayShows() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Show> showList = dataLists.getShows();
		for(Show show : showList) {
			System.out.println("\n Title: " + show.getTitle() + "\n Movie Length: " + show.getLength() + "\n Release Year: " + show.getReleaseYear() + "\n Genre: " 
								+ show.getGenre() +"\n Director: " + show.getDirector() + "\n Rating: " 
								+ show.getRating() + "\n ======================");
		}
	}
	/**
	 * Prints out theaters
	 */
	public void displayTheaters() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaterLists = dataLists.getTheaters();
		for(Theaters theaters : theaterLists) {
			System.out.println("\n Name: " +theaters.getTitle() + "\n Ratings: " + theaters.getRatings() 
								+ "\n Reviews: " +theaters.getReviews() 
								+ "\n =======================");
		}
	}
	/**
	 * This function works as a login system for our program. 
	 * @return True if username/password match | False if username/password do not match
	 */
	public boolean login() {
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
}
