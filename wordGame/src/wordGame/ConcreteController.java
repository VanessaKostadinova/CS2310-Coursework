package wordGame;

import java.util.ArrayList;
import java.util.Random;

import userInterface.TUI;
import utility.Rack;

/**
 * A concrete implementation of the interface controller.
 * 
 * @author Vanessa Kostadinova
 * @version 22/11/2019
 */

public class ConcreteController implements Controller {
	
	//Copies of the board, bag and rack instances
	private Board board;
	private Bag bag;
	private Rack rack;
	
	public ConcreteController() {
		//Creates the entire game
		this.board = Board.getBoardInstance();
		this.bag = Bag.getBagInstance();
		//Rack size of 5
		this.rack = Rack.getRackInstance(5);
		new TUI(this);
	}
	
	@Override
	public String refillRack() {
		ArrayList<Integer> missing = rack.getMissing();
		ArrayList<Character> charsToAdd = new ArrayList<Character>();
		Random rand = new Random();
		
		for(int i: missing) {
			charsToAdd.add( (char) (rand.nextInt(26) + 96));
		}
		
		rack.addCharacters(charsToAdd);
		return rack.toString();
	}

	@Override
	public String gameState() {
		String workingString = "Board:\n" + board.toString() + "\n";
		workingString += "Tiles: " + "\n";
		for(Character i : rack.getRack()) {
			workingString += " " + i + ",";
		}
		return workingString;
	}

	@Override
	public String play(Play play) {
		//Gets the characters to place
		String[] letterPos = play.letterPositionsInRack().split("", 1);
		ArrayList<Character> letters = new ArrayList<Character>();
		
		for(String i:letterPos) {
			letters.add(rack.getCharacter(Integer.valueOf(i)));
		}
		
		String startCell = play.cell();
		String[] coords = startCell.split(null, 1);
		int length = play.letterPositionsInRack().length();
		
		int coordX = Integer.valueOf(coords[0].toLowerCase()) - 96;
		int coordY = Integer.valueOf(coords[1]);
		
		//Places characters
		if(checkValidity(play) == "Valid") {
			board.setTileOnBoard(coordX, coordY, letters.get(0));
			
			switch (play.dir()) {
			case DOWN:
				for(int i = 1; i <= length; i++) {
					board.setTileOnBoard(coordX, coordY - i, letters.get(i));
				}
			case ACROSS:
				for(int i = 1; i <= length; i++) {
					board.setTileOnBoard(coordX + i, coordY, letters.get(i));
				}
			}
		}
		return board.toString();
	}

	@Override
	public String calculateScore(Play play) {
		String[] letterPos = play.letterPositionsInRack().split("", 1);
		ArrayList<Character> letters = new ArrayList<Character>();
		for(String i:letterPos) {
			letters.add(rack.getCharacter(Integer.valueOf(i)));
		}
		return "" + bag.getScore(letters);
	}

	@Override
	public String checkValidity(Play play) {
		String startCell = play.cell();
		String[] coords = startCell.split(null, 1);
		Character[][] currentBoard = board.getBoard();
		int length = play.letterPositionsInRack().length();
		
		int coordX = Integer.valueOf(coords[0].toLowerCase()) - 96;
		int coordY = Integer.valueOf(coords[1]);
		
		//Checks if first letter is valid
		if(currentBoard[coordX][coordY] == null | currentBoard[coordX][coordY] == '+') {
			//Checks if all subsequent letters are valid based on the direction
			switch (play.dir()) {
			case DOWN:
				for(int i = 1; i <= length; i++) {
					if(currentBoard[coordX][coordY - i] != null && currentBoard[coordX][coordY - i] != '+') {
						return "Invalid";
					}
				}
			case ACROSS:
				for(int i = 1; i <= length; i++) {
					if(currentBoard[coordX + i][coordY] != null && currentBoard[coordX + i][coordY] != '+') {
						return "Invalid";
					}
				}
			}
			
		}
		else {
			return "Invalid";
		}
		
		return "Valid";
	}

}
