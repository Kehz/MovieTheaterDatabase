package main;
import java.util.ArrayList;
import java.util.Scanner;

import Commands.Theater;
import JSONParsing.ShowList;
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
}
