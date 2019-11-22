package wordGame;

import java.util.ArrayList;
import java.util.HashMap;

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
		//Put all letters in HashMap
		bag.put('a', 1); bag.put('b', 2); bag.put('c', 1); bag.put('d', 1); 
		bag.put('e', 1); bag.put('f', 1); bag.put('g', 2); bag.put('h', 1);
		bag.put('i', 1); bag.put('j', 2); bag.put('k', 2); bag.put('l', 1);
		bag.put('m', 2); bag.put('n', 2); bag.put('o', 1); bag.put('p', 1);
		bag.put('q', 3); bag.put('r', 1); bag.put('s', 1); bag.put('t', 1);
		bag.put('u', 1); bag.put('v', 1); bag.put('w', 1); bag.put('x', 3);
		bag.put('y', 3); bag.put('z', 3);
	}
	
	public static Bag getBagInstance() {
		if(bagInstance == null) {
			bagInstance = new Bag();
		}
		return bagInstance;
	}
	
	public int getScore(ArrayList<Character> characters) {
		int runningTotal = 0;
		for(Character i : characters) {
			runningTotal += bag.get(i);
		}
		return runningTotal;
	}
}