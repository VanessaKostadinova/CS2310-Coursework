package wordGame;

/**
 * The board of the game.
 * 
 * @author Vanessa Kostadinova
 * @version 22/11/2019
 */

public class Board {

	/**The values of each tile on the board */
	private Character[][] board;
	/**The only instance of Board*/
	private static Board boardInstance;
	
	/**Private constructor only accessible to board.*/
	private Board() {
		createBoard();
	}
	/**
	 * Sends or creates the only instance of Board.
	 * @return The only instance of Board.
	 */

	public static Board getBoardInstance() {
		if(boardInstance == null) {
			boardInstance = new Board();
		}
		
		return boardInstance;
	}
	
	/**
	 * Accessor for the board array.
	 * @return Current board array.
	 */
	public Character[][] getBoard(){
		return board;
	}
	
	/*
	 * Places a tile on the board.
	 */
	public void setTileOnBoard(int x, int y, Character character) {
		board[x][y] = character;
	}
	
	/**
	 * Exports the board as a string
	 */
	public String toString() {
		String workingString = "";
		for(int i = 0; i < 10; i++) {
			for(int c = 0; c < 10; c++) {
				workingString += board[i][c] + ",";
			}
			workingString += "\n";
		}
		return workingString;
	}
	
	/**
	 * Creates the starting board array used for calculations.
	 */
	private void createBoard() {
		board = new Character[][] {
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,'+','+',null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,'+',null,null,'+',null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,'+',null,null,'+',null,null,null},
			{null,null,null,null,null,null,null,null,null,null},
			{null,null,null,null,'+','+',null,null,null,null},
			{null,null,null,null,null,null,null,null,null,null}
		};
	}

}
