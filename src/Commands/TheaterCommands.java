package Commands;

import main.TheaterInterface;
import main.User;
/**
 * 
 * @author Devin Adams
 * This class holds the commands to be loading into our input handler
 * for the command design pattern.
 */
public class TheaterCommands {
	TheaterInterface ti = new TheaterInterface();
	User us = new User(null, null, null, 0, 0, 0, 0, null, null);
	
	public void displayMovies() {	
		ti.displayMovies();
	}
	
	public void addMovie() {
		ti.addMovie();
	}
	
	public void displayTheaters() {
		ti.displayTheaters();
	}
	
	public void addTheater() {
		ti.addTheater();
	}
	
	public void addPlay() {
		ti.addPlay();
	}
	
	public void displayPlay() {
		ti.displayPlays();
	}
	
	public void checkout() {
		us.checkout();
	}
	
	public void orderTicket() {
		us.orderTicket();
	}
	
	public void runSim() {
		us.watchMovie();
	}
	
	public void search() {
		us.searchShows();
	}
	
	public void printTickets() {
		us.printUserTicketInfo();
	}
	public void refund() {
		us.requestRefund();
	}
	
	public void printShoppingCart() {
		us.printShoppingCart();
	}
	
	public void printTicketCart() {
		us.showTickets();
	}
	
	public void changeAccountDetails() {
		us.changeAccountDetails();
	}
	
	public void workerAddTheaterShow() {
		us.workerAddTheaterShow();
	}
}
