package main;

public class Show {
	private String title;
	private int length;
	private int releaseYear;
	private String genre;
	private String director;
	private int rating;
	private String reviews;
	
	public Show(String title, int length, int releaseYear, String genre, String director, int rating, String reviews ) {
		this.title = title;
		this.length = length;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
		this.reviews = reviews;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
}
