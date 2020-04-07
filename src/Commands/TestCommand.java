package Commands;

public class TestCommand implements Command{
	TheaterCommands theater;
	public TestCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.testFunction();
	}
}
