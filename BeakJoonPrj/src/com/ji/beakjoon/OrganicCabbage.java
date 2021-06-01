package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class OrganicCabbage {
	
	static int fieldCntHorizantal, fieldCntVertical; //노드 개수
	static int plantCabbageCnt; //간선 개수
	static int[][] graph;
	static boolean[] DFSisVisited;
	static List<Integer> DFSvisitArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		int testCase = Integer.valueOf(br.readLine());
		String[] plantCabbageInfo = br.readLine().split(" ");
		fieldCntHorizantal = Integer.valueOf(plantCabbageInfo[0]);
		fieldCntVertical = Integer.valueOf(plantCabbageInfo[1]);
		plantCabbageCnt = Integer.valueOf(plantCabbageInfo[2]);
		graph = new int[fieldCntHorizantal][fieldCntVertical];
		DFSisVisited = new boolean[(fieldCntVertical*fieldCntHorizantal)+1];
		
		DFSvisitArr = new ArrayList<Integer>();
		
		for(int i=0; i<plantCabbageCnt; i++) {
			String[] comPairNum = String.valueOf(br.readLine()).split(" ");
			int a = Integer.parseInt(comPairNum[0]);
			int b = Integer.parseInt(comPairNum[1]);
			graph[a][b] = 1;
		}
		
//		for( int i = 0 ; i < (fieldCntVertical*fieldCntHorizantal)+1 ; i++) {
//			DFSisVisited[i] = false;
//		}
		
		for(int i=0; i< fieldCntHorizantal; i++ ) {
			for(int j=0; j<fieldCntVertical; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		
		
//		dfs(1);
//
//		for( int i = 0 ; i < DFSvisitArr.size() ; i++ ) {
//			System.out.print(DFSvisitArr.get(i) + " ");
//		}
//		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int nodeNum) {
		// 방문한 노드 번호에 대한 boolean 처리
		DFSisVisited[nodeNum] = true;
		// 방문한 순서에 대한 노드 정보 리스트 저장
		DFSvisitArr.add(nodeNum);
		for (int i = 1; i <= fieldCntHorizantal*fieldCntVertical; i++) {
			if (graph[nodeNum][i] == 1 && DFSisVisited[i] == false) {
				dfs(i);
			}
		}
	}

}
