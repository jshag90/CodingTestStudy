package com.ji.programers;

public class Solution_191008 {
	public static void main(String[] args) {
//		System.out.println();
//		System.out.println(solution(421));
		solution(1421);
		System.out.println(solution(1421));
	}

	static int seperateNumSum = 0;

	public static int solution(int n) {
		int answer = 0;
		int seperateNum = 0;
		int numPosition = (int) (Math.log10(n) + 1);

		// System.out.println(n/(10*numPosition));
		int powValue = (int) Math.pow(10, numPosition - 1);
		seperateNum = n / powValue;
		// System.out.println(seperateNum);
		seperateNumSum += seperateNum;
		int nextNum = n - (seperateNum * powValue);
		// System.out.println(nextNum);
		// System.out.println(seperateNumSum);
		if (numPosition > 1) {
			solution(nextNum);
			return answer;
		}else{
//			System.out.println(seperateNumSum);
			answer = seperateNumSum;
			return seperateNumSum;
		}

//		return answer;
	}
}
