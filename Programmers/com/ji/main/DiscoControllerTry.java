package com.ji.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiscoControllerTry {

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

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// 각 테스크가 작은 순서 부터 정렬
		List<int[]> jobsList = new ArrayList<>();
		for (int i = 0; i < jobs.length; i++) {
			jobsList.add(jobs[i]);
		}

		Collections.sort(jobsList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int o1TaskDuration = o1[1] - o1[0];
				int o2TaskDuration = o2[1] - o2[0];
				if (o1TaskDuration < o2TaskDuration)
					return -1;
				else if (o1TaskDuration >= o2TaskDuration)
					return 1;
				return 0;
			}
		});

		List<TaskVO> taskList = new ArrayList<>();
		int beforeTaskEnd = 0;
		for (int i = 0; i < jobsList.size(); i++) {
			int start = jobsList.get(i)[0] + beforeTaskEnd;
			int end = start + jobsList.get(i)[1];
			int diff = end - start;
			TaskVO tVO = new TaskVO(start, end, diff, beforeTaskEnd);
			taskList.add(tVO);
			int index = i + 1;
			beforeTaskEnd = end - index;
		}

		int sum = 0;
		for (TaskVO vo : taskList)
			sum += vo.getDelay() + vo.getDiff();

		return sum / taskList.size();

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
