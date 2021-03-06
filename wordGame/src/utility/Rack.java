package utility;

import java.util.ArrayList;

import exceptions.InvalidParameterException;

/**
 * A wrapper for array to make rack's time complexity better.
 * 
 * @author Vanessa Kostadinova
 * @version 24/11/2019
 */

public class Rack {

	private Character[] rack;
	private ArrayList<Integer> missing;
	private static Rack rackInstance;

	private Rack(int size) {
		rack = new Character[size];
		missing = new ArrayList<Integer>(size);
		missing.add(0);
		missing.add(1);
		missing.add(2);
		missing.add(3);
		missing.add(4);
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
	
	public void clearRack()
	{
		for(int i = 0; i < rack.length; i++)
		{
			rack[i] = null;
			missing.add(i);
		}
	}
	
	public Boolean isFull()
	{
		for(int i = 0; i < rack.length; i++)
		{
			if(rack[i] == null)
			{
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer> getMissing() {
		return missing;
	}

	private void clearMissing() {
		missing.clear();
	}

	public Character getCharacter(int index) {
		return rack[index];
	}

	public String toString() {
		String workingString = "";
		for(Character i:rack) {
			workingString += i;
		}
		return workingString;
	}

	public void addCharacters(ArrayList<Character> characters) throws InvalidParameterException {
		if(characters.size() == missing.size()) {
			int c = 0;
			for(int i : missing) 
			{
				rack[i] = characters.get(c);
				c++;
			}
			clearMissing();
		}
		else {
			throw new InvalidParameterException("ArrayList not valid length");
		}
	}
}