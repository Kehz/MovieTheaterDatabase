package main;
import java.util.Scanner;
import java.util.ArrayList;

import JSONParsing.DataLists;
import JSONParsing.DataWriter;

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
		Theaters theaterPick=viewTheaters();//select theater
		Show showPick=viewShows(theaterPick);//select show from ones playing at the theater
		reserveSeating(showPick);//reserve seat at that show
		checkout(showPick);//pay for the ticket
	}
	
	public Theaters viewTheaters() {
		Theaters chosen= new Theaters(email, age, email);
		DataLists dataLists = DataLists.getInstance(); //Pulls instance of the data list class
		TheaterInterface thing= new TheaterInterface();//just to make sure the logic is right
		ArrayList<Theaters> theaterLists = dataLists.getTheaters();
		//select a theater
		System.out.println("What theater would you like to select?");
		thing.displayTheaters();
		//type in selection
		String selection;
		selection=in.nextLine();
		//check to see if there is a match in the arraylist, then set that to selection
		for(Theaters theaters : theaterLists) {
			if (theaters.getTitle() == selection) {
				chosen=theaters;
			}
			else
			{
				//redo selection until a valid one is chosen
			}
		}
		
		//return selection
		return chosen;
	}
	
	public Show viewShows(Theaters temp) {
		Show chosen=new Show(age, email, age, email, email, age, email, email, null, age);
		TheaterInterface thing= new TheaterInterface();
		DataLists dataLists = DataLists.getInstance(); //Pulls instance of the data list class
		
		System.out.println("Would you like to view our list of movies or plays? Enter '1' for movies and '2' for plays");
		int choose;
		choose=in.nextInt();
		if(choose==1) {
			ArrayList<Movie> movieList = dataLists.getMovie(); //Grabs the current list of users/movies/plays
			//select a show
			System.out.println("What movie would you like to select?");
			thing.displayMovies();
			//type in selection
			String selection;
			selection=in.nextLine();
			//check to see if there is a match in the arraylists, then set that to selection
			
			for(Movie movies : movieList) {
				if (movies.getTitle() == selection) {
					chosen=movies;
				}
				else
				{
					//redo selection until a valid one is chosen
				}
			}
			
		}
		else if(choose==2) {
			ArrayList<Play> playList = dataLists.getPlays(); //Grabs the current list of users/movies/plays
			//select a show
			System.out.println("What play would you like to select?");
			thing.displayPlays();
			//type in selection
			String selection;
			selection=in.nextLine();
			//check to see if there is a match in the arraylists, then set that to selection
			for(Play plays : playList) {
				if (plays.getTitle() == selection) {
					chosen=plays;
				}
				else
				{
					//redo selection until a valid one is chosen
				}
			}
		}
		return chosen;
	}
	
	public void reserveSeating(Show temp) {
		
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
		temp.setSeating(seats);//update show seating
	}
	
	public void checkout(Show temp) {
		double cost= temp.getPrice();
		System.out.println("A ticket to this show will cost " + cost + " dollars");
		//implement discount methods here
		double payment= in.nextDouble();
		if(payment==cost) {
			System.out.println("Transaction completed, enjoy your movie!");
		}
	}
}
