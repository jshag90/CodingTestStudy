package com.ji.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_43165 {

	public static void main(String[] args) {

		int[] numbers = { 2,3,5,7,9 };
		int target = 2;

		solution(numbers, target);
		
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		boolean good=false;
		while(good) {
			
			int sum = 0;
			for(int number : numbers) {
				sum += number;
			}
			
			if(sum == target)
				answer++;
			else
				continue;
		}

//		List<String> makeNumber = new ArrayList<String>();
//		
//		Queue<Integer> markQueue = new LinkedList<Integer>();
//		
//		for(int i=0;i<numbers.length-1; i++) {
//			markQueue.add(0);
//		}
//		
//		int index=0;
//		while(index <numbers.length) {
//			
//			String numStr = "";
//			for(Integer num: markQueue) {
//				numStr+=num;
//			}
//			makeNumber.add(numStr);
//			
//			markQueue.poll();
//			markQueue.add(1);
//			index++;
//		}
//		makeNumber.stream().forEach(System.out::println);
		//숫자 조합 구하기
		
		List<Integer> caseNumber = new ArrayList<Integer>();
		
		Integer numLength = numbers.length;
		boolean[] visit = new boolean[numLength];
		int[] node = initNodeValue(numbers, numLength);
		int[] result = new int[numLength];
		dfs(0, node, result, visit, caseNumber);
		caseNumber.stream().forEach(System.out::println);
		
//		List<Integer> caseOnlyNumber = new ArrayList<Integer>();
//		for(String markStr : makeNumber) {
//			
//			
//		}
//		
//		for(Integer cNum: caseNumber) {
//			String cNumStr = String.valueOf(cNum);
//			if(!caseOnlyNumber.contains(cNum) ) {
//				caseOnlyNumber.add(cNum);
//			}
//		}
//		caseOnlyNumber.stream().forEach(System.out::println);
		
		
		//+를 하나씩 증가시키면 경우의 수를 구한다

		return answer;
	}
	
	
	
	
	public static int[] getIntegerArr(String num) {
		int[] result = new int[num.toCharArray().length];
		for(int i = 0; i < result.length; i++) {
			result[i] = Character.getNumericValue(num.toCharArray()[i]);  
		}
		return result;
	}
	
	public boolean isCalcu(Integer caseNum, int targetNum) {
		boolean result = false;
		
		String caseNumStr = String.valueOf(caseNum);
		for(char num : caseNumStr.toCharArray()) {
			
		}
		return result;
	}

	public static int[] initNodeValue(int[] numToArr, Integer numLength) {
		int[] result = new int[numLength];
		for (int i = 0; i < numLength; i++) {
			result[i] = Integer.valueOf(String.valueOf(numToArr[i]));
		}
		return result;
	}

	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, List<Integer> makeNumber) {

		if (n == arr.length) {

			String numStr = "";
			int resultLength = result.length;
			for (int i = 0; i < resultLength; i++) {
				numStr += result[i];
			}
			
			int makeCaseNum = Integer.valueOf(numStr);
			makeNumber.add(makeCaseNum);

		} else {

			for (int i = 0; i < arr.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[n] = arr[i];
					dfs(n + 1, arr, result, visit, makeNumber);
					visit[i] = false;
				}
			}

		}
	}

}

class markNumVO{
	
	String mark;
	int num;
	
	
}