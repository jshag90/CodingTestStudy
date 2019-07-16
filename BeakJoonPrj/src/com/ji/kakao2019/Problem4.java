package com.ji.kakao2019;

public class Problem4 {
	
	public static void main(String[] args) {
		
		int[] food_times = { 3, 1, 2 };
//		int[] food_times = { 1, 3, 3, 4, 5 };
		long k = 5;

		
		int result = solution(food_times, k);
		System.out.println(result);
		
	}

	 public static int solution(int[] food_times, long k) {
		int foodIndex = 0;
		for (int time = 0; time < k; time++) {

			if (foodIndex > food_times.length - 1) {
				foodIndex = 0;
			}

			int foodTime = food_times[foodIndex];
			if (foodTime == 0) {
				foodIndex++;
				foodTime = food_times[foodIndex];
			}

			int temp = foodTime - 1;
			food_times[foodIndex] = temp;

			foodIndex++;

		}

		int answer=-1;
		for (int i=0; i<food_times.length; i++) {
			if (food_times[i] > 0)
				answer=i+1;
		}
		
		return answer;
	}

}
