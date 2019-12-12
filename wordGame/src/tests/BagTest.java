package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utility.Bag;

class BagTest {
	
	private static Bag bag = new Bag();
	
	@Test
	void testGetScoreA() {
		char a = 'a';
		int score = bag.getScore(a);
		
		//int i = a;
		//System.out.println(i);
		
		assertEquals(1, score);
		
		//fail("Not yet implemented");
	}
	
	@Test
	void testGetScoreZ() {
		char z = 'z';
		int score = bag.getScore(z);
		assertEquals(3, score);
	}
	
	@Test
	void testGetScoreFullStop() {
		char fullStop = '.';
		int score = bag.getScore(fullStop);
		assertEquals(0, score);
	}
	
}

	