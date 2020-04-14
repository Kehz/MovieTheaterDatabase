package main;

import java.util.ArrayList;

/**
 * @author Devin Adams
 * Theater class for handling values
 */
public class Theaters {
	private int id;
	private String title;
	private int ratings;
	private ArrayList<String> reviews;
	private int employeeID;
	
	/**
	 * 
	 * @param title - Theater name
	 * @param ratings - Theater rating
	 * @param reviews - Theater reviews
	 */
	public Theaters(int id, String title, int ratings, ArrayList<String> reviews,int employeeID) {
		this.id = id;
		this.title = title;
		this.ratings = ratings;
		this.reviews = reviews;
		this.employeeID = employeeID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public ArrayList<String> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String toString() {
		return "\n ID: " + getId() + "\n Title: " + getTitle() + "\n Ratings: " + getRatings() + "\n Reviews: " + getReviews();
	}
}