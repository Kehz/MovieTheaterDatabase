package Commands;


public class DisplayShowsCommand implements Command{

	private TheaterCommands theater;
	
	public DisplayShowsCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	
	@Override
	public void execute() {
		theater.displayMovies();
	}

}
