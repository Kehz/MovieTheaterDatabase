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
	private int points;
	private int employeeID;
	private int discountType;
	private ArrayList<String> shoppingCart;
	private ArrayList<String> ticketCart;
	/**
	 * 
	 * @param username - Users username
	 * @param password - Users password
	 * @param email - Users email
	 * @param age - Users age
	 * @param points - Users points
	 */
	public User(String username, String password, String email, int age, int points, int employeeID, int discountType, ArrayList<String> shoppingCart, ArrayList<String> ticketCart) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.points = points;
		this.employeeID = employeeID;
		this.discountType = discountType;
		this.shoppingCart = shoppingCart;
		this.ticketCart = ticketCart;
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
	 * Testing adding reviews to a movie array in the JSON. (it works)
	 */
	public void testFunction() {
		System.out.println("Command Fired"); //just testing to see if they command is executed
		DataLists dataLists = DataLists.getInstance(); //Pulls instance of the data list class. This is important because it gives us access to load commands
		ArrayList<Movie> movieList = dataLists.getMovie(); //grabbing the Movie arraylist from json.
		String searchMovie = "Frozen 2"; //dummy variable for testing
		for(Movie movie : movieList) { //for each loop going through the movie arraylist
			if (movie.getTitle().contentEquals(searchMovie)) { //checking if the movie its searching for exists
				System.out.println("found movie"); //test print out to see if its finding a movie
				ArrayList<String> addReview = movie.getReviews(); //creating an arraylist and setting it equal to the current reviews of the movie ***reviews is an array inside the json so this is why its like that****
				addReview.add("this is testing adding a new review to frozen2"); //adding to the addReview list. Can be any string this is just a test example. Since addReview is a string arraylist it takes in strings
				movie.setReviews(addReview); //calls the mutator for the movie revies and sets it equal to the new arraylist addReview. Remember addReview is equal to the old movie.getReview() so it adds to it this way
				DataWriter.saveMovies(); // Please call this whenever you deal with adding/removing from an ArrayList<Movie/Play/Theater/user> or else it wont save to that current one and the changes wont be reflected in the jsons
			}
		}
	}
	/**
	 * Showing a mockup of how the new array inside the movie/play json "inTheaters" works in the movie/play arraylist and how to modify them.
	 */
	public void testAddTheaterToShowFunction() {
		DataLists dataLists = DataLists.getInstance(); //we know what this does now
		ArrayList<Movie> movieList = dataLists.getMovie(); //grabs movie arraylist from json
		ArrayList<Play> playList = dataLists.getPlays(); //grabs play arraylist from json - dont really use this one in this case but here for example
		ArrayList<Theaters> theaterList = dataLists.getTheaters(); //grabs theater from arraylist
		String theaterToShow = "Spark Theater"; //hard coded variable for testing which theater we want to add to the shows [now playing]
		String showToAddTheater = "The Lion King"; //hard coded variable for testing which movie we want to append the theater to
		boolean valid = false;
		for(Theaters theater : theaterList) {
			if (theater.getTitle().contentEquals(theaterToShow)) { //checking to make sure the theater is a valid theater
				System.out.println("Theater Valid!"); //if theater is valid(in our theater array list) print this
				valid = true; //setting valid to true;
				break; //breaking out of the loop so we dont continue to search for no reason
			} 
		}
		if(!valid) { //if valid is still false (we never found a theater) print out invalid theater and return(exit funciton)
			System.out.println("Invalid Theater");
			return;
		}
		for(Movie movie : movieList) {
			if (movie.getTitle().contentEquals(showToAddTheater)) { //checking if its a valid movie (in our movie arraylist)
				ArrayList<String> addTheater = movie.getInTheaters(); //creating a new array list equal to the current array in the movie json object "inTheaters"
				if(!addTheater.contains(theaterToShow)) { //if the theater is not already in that "inTheaters" array in the json then continue
					System.out.println("Adding " +showToAddTheater+ " to play at " +theaterToShow); //printing out which movie is getting added
					addTheater.add(theaterToShow); //adding the theater to the "inTheaters" copy array list we created
					movie.setInTheaters(addTheater); //setting the newly created array list to the current selected movies "inTheaters" array
					DataWriter.saveMovies();
				} else {
					System.out.println("That theater is already playing that movie"); //if the theater is already playing that movie then print thsi
				}
			}
		}
		
	}
	/**
	 * this is a test function to be used as referecne for ordering the tickets.
	 * this is not the ordet ticket function just a really good reference for it. can probably be broken down into multiple commands
	 * YOU NEED TO BE LOGGED INTO AN ACCOUNT FOR THIS ONE TO WORK BECAUSE ITS COMPARING WITH currUserName WHICH IS ASSIGNED WHENEVER A SUCCESSFULL LOGIN HAPPENS
	 */
	public void testArrayListSizeAndRemoving() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for(User users: userList) {
			if((users.getShoppingCart().contains("Empty Cart")) && (users.getUsername() == currUserName)) { //Default value for users shopping and ticket cart is "Empty Cart". If cart is empty then proceed. currUserName is assigned when you login with an account if guest account then it will be null for now
				System.out.println("Adding tickets to empty cart"); //printing test
				ArrayList<String> addTickets = users.getShoppingCart(); //array list set equal to the current shopping cart
				addTickets.remove(0); //removing the Empty Cart object since in this if statement it should always be at index 0
				addTickets.add("Test Ticket1"); //adding one ticket
				addTickets.add("Test ticket2"); //adding another
				addTickets.add("Test ticket3"); //and another
				users.setShoppingCart(addTickets); //setting the shopping cart equal to addTickets
				DataWriter.saveUsers(); //saving to json
			} else if((!users.getShoppingCart().contains("Empty Cart")) && (users.getUsername().contentEquals(currUserName))) { //if its not "Empty Cart" then it will instead just add the tickets instead of removing index(0)
				System.out.println("Adding tickets");
				ArrayList<String> addTickets = users.getShoppingCart();
				addTickets.add("Test Ticket1");
				addTickets.add("Test ticket2");
				addTickets.add("Test ticket3");
				users.setShoppingCart(addTickets);
				DataWriter.saveUsers();
			}
		}
		//at this point we have a shopping cart
		for(User users : userList) {
			if(users.getUsername() == currUserName) {
				double ticketCount = users.getShoppingCart().size(); //getting the size of the cart. aka how many tickets are inside
				System.out.println(users.getShoppingCart()); // test print out
				System.out.println("Your total is: $" + ticketCount*7.50); //multiplying by 7.50 to simlute the cost of each ticket
				System.out.println("Your tickets will now be removed from cart and added to your ticket list"); //emptying the shopping cart. to simulate checking out and added tickets to your ticketCart 
				ArrayList<String> removeTickets = users.getShoppingCart(); //removeTickets now equal to shopping cart
				ArrayList<String> addTickets = new ArrayList<String>(); //new blank array list so we can safely copy / empty the removeTickets list without dealing with copy values(if we were to make it ArrayList<String> addTickets = users.getShoppingCart() then it would act as a pointer and thats annoying
				if (users.getTicketCart().contains("Empty_Cart")) { //if your current ticket cart is empty the remove the empty cart index
					users.getTicketCart().remove(0); //0 is the index of empty cart
				}
				for(int i = 0; i < users.getShoppingCart().size(); i++) { //indivdually adding the tickets from removeTickets to addTickets to prevent issues with pointers
					addTickets.add(removeTickets.get(i));
				}
				System.out.println(addTickets); //test print
				users.setTicketCart(addTickets); //finalizing our setTicketCart value in the json
				removeTickets.clear(); //deleting our shopping cart
				removeTickets.add("Empty Cart"); //setting it to empty cart to prevent some null issues in the jsons i dont wanna deal with anymore
				users.setShoppingCart(removeTickets); //finalizing our new empty shopping cart
				DataWriter.saveUsers(); //saving to our json
			}
		}
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public ArrayList<String> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ArrayList<String> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ArrayList<String> getTicketCart() {
		return ticketCart;
	}

	public void setTicketCart(ArrayList<String> ticketCart) {
		this.ticketCart = ticketCart;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}
	
}
