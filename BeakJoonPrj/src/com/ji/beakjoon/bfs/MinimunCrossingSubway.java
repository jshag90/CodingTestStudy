package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimunCrossingSubway {
	
	static int N, M; 
	static boolean[] visitedLine; 
	static boolean[] visitedStation; 
	static ArrayList<Integer>[] stations; 
	static ArrayList<Integer>[] lines; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //역의 갯수
		M = Integer.parseInt(st.nextToken()); //노선의 개수
		
		visitedLine = new boolean[M + 1];
		visitedStation = new boolean[N + 1];
		stations = new ArrayList[N+1];
		lines = new ArrayList[N +1];
		for(int i = 1; i < N+1; i++) {
			stations[i] = new ArrayList<>();
			lines[i] = new ArrayList<>();
		}
		
		for(int i= 1; i<=M; i++) {
			String[] s = br.readLine().split(" ");
			for(String station : s) {
				int statN = Integer.parseInt(station);
				if(statN == -1) break; 
				stations[statN].add(i);
				lines[i].add(statN);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int answer = go(start, end);
		System.out.println(answer);
	}

	private static int go(int start, int end) {
		//최소 환승 횟수를 출력을 위해서 우선순위 큐를 저장
		//각 환승 경로의 환승 횟수를 저장
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.transCount));
		visitedStation[start] = true;
		for(int line : stations[start]) {
			pq.add(new Node(line, start, 0));
			visitedLine[line] = true;
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.curStation == end) {
				return now.transCount;
			}
			
			for(int nextStation : lines[now.curLine]) {
				
				if(!visitedStation[nextStation]) {
					visitedStation[nextStation] = true;
					pq.add(new Node(now.curLine, nextStation, now.transCount));
					
					for(int nextLine: stations[nextStation]) {
						if(!visitedStation[nextLine]) {
							visitedStation[nextLine] = true;
							pq.add(new Node(nextLine, nextStation, now.transCount+1));
						}
					}
				}
				
			}
			
		}
		
		return -1;
	}
	
	private static class Node{
		int curLine; 
		int curStation; 
		int transCount;
		
		public Node(int curLine, int curStation, int transCount) {
			super();
			this.curLine = curLine;
			this.curStation = curStation;
			this.transCount = transCount;
		} 
		
	}
	
}
