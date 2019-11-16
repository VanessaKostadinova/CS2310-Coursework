/**
 * 
 */
package wordGame;


/**
 * To model the information required for a play, i.e.:
 * - the ID of the cell where the first letter tile is to be placed in a play
 * - the direction by which the letter tiles are to be read, i.e. down or across
 * - the position of each letter tile on the tile rack which will be used in this play, 
 *    as a tile rack can hold up to five letter tiles, the expected positions are
 *    1, 2, 3, 4 & 5.
 * 
 * @author Sylvia Wong
 * @version 31/10/2019
 *
 */
public class Play {

	private String startCell;
	private Direction dir;
	private String letterPositionsInRack;

	/**
	 * Constructor
	 * @param cell
	 * @param dir
	 * @param letterPositionsInRack
	 * @throws IllegalArgumentException
	 */
	public Play(String cell, String dir, String letterPositionsInRack) 
		throws IllegalArgumentException {
		
		this.startCell = cell;
		this.dir = Direction.valueOf(dir);
		this.letterPositionsInRack = letterPositionsInRack;
	}
	
	public String cell() {
		return startCell;
	}
	
	public Direction dir() {
		return dir;
	}
	
	public String letterPositionsInRack() {
		return letterPositionsInRack;
	}

	@Override
	public String toString() {
		return "{" + startCell + "; " + dir.toString() + "; " + letterPositionsInRack + "}";
	}
}

/* 
 * An enumerated data type (i.e. enum) for modelling
 * the two possible directions by which the letter tiles 
 * can be placed on the game board, i.e. down and across.
 */
enum Direction {
	ACROSS, DOWN
}
