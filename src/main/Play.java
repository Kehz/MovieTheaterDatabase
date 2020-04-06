package main;

import java.util.ArrayList;

public class Play extends Show {
	private int amountActors;
	private int timesPerformed;
	public Play(int id, String title, int length, String genre, String director, int rating, ArrayList<String> reviews, ArrayList<String> showTimes, ArrayList<String> inTheaters, int amountActors, int timesPerformed) {
		super(id,title, length, genre, director, rating, reviews, showTimes, inTheaters);
		this.amountActors = amountActors;
		this.timesPerformed = timesPerformed;
	}
	public int getAmountActors() {
		return amountActors;
	}
	public void setAmountActors(int amountActors) {
		this.amountActors = amountActors;
	}
	public int getTimesPerformed() {
		return timesPerformed;
	}
	public void setTimesPerformed(int timesPerformed) {
		this.timesPerformed = timesPerformed;
	}
	
	public String toString() {
		return "\n ID: " + super.getId() + "\n Title: " + super.getTitle() + "\n Length (Minutes): " + super.getLength()
				+ "\n Genre: " + super.getGenre() + "\n Director: " + super.getDirector() + "\n Rating: " + super.getRating()
				+ "\n Reviews: " + super.getReviews() + "\n Show Times: " + super.getShowTimes() + "\n Playing at: " + super.getInTheaters()
				+ "\n Amount of Actors: " + getAmountActors() + "\n Times Peformed: " + getTimesPerformed();
		
	}
}
