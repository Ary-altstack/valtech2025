package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void testSqaureNow() {
		
		
		Square sq = (a) -> a*a;
		assertEquals(0,sq.squareNow(0));
		assertEquals(0,sq.squareNow(0));
		assertEquals(1,sq.squareNow(1));
		assertEquals(1,sq.squareNow(-1));

	}

}
