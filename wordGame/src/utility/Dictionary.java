package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A searchable set of valid words.
 * 
 * @author Vanessa Kostadinova
 * @author Jedd Morgan
 * @version 11/12/2019
 */

public class Dictionary {

	private HashSet<String> words;
	private Scanner file;
	private static Dictionary dictionaryInstance;
	
	public Dictionary() {
		words = new HashSet<String>(104854);
		createDictionary();
	}
	
	public static Dictionary getDictionaryInstance() {
		if(dictionaryInstance == null) {
			dictionaryInstance = new Dictionary();
		}
		
		return dictionaryInstance;
	}
	
	private void createDictionary(){
		
		//file = new Scanner("Dictionary.txt");
		try
		{
			BufferedReader file = new BufferedReader(new FileReader("Assets/Dictionary.txt"));
			String line;
			while ((line = file.readLine()) != null) {
				words.add(line);
			}
			file.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean checkWordExists(String word) {
		return (words.contains(word));
	}
}
