package Commands;

public class EnterTheatersCommand implements Command{
	Theater theater;
	public EnterTheatersCommand(Theater theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.addTheater();
	}

}
