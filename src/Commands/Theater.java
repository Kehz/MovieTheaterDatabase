package Commands;

import main.TheaterInterface;

public class Theater {
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
