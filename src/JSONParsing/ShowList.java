package JSONParsing;
import java.util.ArrayList;

import main.Show;
import main.Theaters;
import main.User;
public class ShowList {
	private static ShowList showList = null;
	private static ArrayList<Show> shows = new ArrayList<Show>();
	private static ArrayList<Theaters> theaters = new ArrayList<Theaters>();
	private static ArrayList<User> users = new ArrayList<User>();
	
	private ShowList() {
		shows = DataLoader.loadShows();
		theaters = DataLoader.loadTheaters();
		users = DataLoader.loadUsers();
	}
	
	
	public static ShowList getInstance() {
		if(showList == null) {
			showList = new ShowList();
		}
		return showList;
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
