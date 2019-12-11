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
 * @version 29/11/2019
 */

public class ConcreteController implements Controller {

	//Copies of the board, bag and rack instances
	private Board board;
	private Bag bag;
	private Rack rack;
	private Dictionary dictionary;

	/**
	 * Constructs a concrete controller which creates an instance of every other class required.
	 */
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
	public String play(Play play) /*throws InvalidParameterException*/ {
		//Gets the characters to place
		//String[] letters = getWordFromPlay(play).split("", 1);
		char[] letters = getWordFromPlay(play).toCharArray();
		int length = play.letterPositionsInRack().length();
		int[] coords = getCoordsFromPlay(play);

		//Places characters
		if(checkValidity(play) == "Valid") {
			board.setTileOnBoard(coords[0], coords[1], letters[0]);

			switch (play.dir()) {
			case DOWN:
				for(int i = 0; i < length; i++) {
					board.setTileOnBoard(coords[0], coords[1] + i, letters[i]);
				}
				break;
			case ACROSS:
				for(int i = 0; i < length; i++) {
					board.setTileOnBoard(coords[0] + i, coords[1], letters[i]);
				}
				break;
			}
		}
		return board.toString();
	}

	//TODO Add +'s to the calculation
	@Override
	public String calculateScore(Play play) {
		char[] letterArray = play.letterPositionsInRack().toCharArray();
		int[] coords = getCoordsFromPlay(play);
		int runningTotal = 0;

		char boardValue = board.getBoard()[coords[0]][coords[1]];
		int c = 0;

		for(char i:letterArray) {
			c++;
			
			switch (boardValue) {
			case '+':
				runningTotal += (bag.getScore(i) * 2);
			case ' ':
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
	public String checkValidity(Play play) /* throws InvalidParameterException */ {
		Boolean test1 = boardAnalysis(play);
		Boolean test2 = lexicalAnalysis(getWordFromPlay(play));
		if(test1 && test2){
		//if(boardAnalysis(play) && lexicalAnalysis(getWordFromPlay(play))){
			return "Valid";
		}
		else return "Invalid";
	}

	private boolean lexicalAnalysis(String word) {
		return dictionary.checkWordExists(word);
	}

	private boolean boardAnalysis(Play play) {
		int[] coords = getCoordsFromPlay(play);
		Character[][] currentBoard = board.getBoard();
		int length = play.letterPositionsInRack().length();

		//Checks if first letter is valid
		if(currentBoard[coords[0]][coords[1]] == ' ' | currentBoard[coords[0]][coords[1]] == '+') {
			//Checks if all subsequent letters are valid based on the direction
			switch (play.dir()) {
			case DOWN:
				for(int i = 0; i < length; i++) {
					if(currentBoard[coords[0]][coords[1] + i] != ' ' && currentBoard[coords[0]][coords[1] + i] != '+') {
						return false;
					}
				}
				break;
			case ACROSS:
				for(int i = 1; i <= length; i++) {
					if(currentBoard[coords[0] + i][coords[1]] != ' ' && currentBoard[coords[0] + i][coords[1]] != '+') {
						return false;
					}
				}
				break;
			}
		}
		else {
			return false;
		}
		return true;
	}

	/**
	 * Fetches the initial coordinates in integer format from the play given.
	 * @param play
	 * @return int[] where int[0] is the x coordinate and int[1] is the y coordinate.
	 */
	private int[] getCoordsFromPlay(Play play){
		int[] coords = new int[2];
		String startCell = play.cell();
		char[] stringCoords = startCell.toCharArray();

		coords[0] = Integer.valueOf((Character.toLowerCase(stringCoords[0]))) - 96;
		
		coords[1] = Integer.parseInt(String.valueOf(stringCoords[1]));

		return coords;
	}

	/**
	 * Gets the word from the rack created by the play coordinates given.
	 * @param play
	 * @return
	 */
	private String getWordFromPlay(Play play) /*throws InvalidParameterException */{
		String workingString = "";
		String str = play.letterPositionsInRack();
		char[] letters = str.toCharArray();

		for(char i : letters) {
			if(Integer.parseInt(String.valueOf(i)) > 5) {
				//throw new InvalidParameterException("Coordinate given is out of bounds of the rack.");
				System.out.println("Coordinate given is out of bounds of the rack.");
			}
			workingString += rack.getCharacter(Integer.parseInt(String.valueOf(i)) - 1);
		}
		
		return workingString;
	}
}
