package utility;

import java.util.HashSet;
import java.util.Scanner;

/**
 * A searchable set of valid words.
 * 
 * @author Vanessa Kostadinova
 * @version 23/11/2019
 */

public class Dictionary {

	private HashSet<String> words;
	private Scanner file;
	private static Dictionary dictionaryInstance;
	
	private Dictionary() {
		words = new HashSet<String>();
		createDictionary();
	}
	
	public static Dictionary getDictionaryInstance() {
		if(dictionaryInstance == null) {
			dictionaryInstance = new Dictionary();
		}
		
		return dictionaryInstance;
	}
	
	private void createDictionary(){
		file = new Scanner("Dictionary.txt");
		while(file.hasNext()) {
			words.add(file.nextLine());
		}
	}
	
	public boolean checkWordExists(String word) {
		if(words.contains(word)) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
