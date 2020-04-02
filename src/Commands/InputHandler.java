package Commands;
import java.util.HashMap;

public class InputHandler {
	private HashMap<String, Command> commands = new HashMap<>();
	
	public InputHandler(Theater theater) { 
		commands.put("show movies", new DisplayShowsCommand(theater));
		commands.put("enter movie", new EnterMovieCommand(theater));
		commands.put("enter theater", new EnterTheatersCommand(theater));
		commands.put("show theaters", new DisplayTheatersCommand(theater));
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
