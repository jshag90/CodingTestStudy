package com.ji.study;

public class Carpet {

	public static void main(String[] args) {
		solution(10, 2);
		
	}
	//두수의 곱셈 연산
	// 곱셈 결과가 될 수 있는 2자리 
	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
		int[] arr = new int[brown*yellow];
		int limit = brown>yellow?brown:yellow;
		for(int i=0; i<limit-1; i++) {
			arr[i] = i+1;
		}
		per1(arr, 0, arr.length, brown, yellow);
		return answer;
	}
	
	static void per1(int[] arr, int depth, int n, int b, int y) {
		if (depth == 2) {
			if(arr[0]*arr[1] == (b+y) && arr[0] >= arr[1]) {
				for (int i = 0; i < 2; i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, b, y);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
}
