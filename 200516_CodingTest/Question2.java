package com.ji.main;

public class Question2 {

	public static void main(String[] args) {
		int result = countBits(7);
		System.out.println(result);
	}
	
	public static int countBits(int number){
		
		int count = 0;
		while(number !=0) {
			count += (number & 1);
			number = number >>> 2;
		}
		
		return count;

	}
}
