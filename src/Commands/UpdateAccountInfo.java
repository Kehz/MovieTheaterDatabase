package Commands;

public class UpdateAccountInfo implements Command {
	private TheaterCommands theater;
	public UpdateAccountInfo(TheaterCommands theater) {
		this.theater = theater;
	}

	@Override
	public void execute() {
		theater.changeAccountDetails();
	}

}
