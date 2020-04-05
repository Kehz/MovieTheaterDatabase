package JSONParsing;
import java.util.ArrayList;

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
	private static ArrayList<Show> shows = new ArrayList<Show>();
	private static ArrayList<Theaters> theaters = new ArrayList<Theaters>();
	private static ArrayList<User> users = new ArrayList<User>();
	/**
	 * This constructor loads the arraylists with values from the DataLoader class
	 */
	private DataLists() {
		shows = DataLoader.loadShows();
		theaters = DataLoader.loadTheaters();
		users = DataLoader.loadUsers();
	}
	
	
	public static DataLists getInstance() {
		if(dataLists == null) {
			dataLists = new DataLists();
		}
		return dataLists;
	}
	
	public ArrayList<Show> getShows() {
		return shows;
	}
	
	public ArrayList<Theaters> getTheaters() {
		return theaters;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public void addShow(String title, int length, int releaseYear, String genre, String director, int rating, String reviews ) {
		shows.add(new Show(title, length, releaseYear, genre, director, rating, reviews));
		DataWriter.saveShows();
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
