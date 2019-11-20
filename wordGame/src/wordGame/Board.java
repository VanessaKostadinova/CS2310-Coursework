package wordGame;

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
