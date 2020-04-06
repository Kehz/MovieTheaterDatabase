package Commands;

public class DisplayCurrentUser implements Command{
	TheaterCommands theater;
	public DisplayCurrentUser(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.displayCurrentUser();
	}

}
