package Commands;

public class CheckoutCommand implements Command{
	TheaterCommands theater;
	public CheckoutCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.checkout();
	}

}
