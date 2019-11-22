package utility;

import java.util.ArrayList;

/**
 * A wrapper for array to make rack's time complexity better.
 * 
 * @author Vanessa Kostadinova
 * @version 22/11/2019
 */

public class Rack {
	
	private Character[] rack;
	private ArrayList<Integer> missing;
	private static Rack rackInstance;

	private Rack(int size) {
		rack = new Character[size];
		missing = new ArrayList<Integer>();
	}
	
	public static Rack getRackInstance(int size) {
		if(rackInstance == null) {
			rackInstance = new Rack(size);
		}
		
		return rackInstance;
	}
	
	public Character[] getRack() {
		return rack;
	}
	
	public void removeItem(int index) {
		rack[index] = null;
		missing.add(index);
	}

	public Integer[] getMissing() {
		return (Integer[]) missing.toArray();
	}
	
	public Character getCharacter(int index) {
		return rack[index];
	}
	
	public String toString() {
		String workingString = null;
		for(Character i:rack) {
			workingString += i;
		}
		return workingString;
	}
	
	public void addCharacters(Character[] characters) {
		int c = 0;
		for(int i : missing) {
			rack[i] = characters[c];
			c++;
		}
	}
}