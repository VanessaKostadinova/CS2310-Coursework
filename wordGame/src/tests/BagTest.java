package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utility.Bag;

class BagTest {
	
	private static Bag bag = new Bag();
	
	@Test
	void testGetScoreA() {
		char a = 'a';
		bag.getScore(a);
		
		//int i = a;
		//System.out.println(i);
		
		assertEquals(1, a);
		
		//fail("Not yet implemented");
	}

}
