package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 2차원 배열에 인구 정보 초기화 
 * 2. 인접해 있는 정수들의 차이가 L이상 R이하인지 검사 
 * 3. 1) 통과시 검사해서 조건에 맞으면 큐안에 넣어줌 
 * 		2) 통과 안되면 패스 
 * 4. 1)의 경우 큐안에 있는 인구들의 합/큐 크기 하여 나온 값을 원래 2차원 배열에 저장 위 경우
 * 반복하면 반복할 경우 인구이동 카운트 증가
 * 
 * @author ji
 *
 */
public class PopulationMove {

	static int nodeNum, edgeNum, startNode;
	static int[][] graph;
	static boolean[] BFSisVisited;
	static ArrayList<Integer> BFSvisitArr;

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] initInfo = br.readLine().split(" ");
		int countryCount = Integer.valueOf(initInfo[0]);
		int minPop =  Integer.valueOf(initInfo[1]);
		int maxPop = Integer.valueOf(initInfo[2]);
		
		Queue<int[]> que = new LinkedList<>();
		int[] dy = { -1, 1, 0, 0 };// 상하좌우위아래
		int[] dx = { 0, 0, -1, 1 };

		graph = new int[countryCount][countryCount];

		for (int i = 0; i < countryCount; i++) {
			String[] populationInfo = br.readLine().split(" ");
			for (int j = 0; j < countryCount; j++) {
				graph[i][j] = Integer.parseInt(populationInfo[j]);
				
			}
		}
		
		
		for (int i = 0; i < countryCount-1; i++) {
			for (int j = 0; j < countryCount-1; j++) {
				
				int currContry = graph[i][j];
				if(j+1 < countryCount) {
					int diffH = Math.abs(currContry - graph[i][j+1] );
					if(diffH >=  minPop && diffH <= maxPop) {
						que.add(new int[]{i,j});
						que.add(new int[]{i, j+1});
					}
				}
				
				if(i+1 < countryCount) {
					int diffV = Math.abs(currContry - graph[i+1][j] );
					if(diffV >=  minPop && diffV <= maxPop) {
						que.add(new int[]{i,j});
						que.add(new int[]{i+1, j});
					}
				}
			}
		}
		
		//인접 행렬의 차이를 계산
//	     while (!que.isEmpty()) {
//	    	 
//	    	  int[] cur = que.poll();//익은 토마토 위치
//	    	  
//	    	  for (int k = 0; k < 4; k++) {
//                  int ny = cur[0] + dy[k]; //가로
//                  int nx = cur[1] + dx[k]; //세로
//                  
//                  if (ny < 0 || nx < 0 || ny >= countryCount || nx >= countryCount )
//                      continue;
//                  
////                  System.out.println(ny);
//////                  System.out.println(nx);
//                  System.out.println(graph[nx][ny]);
//                  
//	    	  }
//	    	 
//	     }

//		for (int i = 0; i < countryCount; i++) {
//			for (int j = 0; j < countryCount; j++) {
//				System.out.print(graph[i][j] + " ");
//			}
//			System.out.println();
//		}

		
		bw.flush();
		bw.close();
	}

//	static void bfs(int node) {
//		// 방문한 노드 처리
//		BFSisVisited[node] = true;
//		// 방문한 노드 번호 리스트 저장
//		BFSvisitArr.add(node);
//		for (int i = 1; i <= nodeNum; i++) {
//			// 간선이면서, 방문한 노드가 아니고, 검색해야할 노드 큐에 저장해준다.
//			if (graph[node][i] == 1 && BFSisVisited[i] == false && queue.contains(i) == false) {
//				queue.add(i);
//			}
//		}
//
//		// 검색 큐가 비어있지 않으면 검색 큐에서 삭제해준 후 제 검색
//		if (!queue.isEmpty())
//			bfs(queue.poll());
//	}
}
