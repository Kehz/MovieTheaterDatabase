package main;

import java.util.ArrayList;

import JSONParsing.DataLists;

/**
 * 
 * @author Devin Adams
 * This will allow the user to search for what movies they want to see based on certain critera
 */
public class ShowSearch {
	/**
	 * 
	 * @param showType - either a movie/play
	 * @param genre - genre you are searching for
	 * 
	 * should then scan the arraylist of movies/plays and printing out them if they contain
	 * the entered genre
	 */
	public void searchByGenre(boolean adult, String showType, String genre) {
<<<<<<< HEAD
		System.out.println("Displaying shows " +showType + " that are " + genre +"'s");
		DataLists dataLists = DataLists.getInstance();
		if (showType.equalsIgnoreCase("movie")) {
=======
		System.out.println("Displaying shows " +showType + "that are " + genre +"'s");
		DataLists dataLists = DataLists.getInstance();
		if (showType.equalsIgnoreCase("movie")) {
			System.out.println("did we reach here");
>>>>>>> eeba13c2651a20c185979b0e67a1950ae3ac5f69
			ArrayList<Movie> movieLists = dataLists.getMovie();
			for (Movie movies : movieLists) {
				if ((adult == true) && (movies.getGenre().equalsIgnoreCase(genre))) {
					System.out.println(movies.toString());
				} else if ((adult == false) && (movies.getGenre() == genre) && (movies.getAgeRating() != "R")) {
					System.out.println(movies.toString());
				}
			}
		} else if (showType == "play") {
			ArrayList<Play> playLists = dataLists.getPlays();
			for (Play plays : playLists) {
				if ((adult == true || adult == false) && (plays.getGenre() == genre)) {
					System.out.println(plays.toString());
				} 
			}
		}
	}
	/**
	 * 
	 * @param adult if they are adult
	 * @param showType type of show movie/play
	 * @param ageRating rating of the show
	 */
	public void searchByAgeRating(boolean adult, String showType, String ageRating) {
<<<<<<< HEAD
		System.out.println("Displaying shows " + showType + " that are rated: " + ageRating);
=======
		System.out.println("Displaying shows " + showType + "that are rated: " + ageRating);
>>>>>>> eeba13c2651a20c185979b0e67a1950ae3ac5f69
		DataLists dataLists = DataLists.getInstance();
		if (showType.equalsIgnoreCase("movie")) {
			ArrayList<Movie> movieLists = dataLists.getMovie();
			for (Movie movies : movieLists) {
				if ((adult == true) && (movies.getAgeRating().equalsIgnoreCase(ageRating))) {
					System.out.println(movies.toString());
				} else if ((adult == false) && (ageRating.equalsIgnoreCase("R"))) {
					System.out.println("You are not old enough to view these movies");
				}
			}
		}
	}
	/**
	 * Searching by which theaters are playing movies
	 * @param theaterName
	 */
	public void searchByTheater(String theaterName) {
		System.out.println("Displaying shows playing at " +theaterName);
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieLists = dataLists.getMovie();
		ArrayList<Play> playLists = dataLists.getPlays();
		for (Movie movies : movieLists) {
			if (movies.getInTheaters().contains(theaterName)) {
				System.out.println("===============");
				System.out.println(movies.getTitle());
				System.out.println("===============");
			}
		}
		for (Play plays : playLists) {
			if (plays.getInTheaters().contains(theaterName)) {
				System.out.println("===============\n");
				System.out.println(plays.getTitle());
				System.out.println("===============");
			}
		}
	}
}
