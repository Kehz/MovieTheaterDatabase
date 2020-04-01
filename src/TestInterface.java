import java.util.ArrayList;
import java.util.Scanner;
public class TestInterface {
	private Scanner scanner;
	
	public TestInterface() {
		scanner = new Scanner(System.in);
	}
	
	public void play() {
		ShowList showList = ShowList.getInstance();
		
		System.out.println("****** UHHHH ******");
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
	
	
	private String getField(String prompt) {
		System.out.println(prompt + ": ");
		return scanner.nextLine();
	}
	
	private int getIntField(String prompt) {
		System.out.println(prompt + ": ");
		return scanner.nextInt();
	}
	
	public boolean addShows() {
		System.out.println("Would you like to add a show");
		
		String input = scanner.nextLine();
		
		if(input.toLowerCase().trim().equals("y")) return true;
		return false;
	}
	
	public void displayShows() {
		ShowList showList = ShowList.getInstance();
		ArrayList<Show> titles = showList.getShows();
		
		for(Show show : titles) {
			System.out.println(show.getTitle() + " " + show.getLength() + " " + show.getReleaseYear() + " " + show.getGenre() + " " + show.getDirector() + " " + show.getRating() + " " + show.getReviews());
			
		}
	}
}
