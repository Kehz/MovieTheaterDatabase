package Commands;

public class RefundCommand implements Command {
	private TheaterCommands theater;
	public RefundCommand(TheaterCommands theater) {
		this.theater = theater;
	}
	@Override
	public void execute() {
		theater.refund();
	}

}
