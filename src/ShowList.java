import java.util.ArrayList;
public class ShowList {
	private static ShowList showList = null;
	private static ArrayList<Show> shows = new ArrayList<Show>();
	
	private ShowList() {
		shows = DataLoader.loadShows();
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
	
	public void addShow(String title, int length, int releaseYear, String genre, String director, int rating, String reviews ) {
		shows.add(new Show(title, length, releaseYear, genre, director, rating, reviews));
		DataWriter.saveShows();
	}
}
