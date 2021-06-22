package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class AssignClassroom {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer N = Integer.valueOf(br.readLine());
		PriorityQueue<Lecture> priorityQueue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String[] lectureInfo = br.readLine().split(" ");
			priorityQueue.offer(new Lecture(Integer.parseInt(lectureInfo[0]), Integer.parseInt(lectureInfo[1])));
		}
		
		Lecture firstLecture = priorityQueue.poll();
		int result = 0;
		while(!priorityQueue.isEmpty()) {
			Lecture lecture = priorityQueue.poll();
			if(firstLecture.getStartTime() < lecture.getStartTime()) {
				result++;
			}
			
		}
		
	
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
			return -1;
		} else if(target.startTime == this.startTime) {
			if(this.startTime < this.startTime) { 
				return -1;
			}
		}
		return 1;
	}

}

