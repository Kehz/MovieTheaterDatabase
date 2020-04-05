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
		ti.displayMovies();
	}
	
	public void addMovie() {
		ti.addMovie();
	}
	
	public void displayTheaters() {
		ti.displayTheaters();
	}
	
	public void addTheater() {
		ti.addTheater();
	}
	
	public void addPlay() {
		ti.addPlay();
	}
	
	public void displayPlay() {
		ti.displayPlays();
	}
}
