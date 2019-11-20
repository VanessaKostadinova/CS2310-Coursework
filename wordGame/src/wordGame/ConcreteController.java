package wordGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A concrete implementation of the interface controller.
 * 
 * @author Vanessa Kostadinova
 * @version 16/11/2019
 */

public class ConcreteController implements Controller {
	
	private Board board;
	
	public ConcreteController(Board board) {
		this.board = board;
	}
	
	@Override
	public String refillRack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gameState() {
		String workingString = "Board: " + board.toString() + "\n";
		workingString += "Player 1: " + "\n";
		workingString += "Player 2: " + "\n";
		return workingString;
	}

	@Override
	public String play(Play play) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String calculateScore(Play play) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkValidity(Play play) {
		// TODO Auto-generated method stub
		return null;
	}

}
