package main;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class TheatersTest {

	@Test
	public void createTheater() {	
		ArrayList<String> reviews= new ArrayList<String>();
		reviews.add("Good");
		reviews.add("Terrible");
		reviews.add("Meh");
		Theaters test= new Theaters(0001, "Ghostbusters 2", 3, reviews, 12345);
	}
	@Test
	public void testToString() {	
		ArrayList<String> reviews= new ArrayList<String>();
		reviews.add("Good");
		reviews.add("Terrible");
		reviews.add("Meh");
		Theaters test= new Theaters(0001, "Ghostbusters 2", 3, reviews, 12345);
		test.toString();
	}
	@Test
	public void viewReviews() {	
		ArrayList<String> reviews= new ArrayList<String>();
		reviews.add("Good");
		reviews.add("Terrible");
		reviews.add("Meh");
		Theaters test= new Theaters(0001, "Ghostbusters 2", 3, reviews, 12345);
		for(int i=0;i<reviews.size();i++)
		{
			System.out.println(reviews.get(i));
		}
	}
	@Test
	public void testEmployeeID() {
		ArrayList<String> reviews= new ArrayList<String>();
		reviews.add("Good");
		reviews.add("Terrible");
		reviews.add("Meh");
		Theaters test= new Theaters(0001, "Ghostbusters 2", 3, reviews, 12345);
		System.out.println(test.getEmployeeID());
	}
	@Test
	public void testTitle() {
		ArrayList<String> reviews= new ArrayList<String>();
		reviews.add("Good");
		reviews.add("Terrible");
		reviews.add("Meh");
		Theaters test= new Theaters(0001, "Ghostbusters 2", 3, reviews, 12345);
		System.out.println(test.getTitle());
	}

}
