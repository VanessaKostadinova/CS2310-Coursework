package wordGame;

import userInterface.TUI;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		ConcreteController controller = new ConcreteController(board);
		TUI userInterface = new TUI(controller);
	}

}
