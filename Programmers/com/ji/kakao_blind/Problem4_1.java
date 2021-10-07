package com.ji.kakao_blind;
import java.util.ArrayList;
import java.util.List;

public class Problem4_1 {
	//https://geonlee.tistory.com/67
	public static void main(String[] args) {
		
		int[] food_times = { 3, 1, 2 };
//		int[] food_times = { 1, 3, 3, 4, 5 };
		long k = 5;

		
		int result = solution(food_times, k);
		System.out.println(result);
		
	}

	public static int solution(int[] food_times, long k) {
		int answer = 0;
		int food_times_length = food_times.length;
		List<Integer> deleteTimeList = new ArrayList<Integer>();

		for (int i = 0; i < food_times.length; i++) {
			if (i == 0) {
				int delTime = food_times[i] * (food_times_length - i);
				deleteTimeList.add(delTime);
			} else {
				int delTime = (food_times[i] - food_times[i - 1]) * (food_times_length - i);
				deleteTimeList.add(delTime);
			}

			if (deleteTimeList.size() > k) {
				break;
			}

		}

		return answer;
	}

}
