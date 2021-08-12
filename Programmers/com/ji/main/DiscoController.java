package com.ji.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiscoController {

	public static void main(String[] args) {
		solution(new int[][] {{0,3},{1,9},{2,6}});
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
		for (int i = 0; i < jobs.length; i++) {

			int start = jobs[i][0];
			int end = jobs[i][1];
			int diff = end - start;

			TaskVO tVO = new TaskVO(start, end, diff, 0);
			taskList.add(tVO);

		}
		
		Collections.sort(taskList, new Comparator<TaskVO>() {
			@Override
			public int compare(TaskVO o1, TaskVO o2) {
				if(o1.getDiff() > o2.getDiff()) {
					return 1;
				}else if(o1.getDiff() < o2.getDiff()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		for(TaskVO tVO : taskList) {
			System.out.println(tVO.getStart() + " ");
		}
		

		return answer;
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
