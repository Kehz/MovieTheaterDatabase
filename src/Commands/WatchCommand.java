package Commands;
/**
 * 
 * @author Devin Adams
 * Easy test command for testing functions quickly
 */
public class WatchCommand implements Command{
	TheaterCommands theater;
	public WatchCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.runSim();
	}

}
