package com.ji.beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsAndBfs02 {
	
	static int nodeNum, edgeNum, startNode;
	static int[][] graph;
	static boolean[] DFSisVisited, BFSisVisited;
	static ArrayList<Integer> DFSvisitArr, BFSvisitArr ;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nodeNum = sc.nextInt(); // 점갯수
		edgeNum = sc.nextInt(); // 선갯수
		startNode = sc.nextInt(); // 시작노드
		graph = new int[nodeNum + 1][nodeNum +1];
		
		DFSisVisited = new boolean[nodeNum +1];
		BFSisVisited = new boolean[nodeNum +1];
		DFSvisitArr = new ArrayList();
		BFSvisitArr = new ArrayList();
		queue = new LinkedList<Integer>();
		
		for( int i = 0 ; i < edgeNum ; i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		for( int i = 0 ; i < nodeNum+1 ; i++) {
			DFSisVisited[i] = false;
			BFSisVisited[i] = false;
		}
		
		dfs(startNode);
		bfs(startNode);

		for( int i = 0 ; i < DFSvisitArr.size() ; i++ ) {
			System.out.print(DFSvisitArr.get(i) + " ");
		}
		System.out.println();
		for( int i = 0 ; i < BFSvisitArr.size() ; i++ ) {
			System.out.print(BFSvisitArr.get(i) + " ");
		}

	}
	
	static void bfs(int node) {
		// 방문한 노드 처리
		BFSisVisited[node] = true;
		// 방문한 노드 번호 리스트 저장
		BFSvisitArr.add(node);
		for( int i = 1 ; i <= nodeNum ; i++) {
			//간선이면서, 방문한 노드가 아니고, 검색해야할 노드 큐에 저장해준다.
			if( graph[node][i] == 1 && BFSisVisited[i] == false && queue.contains(i)==false) {
				queue.add(i);
			}
		}
		
		//검색 큐가 비어있지 않으면 검색 큐에서 삭제해준 후 제 검색
		if(!queue.isEmpty())
			bfs(queue.poll());
	}
	
	static void dfs(int node) {
		//방문한 노드 번호에 대한 boolean 처리
		DFSisVisited[node] = true;
		//방문한 순서에 대한 노드 정보 리스트 저장
		DFSvisitArr.add(node);
		for( int i = 1 ; i <= nodeNum ; i++ ) {
			if(graph[node][i] == 1 && DFSisVisited[i] == false) {
				dfs(i);
			}
		}
	}

}

