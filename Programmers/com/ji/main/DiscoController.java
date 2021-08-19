package com.ji.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiscoController {

	public static void main(String[] args) {
		int result = solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } });
		System.out.println(result);
	}

	/**
	 * Task를 길이가 가장 작은 거 부터 시작
	 * 
	 * @param jobs
	 * @return
	 */
	public static int solution(int[][] jobs) {
		int answer = 0;
		
		
		List<TaskVO> taskList = new ArrayList<>();
		int beforeTaskEnd = 0;
		for (int i = 0; i < jobs.length; i++) {
			int start = jobs[i][0] + beforeTaskEnd;
			int end = start + jobs[i][1];
			int diff = end - start;
			TaskVO tVO = new TaskVO(start, end, diff, beforeTaskEnd);
			taskList.add(tVO);

			int index = i + 1;
			beforeTaskEnd = end - index;
		}
		
		int sum = 0;
		for(TaskVO vo : taskList)
			sum += vo.getDelay()+vo.getDiff();
		answer = sum/taskList.size();
		
//		int[] caseArr = new int[taskList.size()];
//		boolean[] visited = new boolean[taskList.size()];
//		for (int i = 0; i < taskList.size(); i++) {
//			caseArr[i] = i;
//		}
		
//		List<String> makeNumber = new ArrayList<String>();
//		dfs(0, caseArr, new int[taskList.size()], visited, makeNumber);

//		for (String caseNumStr : makeNumber) {
//			String[] spNum = caseNumStr.split("");
//			
//			System.out.println(caseNumStr);
//			int sum = 0;
//			for(String num : spNum) {
//				System.out.println(num);
//				sum += taskList.get(Integer.parseInt(num)).getDelay()+taskList.get(Integer.parseInt(num)).getDiff();
//			}
//			System.out.println(sum/taskList.size());
//		}
//		answer = sum/taskList.size();

		return answer;
	}

	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, List<String> makeNumber) {
		if (n == arr.length) {// 입력된 숫자 길이 만큼의 경우의 숫자들

			String caseNumStr = "";
			for (int i = 0; i < arr.length; i++) {
				caseNumStr += result[i];
			}
			makeNumber.add(caseNumStr);

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

class TaskVO {
	int start;
	int end;
	int diff;
	int delay;

	public TaskVO(int start, int end, int diff, int delay) {
		super();
		this.start = start;
		this.end = end;
		this.diff = diff;
		this.delay = delay;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

}
