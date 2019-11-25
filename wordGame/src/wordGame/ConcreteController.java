package wordGame;

import java.util.ArrayList;
import java.util.Random;

import exceptions.InvalidParameterException;
import userInterface.TUI;
import utility.Bag;
import utility.Dictionary;
import utility.Rack;

/**
 * A concrete implementation of the interface controller.
 * 
 * @author Vanessa Kostadinova
 * @version 24/11/2019
 */

public class ConcreteController implements Controller {

	//Copies of the board, bag and rack instances
	private Board board;
	private Bag bag;
	private Rack rack;
	private Dictionary dictionary;

	public ConcreteController() {
		//Creates the entire game
		this.board = Board.getBoardInstance();
		this.bag = Bag.getBagInstance();
		this.dictionary = Dictionary.getDictionaryInstance();
		//Rack size of 5
		this.rack = Rack.getRackInstance(5);
		new TUI(this);
		
		refillRack();
	}

	@Override
	public String refillRack() {
		//Get list of missing characters and characters to add
		ArrayList<Integer> missing = rack.getMissing();
		ArrayList<Character> charsToAdd = new ArrayList<Character>();
		Random rand = new Random();

		for(int i: missing) {
			charsToAdd.add( (char) (rand.nextInt(25) + 97));
		}

		try {
			rack.addCharacters(charsToAdd);
		} catch (InvalidParameterException e) {
			e.printStackTrace();
		}
		return rack.toString();
	}

	//TODO fix formatting
	@Override
	public String gameState() {
		String workingString = "Board:\n" + board.toString() + "\n";
		workingString += "Tiles: " + "\n";
		for(Character i : rack.getRack()) {
			workingString += i;
		}
		return workingString;
	}

	@Override
	public String play(Play play) {
		//Gets the characters to place
		String[] letters = getWordFromPlay(play).split("", 1);
		int length = play.letterPositionsInRack().length();
		int[] coords = getCoordsFromPlay(play);

		//Places characters
		if(checkValidity(play) == "Valid") {
			board.setTileOnBoard(coords[0], coords[1], letters[0]);

			switch (play.dir()) {
			case DOWN:
				for(int i = 1; i <= length; i++) {
					board.setTileOnBoard(coords[0], coords[1] - i, letters[i]);
				}
			case ACROSS:
				for(int i = 1; i <= length; i++) {
					board.setTileOnBoard(coords[0] + i, coords[1], letters[i]);
				}
			}
		}
		return board.toString();
	}

	//TODO Add +'s to the calculation
	@Override
	public String calculateScore(Play play) {
		String[] letterArray = play.letterPositionsInRack().split("", 1);
		int[] coords = getCoordsFromPlay(play);
		int runningTotal = 0;

		String boardValue = board.getBoard()[coords[0]][coords[1]];
		int c = 0;

		for(String i:letterArray) {
			c++;
			
			switch (boardValue) {
			case "+":
				runningTotal += (bag.getScore(i) * 2);
			case " ":
				runningTotal += (bag.getScore(i));
			}
			
			switch (play.dir()) {

			case DOWN:
				boardValue = board.getBoard()[coords[0]][coords[1] - c];
			case ACROSS:
				boardValue = board.getBoard()[coords[0] + c][coords[1]];
			}
		}
		return "" + runningTotal;
	}

	@Override
	public String checkValidity(Play play) {
		if(boardAnalysis(play) && lexicalAnalysis(getWordFromPlay(play))){
			return "Valid";
		}
		else return "Invalid";
	}

	private boolean lexicalAnalysis(String word) {
		return dictionary.checkWordExists(word);
	}
	
	private String nextBoardValue(Play play) {
		
		return "";
	}

	private boolean boardAnalysis(Play play) {
		int[] coords = getCoordsFromPlay(play);
		String[][] currentBoard = board.getBoard();
		int length = play.letterPositionsInRack().length();

		//Checks if first letter is valid
		if(currentBoard[coords[0]][coords[1]] == null | currentBoard[coords[0]][coords[1]] == "+") {
			//Checks if all subsequent letters are valid based on the direction
			switch (play.dir()) {
			case DOWN:
				for(int i = 1; i <= length; i++) {
					if(currentBoard[coords[0]][coords[1] - i] != null && currentBoard[coords[0]][coords[1] - i] != "+") {
						return false;
					}
				}
			case ACROSS:
				for(int i = 1; i <= length; i++) {
					if(currentBoard[coords[0] + i][coords[1]] != null && currentBoard[coords[0] + i][coords[1]] != "+") {
						return false;
					}
				}
			}
		}
		else {
			return false;
		}

		return true;
	}

	private int[] getCoordsFromPlay(Play play){
		int[] coords = new int[2];
		String startCell = play.cell();
		String[] stringCoords = startCell.split(null, 1);

		coords[0] = Integer.valueOf(stringCoords[0].toLowerCase()) - 96;
		coords[1]= Integer.valueOf(coords[1]);

		return coords;
	}

	private String getWordFromPlay(Play play) {
		String workingString = "";
		String[] letterPos = play.letterPositionsInRack().split("", 1);

		for(String i : letterPos) {
			workingString += rack.getCharacter(Integer.valueOf(i));
		}
		
		return workingString;
	}
}
