package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import utility.Dictionary;

/**
 * 
 * @author Jedd Morgan
 * @version 11/12/2019
 */
class DictionaryTest {

	
	private static Dictionary dic = new Dictionary();
	
	
	@BeforeAll
	public static void boardTest() {
		
	}


	@Test
	void testCheckExistantWordExists() {
		assertTrue(dic.checkWordExists("bag"));
	}
	
	@Test
	void testCheckNonExistantWordExists2() {
		assertFalse(dic.checkWordExists("fsadhjasdfihu"));
	}
	
	@Test
	void testCheckInvalidWordExists3() {
		assertFalse(dic.checkWordExists(null));
	}

}
