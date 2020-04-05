package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import JSONParsing.ShowList;

/*
 * This class is handing our adding to our array lists for movies/theaters
 * Also contains functions for displaying the current movies / theaters in the json
 */
public class TheaterInterface {
	private Scanner scanner;
	
	public TheaterInterface() {
		scanner = new Scanner(System.in);
	}
	
	public void addShow() {
		ShowList showList = ShowList.getInstance();
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
			
			showList.addShow(title, length, releaseYear, genre, director, rating, reviews);
		}
	}
	
	public void addTheater() {
		ShowList showList = ShowList.getInstance();
		System.out.println("****** Displaying Current Theaters In The Database ******");
		displayTheaters();
		
		while(addTheaters()) {
			String title = getField("Title");;
			String reviews = getField("Reviews");
			int rating = getIntField("Rating");
			showList.addTheater(title, rating, reviews);
		}
	}
	
	public void addUser() {
		ShowList showList = ShowList.getInstance();
		System.out.println("Create an account by entering following credentials");
		boolean test = true;
		while(test) {
			String username = getField("Enter Username: ");
			String password = getField("Enter Password: ");
			String email = getField("Enter email: ");
			int age = getIntField("Enter age: ");
			int points = 0;
			showList.addUser(username, password, email, age, points);
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
	
	public void displayShows() {
		ShowList showList = ShowList.getInstance();
		ArrayList<Show> titles = showList.getShows();
		String search = "Frozen 2";
		for(Show show : titles) {
			if(show.getTitle() != null && show.getTitle().contains(search)) {
				System.out.println(show.getTitle());
			}
		}

		for(Show show : titles) {
			System.out.println("\n Title: " + show.getTitle() + "\n Movie Length: " + show.getLength() + "\n Release Year: " + show.getReleaseYear() + "\n Genre: " 
								+ show.getGenre() +"\n Director: " + show.getDirector() + "\n Rating: " 
								+ show.getRating() + "\n ======================");
		}
	}
	public void displayTheaters() {
		ShowList showList = ShowList.getInstance();
		ArrayList<Theaters> titles = showList.getTheaters();
		for(Theaters theaters : titles) {
			System.out.println("\n Name: " +theaters.getTitle() + "\n Ratings: " + theaters.getRatings() 
								+ "\n Reviews: " +theaters.getReviews() 
								+ "\n =======================");
		}
	}
	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		ShowList showList = ShowList.getInstance();
		ArrayList<User> titles = showList.getUsers();
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		// String email = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		
		boolean found = true;
		
		for(User users : titles) {
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
