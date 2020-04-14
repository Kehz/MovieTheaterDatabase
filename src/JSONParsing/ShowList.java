package JSONParsing;
import java.util.ArrayList;

import main.Show;
import main.Theaters;
public class ShowList {
	private static ShowList showList = null;
	private static ArrayList<Show> shows = new ArrayList<Show>();
	private static ArrayList<Theaters> theaters = new ArrayList<Theaters>();
	
	private ShowList() {
		shows = DataLoader.loadShows();
		theaters = DataLoader.loadTheaters();
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
	
	public void addShow(String title, int length, int releaseYear, String genre, String director, int rating, String reviews ) {
		shows.add(new Show(title, length, releaseYear, genre, director, rating, reviews));
		DataWriter.saveShows();
	}
	
	public void addTheater(String name, int ratings, String reviews) {
		theaters.add(new Theaters(name, ratings, reviews));
		DataWriter.saveTheaters();
	}
}
