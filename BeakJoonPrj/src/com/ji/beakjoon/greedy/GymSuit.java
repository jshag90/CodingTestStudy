package com.ji.beakjoon.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GymSuit {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 3 }));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		//1. lost 값이 reseve에 있는지 검사
		// 2. 없다면 reserve가 줄수 있는 숫자 목록 생성
		
		List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
		List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
		
		HashSet<Integer> sendPossibleList = new HashSet<>();
		
		for (int i = 1; i <= n; i++) {
			
			if(lostList.contains(i) && reserveList.contains(i)) {
				sendPossibleList.add(i);
			}
			
			if(reserveList.contains(i)) {
				sendPossibleList.add(i);
				if(i+1<n)
					sendPossibleList.add(i+1);
				if(i-1>1)
					sendPossibleList.add(i-1);
			}
			
			if(!lostList.contains(i) && !reserveList.contains(i)) {
				sendPossibleList.add(i);
			}
			
		}
		
		return sendPossibleList.size();
	}

}
