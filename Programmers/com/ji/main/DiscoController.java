package com.ji.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

	public int solution2(int[][] jobs) {
		int answer = 0;
		int count = 0;// 처리된 디스크
		int now = 0;//작업이 끝난시간
		
		Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
		int i = 0;
		while(count < jobs.length){
			while (i< jobs.length && jobs[i][0] <= now){
				queue.add(jobs[i++]);
			}
			
			if(queue.isEmpty()){
				now = jobs[i][0];
			}else{
				int[] tmp = queue.poll();
				answer += tmp[1] + now - tmp[0];
				now += tmp[1];
				count++;
			}
		}
		
		return answer/ jobs.length;
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
