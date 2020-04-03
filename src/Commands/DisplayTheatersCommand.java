package Commands;

public class DisplayTheatersCommand implements Command {
	TheaterCommands theater;
	
	public DisplayTheatersCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.displayTheaters();
	}

}
