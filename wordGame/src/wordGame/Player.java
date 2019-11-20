package wordGame;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {

	private Set rack;
	
	public Player() {
		rack = new LinkedHashSet<Character>(5);
	}
}
