package Commands;

public class EnterTheatersCommand implements Command{
	TheaterCommands theater;
	public EnterTheatersCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.addTheater();
	}

}
