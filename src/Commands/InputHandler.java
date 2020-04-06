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
		commands.put("show movies", new DisplayMoviesCommand(theater));
		commands.put("enter movie", new EnterMovieCommand(theater));
		commands.put("enter theater", new EnterTheatersCommand(theater));
		commands.put("show theaters", new DisplayTheatersCommand(theater));
		commands.put("enter play", new EnterPlayCommand(theater));
		commands.put("show plays", new DisplayPlaysCommand(theater));
		commands.put("show user", new DisplayCurrentUser(theater));
		commands.put("update username", new UpdateUsernameCommand(theater));
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
