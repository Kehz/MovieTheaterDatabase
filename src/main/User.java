package main;

import java.util.ArrayList;
import java.util.Scanner;

import JSONParsing.DataLists;
import JSONParsing.DataWriter;

public class User {
	/**
	 * These are the current logged in users info
	 */
	public static String currUserName;
	public static String currPassword;
	public static String currEmail;
	public static int currPoints;
	public static int currAge;
	/**
	 * Variables for our User object. THESE ARE NOT THE CURRENT USER
	 */
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
	
	public void updateCurrentUser(String currUserName,String currPassword, String currEmail, int currPoints, int currAge ) {
		User.currUserName = currUserName;
		User.currPassword = currPassword;
		User.currEmail = currEmail;
		User.currPoints = currPoints;
		User.currAge = currAge;
	}
	
	public void displayCurrentUserInfo() {
		System.out.println("\n UserName: " +currUserName + "\n Password: " + currPassword + "\n Email: " + currEmail + "\n Point total: " + currPoints + "\n Age: " + currAge);
	}
	/**
	 * Updates the username of the current logged in user and good example of how
	 * to change data in our jsons
	 */
	public void updateUserName() {
		Scanner scanner = new Scanner(System.in);
		DataLists dataLists = DataLists.getInstance(); //Pulls instance of the data list class
		ArrayList<User> userList = dataLists.getUsers(); //Grabs the current list of users/movies/plays
		System.out.println("******** Updating Username ********");
		for(User users : userList) {
			if (users.getUsername() == currUserName) {
				System.out.println("Enter Username: ");
				users.setUsername(scanner.nextLine());
				DataWriter.saveUsers(); // need to call this to save to our json savePlays() / saveMovies() etc...
			}
		}
		
		System.out.println("You must log back in with your new info to update the changes. \n Type 'logout' to logout");
	}
	/**
	 * Current idea is to add a ticket into an array of some sort and fill that array
	 * with data from ArrayList<Movie/Play> and data from ArrayList<Theater> and 
	 * then add be able to print out the contents of that array to a pretty looking ticket.txt
	 * printTicket can also be another function. May need to add an object to the users.json if 
	 * we want to save the data of the cart to be used later. Each play/theater/movie has an id for easy ordering.
	 * Should also ask if you want to use rewards points for a discount i guess you can integrate that however you like
	 */
	public void orderTicket() {
		
	}
	/**
	 * display current rewards maybe might just integrate this witht he main menu of the user when its finished
	 * ex.) ________ [user_name] _____[points]______
	 * 		Command 1.)
	 * 		Command 2.)
	 * 		Command 3.)
	 */
	public void displayRewards() {
		
	}
	
	
	public void requestRefund() {
		
	}
	
	public void deleteAccount() {
		
	}
	/**
	 * still need to work with how this is dealt.
	 */
	public void useDiscount() {
		
	}
	/**
	 * will probably take in the shopping cart and add the tickets to your account
	 * again this may need further modifications to our users.json or maybe can be done simpler
	 * 
	 */
	public void checkout() {
		
	}
	/**
	 * printing out the tickets in our list of current owned tickets to a .txt file
	 * 
	 */
	public void printTicket() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Getters and Setters for our User object
	 */
	public String getUsername() {
		return username;
	}

	public String getCurrUserName() {
		return currUserName;
	}

	public void setCurrUserName(String currUserName) {
		this.currUserName = currUserName;
	}

	public String getCurrPassword() {
		return currPassword;
	}

	public void setCurrPassword(String currPassword) {
		this.currPassword = currPassword;
	}

	public String getCurrEmail() {
		return currEmail;
	}

	public void setCurrEmail(String currEmail) {
		this.currEmail = currEmail;
	}

	public int getCurrPoints() {
		return currPoints;
	}

	public void setCurrPoints(int currPoints) {
		this.currPoints = currPoints;
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
	
}
