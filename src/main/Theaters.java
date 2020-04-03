package main;

public class Theaters {
	private String title;
	private int ratings;
	private String reviews;
	
	
	public Theaters(String title, int ratings, String reviews) {
		this.title = title;
		this.ratings = ratings;
		this.reviews = reviews;
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

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	
}
