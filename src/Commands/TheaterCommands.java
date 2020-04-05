package Commands;

import main.TheaterInterface;
/**
 * 
 * @author Devin Adams
 * This class holds the commands to be loading into our input handler
 * for the command design pattern.
 */
public class TheaterCommands {
	TheaterInterface ti = new TheaterInterface();
	
	public void displayMovies() {	
		ti.displayShows();
	}
	
	public void addMovie() {
		ti.addShow();
	}
	
	public void displayTheaters() {
		ti.displayTheaters();
	}
	
	public void addTheater() {
		ti.addTheater();
	}
}
