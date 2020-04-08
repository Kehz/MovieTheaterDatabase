package Commands;

public class PrintTicketCommand implements Command {
	private TheaterCommands theater;
	public PrintTicketCommand(TheaterCommands theater) {
		this.theater = theater;
	}

	@Override
	public void execute() {
		theater.printTickets();
	}

}
