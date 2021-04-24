package com.ji.study;

public class Solution_191009_Result {
	public static void main(String[] args) {
		System.out.println(solution(42119));
	}

	public static int solution(int n) {
		int answer = 0;
		
		int sum = 0;
		
		while(n>0) {
			sum += n%10;
			n /=10;
		}
		
		answer = sum;
		return answer;
	}

}
