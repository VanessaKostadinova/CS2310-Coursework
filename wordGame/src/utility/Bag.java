package utility;

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
	private int[] bag;
	
	public Bag() {
		createBag();
	}
	
	private void createBag() {
		
		bag = new int[]{1,2,1,1,1,1,2,1,1,2,2,1,2,2,1,1,3,1,1,1,1,1,1,3,3,3};
		
		/*bag = new HashMap<Character, Integer>(39);
		//Put all letters in HashMap
		bag.put('a', 1); bag.put('b', 2); bag.put('c', 1); bag.put('d', 1); 
		bag.put('e', 1); bag.put('f', 1); bag.put('g', 2); bag.put('h', 1);
		bag.put('i', 1); bag.put('j', 2); bag.put('k', 2); bag.put('l', 1);
		bag.put('m', 2); bag.put('n', 2); bag.put('o', 1); bag.put('p', 1);
		bag.put('q', 3); bag.put('r', 1); bag.put('s', 1); bag.put('t', 1);
		bag.put('u', 1); bag.put('v', 1); bag.put('w', 1); bag.put('x', 3);
		bag.put('y', 3); bag.put('z', 3);
	*/}
	
	public static Bag getBagInstance() {
		if(bagInstance == null) {
			bagInstance = new Bag();
		}
		return bagInstance;
	}
	
	public int getScore(Character character) {
		try {
		int i = character; //casting character to an int will give ascii code
		i=i-97; //this will convert the assci alphabet to start at 0	
		return bag[i];
		}
		catch(Exception e){
			System.out.print("error in getting letter score, non letter used");
			return 0;
		}
	}
}