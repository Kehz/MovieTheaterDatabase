package main;
/*
 * Will modify this at some point to contain properly hold values from movie/play
 */
public class Show {
	private int id;
	private String title;
	private int length;
	private String genre;
	private String director;
	private int rating;
	private String reviews;
	private String showTimes;
	
	public Show(int id, String title, int length, String genre, String director, int rating, String reviews, String showTimes) {
		this.id = id;
		this.title = title;
		this.length = length;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
		this.reviews = reviews;
		this.showTimes = showTimes;
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

	public String getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(String showTimes) {
		this.showTimes = showTimes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
