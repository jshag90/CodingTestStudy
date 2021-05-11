package com.ji.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.ji.study.MaxMin;

public class MaxMinTest {

	@Test
	void test() {

		MaxMin test = new MaxMin();

		assertEquals("1 4", test.solution("1 2 3 4"));
		assertEquals("-4 -1", test.solution("-1 -2 -3 -4"));
		assertEquals("-1 -1", test.solution("-1 -1"));

	}

}
