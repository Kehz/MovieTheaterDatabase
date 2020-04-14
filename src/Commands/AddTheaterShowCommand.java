package Commands;

public class AddTheaterShowCommand implements Command {
	private TheaterCommands theater;
	public AddTheaterShowCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.workerAddTheaterShow();
	}

}
