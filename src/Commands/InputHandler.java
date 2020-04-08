package Commands;
import java.util.HashMap;
/**
 * 
 * @author Devin Adams
 * This is the command design pattern being implemented. Easy way to load in commands
 * to be used in our interface. Functions as the main menus commands.
 */
public class InputHandler {
	private HashMap<String, Command> commands = new HashMap<>();
	
	public InputHandler(TheaterCommands theater) { 
		commands.put("display movies", new DisplayMoviesCommand(theater));
		commands.put("enter movie", new EnterMovieCommand(theater));
		commands.put("enter theater", new EnterTheatersCommand(theater));
		commands.put("show theaters", new DisplayTheatersCommand(theater));
		commands.put("enter play", new EnterPlayCommand(theater));
		commands.put("display plays", new DisplayPlaysCommand(theater));
		commands.put("checkout", new CheckoutCommand(theater));
		commands.put("order ticket", new OrderTicketCommand(theater));
		commands.put("watch", new WatchCommand(theater));
		commands.put("search shows", new SearchCommand(theater));
		commands.put("print tickets", new PrintTicketCommand(theater));
		commands.put("refund", new RefundCommand(theater));
		commands.put("view shopping cart", new ShowShoppingCartCommand(theater));
		commands.put("view ticket cart", new ShowTicketCartCommand(theater));
		commands.put("change account details", new UpdateAccountInfo(theater));
		commands.put("add show to theater", new AddTheaterShowCommand(theater));
	}
	
	public void inputEntered(String data) {
		Command command = commands.get(data);
		if(command == null) {
			System.out.println("Sorry, we dont' recongize that command"); 
		} else {
			command.execute();
		}
	}
}
