package com.ji.study;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TargetNumberTest {

	@Test
	void test() {

		TargetNumber test = new TargetNumber();
		
		assertEquals(5, test.solution(new int[] {1,1,1,1,1}, 3));
		assertEquals(3, test.solution(new int[] {2,3,5,7,9}, 2));
		assertEquals(1, test.solution(new int[] {1}, 1));
		assertEquals(5, test.solution(new int[] {6,2,3,6,7,1}, 7));

	}


}
