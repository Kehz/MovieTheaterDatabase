package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import JSONParsing.DataLists;
import JSONParsing.DataWriter;

public class User {
	public static String currUserName;
	public static String currPassword;
	public static String currEmail;
	public static int currPoints;
	public static int currAge;
	public static String workingAt;
	public static int currEmployeeID;
	private Scanner scanner;
	protected String[] guestMenuOptions = {"Order Tickets", "Display Movies", "Display Plays" , "Search Shows", "Logout"};
	protected String[] memberMenuOptions = {"Order Tickets", "Display Movies", "Display Plays" , "Search Shows",
			"Checkout", "Refund", "Print Tickets","View Shopping Cart", "View Ticket List", "Change Account Details", "Logout"};
	protected String[] employeeMenuOptions = {"Add Show To Theater", "Update Show Times", "Enter Movie", "Enter Play","Display Movies","Display Plays", "Logout"};
	protected String username;
	protected String password;
	protected String email;
	protected int age;
	protected int points;
	protected int employeeID;
	protected int discountType;
	protected ArrayList<String> shoppingCart;
	protected ArrayList<String> ticketCart;
	/**
	 * 
	 * @param username - Users username
	 * @param password - Users password
	 * @param email - Users email
	 * @param age - Users age
	 * @param points - Users point
	 * @param employee id - id associated with their workplace
	 * @param discountType - associated discount type
	 * @param shoppingCart - the list of ticket not yet purchased
	 * @parem ticketCart - the list of tickets that have been purchased
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
		scanner = new Scanner(System.in);
	}
	/**
	 * 
	 * @param currUserName - instance of logged in username
	 * @param currPassword - instance of logged in password
	 * @param currEmail - instance of logged in email
	 * @param currPoints - instance of logged in points
	 * @param currAge - instance of logged in age
	 */
	public void updateCurrentUser(String currUserName,String currPassword, String currEmail, int currPoints, int currAge) {
		User.currUserName = currUserName;
		User.currPassword = currPassword;
		User.currEmail = currEmail;
		User.currPoints = currPoints;
		User.currAge = currAge;
	}
	/**
	 * Updating our current points to be displayed
	 * @param points - points
	 */
	public void updatePoints(int points) {
		currPoints = points;
	}
	/**
	 * Printing menu per usertype
	 * 0 = guest
	 * 1 = member
	 * 2 = theater employee
	 */
	public void userMainMenu() {
		System.out.println("\nMovie Theater Application ");
		int currentUserType = getUserType();
		if (currentUserType == 0) {
			printGuestMenu();
		} else if (currentUserType == 1) {
			printMemberMenu();
		} else if (currentUserType == 2) {
			printEmployeeMenu();
		}
	}
	/**
	 * Gets our current users account type
	 * @return integer based on userType
	 * 0 = guest
	 * 1 = member
	 * 2 = theater employee
	 */
	private int getUserType() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		if(currUserName == null) {
			currEmployeeID = 0;
			return 0;
		} 
		for(User users : userList) {
			if ((users.getUsername() == currUserName) && (users.getEmployeeID() == 0)) {
				currEmployeeID = 0;
				return 1;
			} else if ((users.getUsername() == currUserName) && (users.getEmployeeID() != 0)) {
				currEmployeeID = users.getEmployeeID();
				updateEmployeeWorking();
				return 2;
			}
		}
		System.out.println("Error! Unable to get the user type. Proceeding as guest. (How did this happen?)");
		return 0;
	}
	/**
	 * updates the title of where our current employee is working
	 */
	private void updateEmployeeWorking() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theaterList = dataLists.getTheaters();
		for(Theaters theaters : theaterList) {
			if(theaters.getEmployeeID() == currEmployeeID) {
				workingAt = theaters.getTitle();
				return;
			}
		}
	}
	/**
	 * printing the guest menu
	 */
	private void printGuestMenu() {
		System.out.println("\nMember: Guest");
		System.out.println("=========================");
		for (int i = 0; i < guestMenuOptions.length; i++) {
			System.out.println(guestMenuOptions[i]);
		}
		System.out.println("=========================");
	}
	/**
	 * printing the member menu
	 */
	private void printMemberMenu() {
		System.out.println("\nMember: " + currUserName + " Points: " + currPoints);
		System.out.println("=========================");
		for(int i = 0; i < memberMenuOptions.length; i++) {
			System.out.println(memberMenuOptions[i]);
		}
		System.out.println("=========================");
	}
	/**
	 * printing the employee menu
	 */
	private void printEmployeeMenu() {
		System.out.println("\nMember: " + currUserName + " Theater: " + workingAt);
		System.out.println("=========================");
		for(int i = 0; i < employeeMenuOptions.length; i++) {
			System.out.println(employeeMenuOptions[i]);
		}
		System.out.println("=========================");
	}
	/**
	 * prompts for changing user details 
	 */
	public void changeAccountDetails() {
		String[] options = {"Change Username", "Change password", "Change email", "Delete Account"};
		for (int i = 0; i < options.length; i++) {
			System.out.println(i+1 + ". " + options[i]);
		}
		System.out.println("Enter Option Number");
		int input = scanner.nextInt();

		if (input == 1) {
			updateUserName();
			return;
		} else if (input == 2) {
			updatePassword();
			return;
		} else if (input == 3) {
			updateEmail();
			return;
		} else if (input == 4){
			deleteAccount();
		} else {
			System.out.println("Invalid Command");
		}

	}
	/**
	 * Updates the users username
	 */
	private void updateUserName() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers(); 
		System.out.println("******** Updating Username ********");
		for(User users : userList) {
			if (users.getUsername() == currUserName) { 
				System.out.println("Enter Username: ");
				users.setUsername(scanner.nextLine());
				DataWriter.saveUsers();
			}
		}
		System.out.println("You must log back in with your new info to update the changes. \n Type 'logout' to logout");
	}
	/**
	 * updates password
	 */
	private void updatePassword() {
		DataLists dataLists = DataLists.getInstance(); 
		ArrayList<User> userList = dataLists.getUsers(); 
		System.out.println("******** Updating Password ********");
		for(User users : userList) {
			if (users.getPassword() == currPassword) { 
				System.out.println("Enter New Password: ");
				users.setPassword(scanner.nextLine());
				DataWriter.saveUsers();
			}
		}
		System.out.println("You must log back in with your new info to update the changes. \n Type 'logout' to logout");
	}
	/**
	 * updates email
	 */
	private void updateEmail() {
		DataLists dataLists = DataLists.getInstance(); 
		ArrayList<User> userList = dataLists.getUsers();
		System.out.println("******** Updating Email ********");
		for(User users : userList) {
			if (users.getEmail() == currEmail) { 
				System.out.println("Enter New Email: ");
				users.setEmail(scanner.nextLine());
				DataWriter.saveUsers();
			}
		}
		System.out.println("You must log back in with your new info to update the changes. \n Type 'logout' to logout");
	}
	
	/**
	 * Allows the user to order a ticket. If its a guest user they will be prompted to print right away and wont be able to choose seating
	 * If user then it will add it to the users shopping cart for later checkout
	 */
	public void orderTicket() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		System.out.println("Enter the name of the show you would like to order tickets of: ");
		String showName = scanner.nextLine();
		boolean validShow = printShow(showName);
		if (validShow) {
			return;
		}
		System.out.println("=======================================================");
		printPlayingIn(showName);
		System.out.println("=======================================================");
		System.out.println("\nWhich theater would you like to view the show at: ");
		String theaterName = scanner.nextLine();
		boolean validTheater = printShowTimes(theaterName);
		if (validTheater) {
			System.out.println("Incorrect input!");
		}
		System.out.println("========================================================");
		System.out.println("\nWhich time would you like to watch:\n");
		printShowTimes(showName);
		String showTimes = scanner.nextLine();
		if (!isValidShowTime(showTimes)) {
			System.out.println("Invalid showtime!");
			return;
		}
		if (getUserType() == 0) {
			System.out.println("\nHow many tickets would you like to order:");
			double ticketAmount = scanner.nextInt();
			System.out.println("Your total is $" + ticketAmount*7.50 + " and you have been billed accordingly");
			System.out.println("Printing out your tickets now..........");
			printGuestTicket(showName, theaterName, showTimes, ticketAmount);
			return;
		}
		String seating = chooseSeating();
		String ticket = showName + "," +theaterName+ "," +showTimes+","+seating;
		for (User users : userList) {
			if (users.getUsername() == currUserName) {
				if (users.getShoppingCart().contains("Empty Cart")) {
					users.getShoppingCart().remove(0);
				}
				System.out.println("Adding ticket to your shopping cart. \nInitiate the Checkout Command to checkout");
				users.getShoppingCart().add(ticket);
				System.out.println("Current Shopping Cart: ");
				System.out.println(users.getShoppingCart());
				DataWriter.saveUsers();
			}
		}
	}
	/**
	 * Prints the guests ticket to ticket.txt
	 * @param showName - show name on ticket
	 * @param theaterName - theater name on ticket
	 * @param showTime - show time registered
	 * @param ticketAmount - amount of tickets ordered
	 */
	private void printGuestTicket(String showName, String theaterName, String showTime, double ticketAmount) {
		try {
			FileWriter writer = new FileWriter("ticket.txt", true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			for (int i = 0; i < ticketAmount; i++) {
				bWriter.write("********************************************************");
				bWriter.newLine();
				bWriter.write("************************ TICKET ************************");
				bWriter.newLine();
				bWriter.write("*************** Movie: " + showName + " ***************");
				bWriter.newLine();
				bWriter.write("*************** Show time: " + showTime + " ***************");
				bWriter.newLine();
				bWriter.write("*************** Theater: " + theaterName + " ***************");
				bWriter.newLine();
				bWriter.write("************************ THANKS FOR SHOPPING **************");
				bWriter.newLine();
				bWriter.write("********************************************************");
				bWriter.newLine();
				bWriter.newLine();
				bWriter.newLine();
				bWriter.newLine();
			}
			bWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Generates seating chart and allows user to pick from any open seats
	 * @return string based on where they are sitting ex) A3
	 */
	private String chooseSeating() {
		char[] letters = {'A','B','C','D','E','F','G','H','I','J'};
		char[][] seatingArray = new char[10][10];
		for (int i = 0; i < seatingArray.length; i++) {
			for (int j = 0; j < seatingArray.length; j++) {
				seatingArray[i][j] = takingSeatsGen();
			}
		}
		for (int i = 0; i < seatingArray.length; i++) {
			System.out.print(letters[i] + ": ");
			for (int j = 0; j < seatingArray.length; j++) {
				System.out.print("[" + seatingArray[i][j] + "]");
			}
			System.out.println();
		}

		System.out.println("Where would you like to sit?\n [X = Taken] / [O = Open]");
		System.out.println("Enter Row (A-J): ");
		char rowSpot = scanner.next().charAt(0);
		int rowIndex = 0;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == rowSpot) {
				rowIndex = i;
			}
		}
		System.out.println("testing row index value" + rowIndex);
		System.out.println("Enter Seat in row (0-9)");
		int colIndex = scanner.nextInt();
		if (seatingArray[rowIndex][colIndex] == 'O') {
			StringBuilder seating = (new StringBuilder()).append(rowSpot).append(colIndex);
			String seat = seating.toString();
			System.out.println(seat);
			return seat;
		}
		String notAvailable = "Seating isn't available for that spot";
		return notAvailable;
	}
	/**
	 * helper method for choosingSeats()
	 * @return random choice of either 0 or X
	 */
	private char takingSeatsGen() {
		Random rand = new Random();
		int randomValue = rand.nextInt(2);
		if (randomValue == 1) {
			return 'O';
		} else if (randomValue == 0) {
			return 'X';
		}
		return 'O';
	}
	/**
	 * Printing the show and checking if its valid
	 * @param showName
	 * @return if its a valid show = true. False if not
	 */
	private boolean printShow(String showName) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie(); 
		ArrayList<Play> playList = dataLists.getPlays();
		boolean validShow = false;
		for (Movie movies : movieList) {
			if (movies.getTitle().equalsIgnoreCase(showName)) {
				System.out.println(movies.toString());
				return validShow;
			}
		}
		for (Play plays : playList) {
			if (plays.getTitle().equalsIgnoreCase(showName)) {
				System.out.println(plays.toString());
				return validShow;
			}
		}
		if (validShow == false) {
			System.out.println("Error finding show. Please try again!");
			return validShow;
		}
		return false;
	}
	/**
	 * Printing the theaters that are playing the movie and checks if theater is valid
	 * @param showName - show name for finding out whether the movie is playing in a theater
	 */
	private void printPlayingIn(String showName) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie(); 
		ArrayList<Play> playList = dataLists.getPlays();
		for (Movie movies : movieList) {
			if (movies.getTitle().equalsIgnoreCase(showName)) {
				System.out.println("The movie is currently playing at these locations");
				System.out.println(movies.getInTheaters());
				return;
			}
		}
		for (Play plays : playList) {
			if (plays.getTitle().equalsIgnoreCase(showName)) {
				System.out.println("The play is currently playing at these locations");
				System.out.println(plays.getInTheaters());
				return;
			}
		}
	}
	/**
	 * takes in theater name and checks to see what the show times are
	 * @param theaterName
	 * @return true if valid theater false if not
	 */
	private boolean printShowTimes(String theaterName) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie(); 
		ArrayList<Play> playList = dataLists.getPlays(); 
		for (Movie movies : movieList) {
			if (movies.getTitle().equalsIgnoreCase(theaterName)) {
				System.out.println("Show times for: " + theaterName);
				System.out.println(movies.getShowTimes());
				return true;
			}
		}
		for (Play plays : playList) {
			if (plays.getTitle().equalsIgnoreCase(theaterName)) {
				System.out.println("Show times for : " + theaterName);
				System.out.println(plays.getShowTimes());
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks to see if showtime inputted is valid
	 * @param showTime taking in showtime to see if its valid
	 * @return true if valid/false if not
	 */
	private boolean isValidShowTime(String showTime) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie(); 
		ArrayList<Play> playList = dataLists.getPlays(); 
		for (Movie movies : movieList) {
			if (movies.getShowTimes().contains(showTime)) {
				return true;
			}
		}
		for (Play plays : playList) {
			if (plays.getShowTimes().contains(showTime)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Command for the user to add a review 
	 */
	private void addReviewToMovieInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the movie you'd like to review: ");
		String showName = input.nextLine();
		System.out.println("Reviewing: " +showName);
		String showType = isShowValid(showName);
		System.out.println("Enter your review");
		String review = input.nextLine();
		addReviewToMovie(showType, showName, review);
	}
	/**
	 * 
	 * @param showType takes in show type
	 * @param movieName takes in movie name
	 * @param review review the user is leaving on the page
	 */
	private void addReviewToMovie(String showType, String movieName, String review) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		ArrayList<Play> playList = dataLists.getPlays();
		if (showType.equalsIgnoreCase("movie") ) {
			for(Movie movie : movieList) {
				if (movie.getTitle().equalsIgnoreCase(movieName)) {
					ArrayList<String> addReview = movie.getReviews();
					addReview.add(review);
					movie.setReviews(addReview); 
					DataWriter.saveMovies();
				}
			}
		} else if (showType.equalsIgnoreCase("play")) {
			for(Play plays : playList) {
				if (plays.getTitle().equalsIgnoreCase(movieName)) {
					ArrayList<String> addReview = plays.getReviews();
					addReview.add(review);
					plays.setReviews(addReview); 
					DataWriter.savePlays();
				}
			}
		}
	}
	/**
	 * chekcing if a show is valid
	 * @param showName
	 * @return returning whether show is a movie or play
	 */
	private String isShowValid(String showName) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		ArrayList<Play> playList = dataLists.getPlays();
		String movie = "movie";
		String play = "play";
		for (Movie movies : movieList) {
			if (movies.getTitle().equalsIgnoreCase(showName)) {
				return movie;
			}
		}
		for (Play plays : playList) {
			if (plays.getTitle().equalsIgnoreCase(showName)) {
				return play;
			}
		}
		return "Invalid Show";
	}

	/**
	 * allows the worker to a movie to their theater easily
	 */
	public void workerAddTheaterShow() {
		System.out.println("Enter the show you would like to add to your theater");
		String showName = scanner.nextLine();
		String theaterName = workingAt;
		System.out.println("Is this show a Play or a Movie?:");
		String showType = scanner.nextLine();
		addTheaterToShowFunction(showName, theaterName, showType);
	}
	/**
	 * 
	 * @param showName show adding to theeater
	 * @param theaterName theater the show is being added to
	 * @param showType play / movie
	 */
	private void addTheaterToShowFunction(String showName, String theaterName, String showType) {
		DataLists dataLists = DataLists.getInstance(); 
		ArrayList<Movie> movieList = dataLists.getMovie(); 
		ArrayList<Play> playList = dataLists.getPlays(); 
		ArrayList<Theaters> theaterList = dataLists.getTheaters(); 
		boolean valid = false;
		for(Theaters theater : theaterList) {
			if (theater.getTitle().contentEquals(theaterName)) { 
				System.out.println("Theater Valid!"); 
				valid = true; 
				break; 
			} 
		}
		if (showType.equalsIgnoreCase("movie")) {
			for(Movie movie : movieList) {
				if (movie.getTitle().contentEquals(showName)) {
					ArrayList<String> addTheater = movie.getInTheaters();
					if(!addTheater.contains(theaterName)) {
						System.out.println("Adding " +showName+ " to play at " +theaterName);
						addTheater.add(theaterName);
						movie.setInTheaters(addTheater);
						DataWriter.saveMovies();
					} else {
						System.out.println("That theater is already playing that movie"); 
					}
				}
			}
		} else if (showType.equalsIgnoreCase("play")) {
			for(Play plays : playList) {
				if (plays.getTitle().contentEquals(showName)) { 
					ArrayList<String> addTheater = plays.getInTheaters(); 
					if(!addTheater.contains(theaterName)) { 
						System.out.println("Adding " +showName+ " to play at " +theaterName);
						addTheater.add(theaterName);
						plays.setInTheaters(addTheater);
						DataWriter.savePlays();
					} else {
						System.out.println("That theater is already playing that movie");
					}
				}
			}
		}
	}

	/**
	 * Removes the tickets from a users owned tickets and refunds the money back
	 */
	public void requestRefund() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for(User users : userList) {
			double total = 0.0;
			if(users.getUsername() == currUserName) {
				for(int i = 0; i < users.getTicketCart().size(); i++) {
					users.getTicketCart().remove(i); //could just display message that their card will be refunded instead of dealing with a wallet
					total += 7.50;
				}
				users.getTicketCart().add("Empty Cart");
				DataWriter.saveUsers();
			}
			System.out.println("Your card will be refunded $" + total + " for the refunded tickets.");
		}
	}
	/**
	 * Removes the data from the users list.
	 * 
	 */
	private void deleteAccount() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for(User users : userList) {
			if(users.getUsername() == currUserName) {
				userList.remove(users);
				DataWriter.saveUsers();
			}
		}
		System.out.println("You must now logout to see changes");
	}
	/**
	 * applies discount to the price
	 * @deprecated
	 */
	public void useDiscount() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for(User users : userList) {
			if(users.getUsername() == currUserName) {
				System.out.println("Enter your discount id.");
				int discId = scanner.nextInt();
				users.setDiscountType(discId);
				DataWriter.saveUsers();
			}
		}
	}
	/**
	 * Grabs the users shopping cart and removes the items from it.
	 * Then it totals the price and adds the tickets to your owned ticket list ticketCart
	 */
	public void checkout() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		double price = 0.0;
		for(User users : userList) {
			if(users.getUsername() == currUserName)  {
				price = users.getShoppingCart().size()*7.50;
				ArrayList<String> removeTickets = users.getShoppingCart(); 
				ArrayList<String> addTickets = users.getTicketCart();
				if (users.getTicketCart().contains("Empty Cart")) { 
					users.getTicketCart().remove(0); 
				}
				for(int i = 0; i < users.getShoppingCart().size(); i++) {
					addTickets.add(removeTickets.get(i));
				}
				System.out.println(addTickets);
				users.setTicketCart(addTickets); 
				removeTickets.clear(); 
				removeTickets.add("Empty Cart"); 
				users.setShoppingCart(removeTickets);
				DataWriter.saveUsers(); 
				System.out.println("The total price of the tickets in your cart is $" + price);
				System.out.println("Use Show Tickets to show your currently owned tickets");
			}
		}
	}
	/**
	 * shows currently owned tickets
	 */
	public void showTickets() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for (User users : userList) {
			if (users.getUsername() == currUserName) {
				System.out.println(users.getTicketCart());
			}
		}
	}
	/**
	 * sim command meant for running scenerio 2
	 */
	public void watchMovie() {
		System.out.println("Watching the movie!!!!!!!");
		System.out.println("The movie has finished!!!!!");
		addReviewToMovieInput();
		System.out.println("Rate the movie!!!!!!");
		rateMovie();
		removeTicketCart();
		System.out.println("Thanks for using our app!\nHere is 100 points for reviewing!!!!!!!");
		addPoints(100);
	}
	/**
	 * adds points to the current user whenever called
	 */
	private void addPoints(int points) {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for (User users : userList) {
			if (users.getUsername() == currUserName) {
				users.setPoints(users.getPoints()+points);
				updatePoints(users.getPoints());
				DataWriter.saveUsers();
				return;
			}
		}
	}
	/**
	 * command for rating a movie [1-5]
	 */
	private void rateMovie() {
		System.out.println("Enter the name of the show you want to rate");
		String showName = scanner.nextLine();
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Movie> movieList = dataLists.getMovie();
		ArrayList<Play> playList = dataLists.getPlays();
		System.out.println("Enter the rating of the movie! [1-5]");
		int rating = scanner.nextInt();

		for (Movie movies : movieList) {
			if (movies.getTitle().equalsIgnoreCase(showName)) {
				movies.setRating(rating);
				DataWriter.savePlays();
				return;
			}
		}
		for (Play plays : playList) {
			if (plays.getTitle().equalsIgnoreCase(showName)) {
				plays.setRating(rating);
				DataWriter.savePlays();
			}
		}
	}
	/**
	 * removes the tickets from your ticketCart after watching a movie
	 */
	private void removeTicketCart() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for (User users : userList) {
			if (users.getUsername() == currUserName) {
				for (int i = 0; i < users.getTicketCart().size();i++) {
					users.getTicketCart().remove(i);
				}
				users.getTicketCart().add("Empty Cart");
				DataWriter.saveUsers();
			}
		}
	}

	public void printShoppingCart() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for (User users : userList) {
			if (users.getUsername() == currUserName) {
				System.out.println(users.getShoppingCart());
				return;
			}
		}
	}
	/**
	 * Takes in the ticket stored in ticketCart and prints it to memberticket.txt
	 */
	public void printUserTicketInfo() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		if (checkTicketCartEmpty() == true) {
			System.out.println("Printing Your Owned Ticket");
			for (User users : userList) {
				if (users.getUsername() == currUserName) {
					for (int i = 0; i < users.getTicketCart().size(); i++) {
						String ticket = users.getTicketCart().get(i);
						String[] ticketInfo = ticket.split(",");
						String showName = ticketInfo[0];
						String theaterName = ticketInfo[1];
						String showTime = ticketInfo[2];
						String seating = ticketInfo[3];
						printUserTicket(showName, theaterName, showTime, seating);
					}
				}
			}
		}
	}
	/**
	 * checking if ticket cart is empty
	 * @return true if not | false if it is
	 */
	private boolean checkTicketCartEmpty() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<User> userList = dataLists.getUsers();
		for (User users : userList) {
			if (users.getUsername() == currUserName) {
				if (!users.getTicketCart().contains("Empty Cart")) {
					return true;
				}
			}
		}
		System.out.println("No tickets in your list");
		return false;
	}
	/**
	 * Prints the members ticket to a file
	 * @param showName - 
	 * @param theaterName
	 * @param showTime
	 * @param seating
	 */
	private void printUserTicket(String showName, String theaterName, String showTime, String seating) {
		try {
			FileWriter writer = new FileWriter("memberticket.txt", true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write("********************************************************");
			bWriter.newLine();
			bWriter.write("************************ TICKET ************************");
			bWriter.newLine();
			bWriter.write("*************** Movie: " + showName + " ********************");
			bWriter.newLine();
			bWriter.write("*************** Show time: " + showTime + " ******************");
			bWriter.newLine();
			bWriter.write("*************** Theater: " + theaterName + " ********************");
			bWriter.newLine();
			bWriter.write("*************** Theater Seating: " + seating + " ********************");
			bWriter.newLine();
			bWriter.write("************************ THANKS FOR SHOPPING **************");
			bWriter.newLine();
			bWriter.write("********************************************************");
			bWriter.newLine();
			bWriter.newLine();
			bWriter.newLine();
			bWriter.newLine();
			bWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Allows the user to search shows based off of provided values
	 */
	public void searchShows() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<Theaters> theatersList = dataLists.getTheaters();
		ShowSearch search = new ShowSearch();
		String[] searchList = {"Search By Genre", "Search by Age Rating", "Search By Theaters"};
		for (int i = 0; i < searchList.length; i++) {
			System.out.println(i+1 + " " + searchList[i]);
		}
		System.out.println("Enter value: ");
		int input = scanner.nextInt();
		System.out.println();
		scanner.nextLine();
		boolean isAdult = isAdult();
		if (input == 1) {
			System.out.print("\nEnter either 'movie' or 'play': " );
			String showType = scanner.nextLine();
			getGenresList();
			System.out.println("Enter genre from the list");
			String genreSearch = scanner.nextLine();
			search.searchByGenre(isAdult, showType, genreSearch);
		} else if (input == 2) {
			System.out.println("Enter the age rating you'd like to search");
			System.out.println("[G, PG, PG-13, R]");
			String ageRatingSearch = scanner.nextLine();
			search.searchByAgeRating(isAdult, "movie", ageRatingSearch);
		} else if (input == 3) {
			System.out.println("Enter the theater name you want to search for movies: ");
			for (Theaters theaters : theatersList) {
				System.out.println(theaters.getTitle());
			}
			String theaterInput = scanner.nextLine();
			search.searchByTheater(theaterInput);
		} else {
			System.out.println("Invalid Input");
		}
	}
	/**
	 * checking if current user is an adult
	 * @return
	 */
	private boolean isAdult() {
		if (currAge == 0) {
			return false;
		} else if (currAge >= 17){
			return true;
		}
		return false;
	}
	/**
	 * Command to print out the lits of genres in our movies/plays.json. Avoiding hardcoding
	 */
	private void getGenresList() {
		DataLists dataLists = DataLists.getInstance();
		ArrayList<String> genreList= new ArrayList<String>();
		ArrayList<Movie> movieList = dataLists.getMovie();
		ArrayList<Play> playList = dataLists.getPlays();
		for (Movie movies : movieList) {
			if (!genreList.contains(movies.getGenre())) {
				genreList.add(movies.getGenre());
			}
		}
		for (Play plays : playList) {
			if (!genreList.contains(plays.getGenre())) {
				genreList.add(plays.getGenre());
			}
		}
		System.out.println(genreList);
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

<<<<<<< HEAD
}
=======
}
>>>>>>> eeba13c2651a20c185979b0e67a1950ae3ac5f69
