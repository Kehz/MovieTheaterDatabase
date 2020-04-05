package main;

public class Movie extends Show {
	private int releaseYear;
	private String ageRating;
	public Movie(int id, String title, int length, String genre, String director, int rating, String reviews,String showTimes, String ageRating, int releaseYear) {
		super(id,title, length, genre, director, rating, reviews, showTimes);
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

}
