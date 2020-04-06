package main;
import java.util.Scanner;

public class User {
	Scanner in = new Scanner(System.in);
	private String username;
	private String password;
	private String email;
	private int age;
	private int discountID;
	private int points;
	/**
	 * 
	 * @param username - Users username
	 * @param password - Users password
	 * @param email - Users email
	 * @param age - Users age
	 * @param points - Users points
	 */
	public User(String username, String password, String email, int age, int points) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.points = points;
	}
	
	
	

	/*
	 * Getters and Setters for our User object
	 */
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDiscountID() {
		return discountID;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public void orderTicket() {
		viewTheaters();
		viewShows();
		reserveSeating();
		checkout();
	}
	
	public void viewTheaters() {
		//need instance of TheaterInterface
		TheaterInterface thing= new TheaterInterface();//just to make sure the logic is right
		thing.displayTheaters();
		//select a theater
		System.out.println("What theater would you like to select?");
		//type in selection
		String selection;
		selection=in.nextLine();
		//check to see if there is a match in the arraylist, then set that to selection
		//return selection
	}
	
	public void viewShows() {
		//need instance of TheaterInterface
		TheaterInterface thing= new TheaterInterface();//just to make sure the logic is right
		thing.displayMovies();
		thing.displayPlays();
		//select a show
		System.out.println("What show would you like to select?");
		//type in selection
		String selection;
		selection=in.nextLine();
		//check to see if there is a match in the arraylists, then set that to selection
		//return selection
	}
	
	public void reserveSeating() {
		Show temp = new Show();//just a placeholder
		Boolean[][] seats=temp.getSeating();
		System.out.println("What row would you like to select?");
		//type in seat selection
		int row;
		row=in.nextInt();
		System.out.println("What column would you like to select?");
		//type in seat selection
		int column;
		column=in.nextInt();
		seats[row][column]=true;
		temp.setSeating(seats);
	}
	
	public void checkout() {
		Show temp = new Show();//just a placeholder
		double cost= temp.getPrice();
		System.out.println("A ticket to this show will cost " + cost + " dollars");
		//implement discount methods here
		double payment= in.nextDouble();
	}
}
