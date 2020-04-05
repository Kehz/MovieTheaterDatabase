package JSONParsing;
import java.util.ArrayList;

import main.Movie;
import main.Play;
import main.Show;
import main.Theaters;
import main.User;
/**
 * 
 * @author Devin Adams
 * This class handles the instances of our json parsing. It creates
 * new arraylists of our class objects and loads the data from the
 * their json into them to be used across the app. Also hands adding
 * objects into the arraylist and saving them to the json.
 */
public class DataLists {
	private static DataLists dataLists = null;
	private static ArrayList<Movie> movies = new ArrayList<Movie>();
	private static ArrayList<Play> plays = new ArrayList<Play>();
	private static ArrayList<Theaters> theaters = new ArrayList<Theaters>();
	private static ArrayList<User> users = new ArrayList<User>();
	/**
	 * This constructor loads the arraylists with values from the DataLoader class
	 */
	private DataLists() {
		movies = DataLoader.loadMovies();
		plays = DataLoader.loadPlays();
		theaters = DataLoader.loadTheaters();
		users = DataLoader.loadUsers();
	}
	
	
	public static DataLists getInstance() {
		if(dataLists == null) {
			dataLists = new DataLists();
		}
		return dataLists;
	}
	
	public ArrayList<Play> getPlays() {
		return plays;
	}
	
	public ArrayList<Movie> getMovie() {
		return movies;
	}
	
	public ArrayList<Theaters> getTheaters() {
		return theaters;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public void addMovie(int id, String title, int length, String genre, String director, int rating, String reviews,String showTimes, String ageRating, int releaseYear) {
		movies.add(new Movie(id, title, length, genre, director, rating, reviews, showTimes, ageRating, releaseYear));
		DataWriter.saveMovies();
	}
	
	public void addPlay(int id, String title, int length, String genre, String director, int rating, String reviews, String showTimes, int amountActors, int timesPerformed) {
		plays.add(new Play(id, title, length, genre, director, rating, reviews, showTimes, amountActors, timesPerformed));
		DataWriter.savePlays();
	}
	
	
	public void addTheater(String name, int ratings, String reviews) {
		theaters.add(new Theaters(name, ratings, reviews));
		DataWriter.saveTheaters();
	}
	
	public void addUser(String username, String password, String email, int age, int points) {
		users.add(new User(username, password, email, age, points));
		DataWriter.saveUsers();
	}
}
