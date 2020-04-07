package Commands;

public class UpdateUsernameCommand implements Command{
	TheaterCommands theater;
	public UpdateUsernameCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.updateUsername();
	}
}
