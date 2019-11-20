package wordGame;

/**
 * The board of the game.
 * 
 * @author Vanessa Kostadinova
 * @version 20/11/2019
 */

public class Board {

	private Character[][] board;
	private static Board boardInstance;
	
	private Board() {
		createBoard();
	}
	
	public static Board getBoardInstance() {
		if(boardInstance == null) {
			boardInstance = new Board();
		}
		
		return boardInstance;
	}
	
	public Character[][] getBoard(){
		return board;
	}
	
	public void setTilesOnBoard() {
		
	}
	
	public String toString() {
		return board.toString();
	}
	
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
