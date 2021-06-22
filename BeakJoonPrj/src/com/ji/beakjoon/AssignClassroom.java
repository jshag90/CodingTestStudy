package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 1. Input Data를 2차원 배열로 받는다. (new int[n][2])
	2. 입력 데이터를 오름차순으로 정렬해준다. (시작 시간이 같다면, 끝나는 시간을 오름차순으로 정렬)
	3. PriorityQueue(우선순위 큐)를 만들어주고, (정렬된)배열의 첫 번째 end값을 큐에 넣는다.
	4. 배열을 두 번째 값부터 순회하면서, start가 PriorityQueue의 peek()보다 작거나 같다면, pq에서 하나 뺀다.
	4-1. 순회하면서, 현재 end값을 새로 pq에 넣어준다.
	5. pq에 남아있는 데이터의 갯수가 필요한 강의실의 갯수이다.
 *
 */
public class AssignClassroom {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer N = Integer.valueOf(br.readLine());
		List<Lecture> lectureList = new ArrayList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String[] lectureInfo = br.readLine().split(" ");
			lectureList.add(new Lecture(Integer.parseInt(lectureInfo[0]), Integer.parseInt(lectureInfo[1])));
		}
		
		for(Lecture lecture : lectureList) {
			System.out.println(lecture.getStartTime()+" "+lecture.getEndTime());
		}
		
		priorityQueue.offer(lectureList.get(0).getEndTime());
		for(int i=1; i< lectureList.size(); i++) {
			if(priorityQueue.peek() >= lectureList.get(i).getStartTime())
				priorityQueue.poll();
			else
				priorityQueue.offer(lectureList.get(i).getEndTime());
		}
		
		int result = priorityQueue.size();
		
		bw.write(String.valueOf(result));
		br.close();
		bw.flush();
		bw.close();
	}
	

}

class Lecture implements Comparable<Lecture> {
	Integer startTime;
	Integer endTime;
	
	public Lecture(Integer startTime, Integer endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Lecture target) {
		if(target.startTime > this.startTime) {
			return 1;
		} else if(target.startTime == this.startTime) {
			if(target.endTime < this.endTime) { 
				return 1;
			}
		}
		return -1;
	}

}

