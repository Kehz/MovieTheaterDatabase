package Commands;

public class DisplayPlaysCommand implements Command {
	
private TheaterCommands theater;
	
	public DisplayPlaysCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.displayPlay();
	}

}
