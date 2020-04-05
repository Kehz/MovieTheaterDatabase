package Commands;


public class DisplayMoviesCommand implements Command{

	private TheaterCommands theater;
	
	public DisplayMoviesCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	
	@Override
	public void execute() {
		theater.displayMovies();
	}

}
