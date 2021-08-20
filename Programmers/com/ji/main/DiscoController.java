package com.ji.main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiscoController {

	public static void main(String[] args) {
		int result = solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } });
		System.out.println(result);
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		int count = 0;// 처리된 디스크
		int now = 0;// 작업이 끝난시간

		Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));

		PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
		int i = 0;
		while (count < jobs.length) {
			while (i < jobs.length && jobs[i][0] <= now) {
				queue.add(jobs[i++]);
			}

			if (queue.isEmpty()) {
				now = jobs[i][0];
			} else {
				int[] tmp = queue.poll();
				answer += tmp[1] + now - tmp[0];
				now += tmp[1];
				count++;
			}
		}

		return answer / jobs.length;
	}

}
