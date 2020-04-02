package Commands;


public class DisplayShowsCommand implements Command{

	private Theater theater;
	
	public DisplayShowsCommand(Theater theater) {
		this.theater = theater;
	}
	
	@Override
	public void execute() {
		theater.displayMovies();
	}

}
