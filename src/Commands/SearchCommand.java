package Commands;

public class SearchCommand implements Command {
	private TheaterCommands theater;
	public SearchCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.search();
	}
}
