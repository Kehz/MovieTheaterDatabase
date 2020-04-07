package main;

import java.util.ArrayList;

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
	private ArrayList<String> reviews;
	private ArrayList<String> showTimes;
	private ArrayList<String> inTheaters;
	private Boolean[][] seating;

	public Show(int id, String title, int length, String genre, String director, int rating, ArrayList<String> reviews, ArrayList<String> showTimes, ArrayList<String> inTheaters, Boolean[][] seating) {
		this.id = id;
		this.title = title;
		this.length = length;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
		this.reviews = reviews;
		this.showTimes = showTimes;
		this.inTheaters = inTheaters;
		this.seating=seating;
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
	public ArrayList<String> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}

	public ArrayList<String> getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(ArrayList<String> showTimes) {
		this.showTimes = showTimes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getInTheaters() {
		return inTheaters;
	}

	public void setInTheaters(ArrayList<String> inTheaters) {
		this.inTheaters = inTheaters;
	}
	public Boolean[][] getSeating(){
		return seating;
	}

	public void setSeating(Boolean[][]seating) {
		this.seating=seating;
	}
}
    
