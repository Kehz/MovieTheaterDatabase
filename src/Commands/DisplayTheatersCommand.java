package Commands;

public class DisplayTheatersCommand implements Command {
	Theater theater;
	
	public DisplayTheatersCommand(Theater theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.displayTheaters();
	}

}
