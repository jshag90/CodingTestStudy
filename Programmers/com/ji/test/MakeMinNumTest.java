package com.ji.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.ji.study.MakeMinNum;

class MakeMinNumTest {

	@Test
	void test() {

		MakeMinNum test = new MakeMinNum();

		assertEquals(29, test.solution(new int[] { 1, 4, 2 }, new int[] { 5, 4, 4 }));
		assertEquals(10, test.solution(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}

}
