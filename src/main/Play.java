package main;

public class Play extends Show {
	private int amountActors;
	private int timesPerformed;
	public Play(int id, String title, int length, String genre, String director, int rating, String reviews, String showTimes, Boolean[][] seating, double price, int amountActors, int timesPerformed) {
		super(id,title, length, genre, director, rating, reviews, showTimes, seating, price);
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
}
