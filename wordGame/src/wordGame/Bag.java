package wordGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * The bag of possible characters.
 * 
 * @author Vanessa Kostadinova
 * @version 20/11/2019
 */

public class Bag {

	private static Bag bagInstance;
	private HashMap<Character, Integer> bag;
	
	private Bag() {
		createBag();
	}
	
	private void createBag() {
		bag = new HashMap<Character, Integer>(26);
	}
	
	public static Bag getBagInstance() {
		if(bagInstance == null) {
			bagInstance = new Bag();
		}
		
		return bagInstance;
	}
	
	public int getScore(Character[] characters) {
		for(Character i : characters) {
			//if(bag.)
		}
		return 0;
	}
}