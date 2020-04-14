package Commands;

public class ShowTicketCartCommand implements Command {
	private TheaterCommands theater;
	public ShowTicketCartCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.printTicketCart();
	}

}
