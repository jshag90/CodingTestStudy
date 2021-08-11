package com.ji.dfs;

public class MakeBigNumber {

	public static int maxNum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
//		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
//		System.out.println(solution("4177252841", 4));
	}

	public static String solution(String number, int k) {
		String answer = "";
		
		int[] arr = new int[number.length()];
		String[] numbers = number.split("");
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(numbers[i]);
		
		int r = number.length()-k;
		per1(arr, 0 , arr.length, r);
		
		answer = String.valueOf(maxNum);
		return answer;
	}
	
	static void per1(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			
			String sumStr = "";
			for (int i = 0; i < r; i++) 
				sumStr += arr[i];
			
			if(maxNum <= Integer.valueOf(sumStr))
				maxNum = Integer.valueOf(sumStr);
			
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
