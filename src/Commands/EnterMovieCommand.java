package Commands;

public class EnterMovieCommand implements Command {
	
private Theater theater;
	
	public EnterMovieCommand(Theater theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.addMovie();
	}

}
