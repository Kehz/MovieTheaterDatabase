package Commands;

public class EnterMovieCommand implements Command {
	
private TheaterCommands theater;
	
	public EnterMovieCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.addMovie();
	}

}
