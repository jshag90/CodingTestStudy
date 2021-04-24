package com.ji.study;

public class Solution_191008 {
	public static void main(String[] args) {
		System.out.println(solution(42119));
	}

	public static int solution(int n) {
		int answer = 0;
		
		int seperateNum = 0;
		int numPosition = (int) (Math.log10(n) + 1);

		for (int index = numPosition; index> 0; index--) {
			int powValue = (int) Math.pow(10, index - 1);
			
			seperateNum = n / powValue;
			n -= seperateNum * powValue;
			
			answer += seperateNum;
		}

		return answer;
	}

}
