package wordGame;

public class Board {

	private Character[][] board;
	
	public Board() {
		
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
