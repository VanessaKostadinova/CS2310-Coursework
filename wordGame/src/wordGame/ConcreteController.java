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
	private HashMap<Integer, Set<Character>> bag;
	
	public ConcreteController(Board board) {
		this.board = board;
		createBag();
	}
	
	private void createBag() {
		final Set<Character> onePoint = new HashSet<Character>(16);
		final Set<Character> twoPoints = new HashSet<Character>(6);
		final Set<Character> threePoints = new HashSet<Character>(4);
		threePoints.add('q');
		bag = new HashMap<Integer, Set<Character>>(3);
		bag.put(1, onePoint);
		bag.put(2, twoPoints);
		bag.put(3, threePoints);
	}

	@Override
	public String refillRack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gameState() {
		// TODO Auto-generated method stub
		return null;
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
