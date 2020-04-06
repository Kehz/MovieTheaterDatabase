package Commands;
/**
 * 
 * @author Devin Adams
 * Easy test command for testing functions quickly
 */
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
