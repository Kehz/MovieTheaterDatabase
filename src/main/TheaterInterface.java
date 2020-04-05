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
			String reviews = getField("Reviews");
			String showTimes = getField("Show Times");
			String ageRating = getField("Age Rating [G,PG,PG-13,R]");
			int rating = getIntField("Rating [5/5]");
			int length = getIntField("Length [Minutes]");
			int releaseYear = getIntField("Release Year");
			
			dataLists.addMovie(id,title, length, genre, director, rating, reviews, showTimes, ageRating, releaseYear);
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
			String reviews = getField("Reviews");
			String showTimes = getField("Show Times");
			int rating = getIntField("Rating [5/5]");
			int length = getIntField("Length [Minutes]");
			int amountActors = getIntField("Actor Amount");
			int timesPerformed = getIntField("Times Performed");
			
			dataLists.addPlay(id,title, length, genre, director, rating, reviews, showTimes, amountActors, timesPerformed);
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
	public void displayMovies() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		for(Movie movie : movieList) {
			System.out.println("\n Id " +movie.getId() + "\n Title: " + movie.getTitle() + "\n Movie Length: " + movie.getLength() + "\n Release Year: " + movie.getReleaseYear() + "\n Genre: " 
								+ movie.getGenre() +"\n Director: " + movie.getDirector() + "\n Age Rating: " +movie.getAgeRating()+ "\n Show Times: " +movie.getShowTimes()+ "\n Rating: "  
								+ movie.getRating() + "\n Reviews: " +movie.getReviews() + "\n ======================");
		}
	}
	
	public void displayPlays() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Play> playList = dataLists.getPlays();
		for(Play play : playList) {
			System.out.println("\n Id: " +play.getId() + "\n Title: " + play.getTitle() + "\n Movie Length: " + play.getLength() + "\n Amount Actors: " + play.getAmountActors() + "\n Genre: " 
								+ play.getGenre() +"\n Director: " + play.getDirector() + "\n Times Performed: " +play.getTimesPerformed()+ "\n Show Times: " +play.getShowTimes()+ "\n Rating: "  
								+ play.getRating() + "\n Reviews: " +play.getReviews() + "\n ======================");
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
		scanner.close();
		return found;
	}
}
