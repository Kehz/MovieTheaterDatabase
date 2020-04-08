package Commands;

public class ShowShoppingCartCommand implements Command{
	TheaterCommands theater;
	public ShowShoppingCartCommand(TheaterCommands theater) {
		this.theater = theater;
	}

	@Override
	public void execute() {
		theater.printShoppingCart();
	}

}
