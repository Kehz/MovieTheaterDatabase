package Commands;

public class OrderTicketCommand implements Command{
	TheaterCommands theater;
	public OrderTicketCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.orderTicket();
	}

}
