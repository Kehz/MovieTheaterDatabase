package Commands;

public class EnterPlayCommand implements Command{
	private TheaterCommands theater;
	public EnterPlayCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.addPlay();
	}

}
