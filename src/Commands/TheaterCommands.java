package Commands;

import main.TheaterInterface;
/*
 * This is where we wil place our user commands
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
