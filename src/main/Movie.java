package main;

import java.util.ArrayList;

public class Movie extends Show {
	private int releaseYear;
	private String ageRating;
	public Movie(int id, String title, int length, String genre, String director, int rating, ArrayList<String> reviews,ArrayList<String> showTimes, ArrayList<String> inTheaters, String ageRating, int releaseYear) {
		super(id,title, length, genre, director, rating, reviews, showTimes, inTheaters);
		this.ageRating = ageRating;
		this.releaseYear = releaseYear;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getAgeRating() {
		return ageRating;
	}
	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

	public String toString() {
		return "\n ID: " + super.getId() + "\n Title: " + super.getTitle() + "\n Length (Minutes): " + super.getLength()
				+ "\n Genre: " + super.getGenre() + "\n Director: " + super.getDirector() + "\n Rating: " + super.getRating()
				+ "\n Reviews: " + super.getReviews() + "\n Show Times: " + super.getShowTimes() + "\n Playing at: " + super.getInTheaters()
				+ "\n Age Rating: " + getAgeRating() + "\n Release Year: " + getReleaseYear();
		
	}
}
