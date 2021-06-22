package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Bomberman {

	static char[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		for (int t = 0; t < testCase; t++) {

		String[] plantCabbageInfo = br.readLine().split(" ");
		int fieldCntHorizantal = Integer.valueOf(plantCabbageInfo[0]); // 행렬 가로 길이
		int fieldCntVertical = Integer.valueOf(plantCabbageInfo[1]);// 행렬 세로 길이
		int time = Integer.valueOf(plantCabbageInfo[2]);// 행렬에 1이 있는 위치
		graph = new char[fieldCntHorizantal + 1][fieldCntVertical + 1];
		int[] dy = { -1, 1, 0, 0 };// 상하좌우위아래
		int[] dx = { 0, 0, -1, 1 };
		
		Queue<int[]> que = new LinkedList<>();

		for (int i = 0; i < fieldCntHorizantal; i++) {
			String comPairNum = String.valueOf(br.readLine());
			for (int j = 0; j < fieldCntVertical; j++) {
				graph[i][j] = comPairNum.toCharArray()[j];
				
				if(graph[i][j] == 'O') {
					que.add(new int[] {i ,j});
				}
				
			}
		}

		 while (!que.isEmpty()) {
	            for (int s = que.size(); s > 0; s--) {
	                int[] cur = que.poll();

	                //상하좌우아래 검사
	                for (int k = 0; k < 4; k++) {
	                    int ny = cur[0] + dy[k]; //가로
	                    int nx = cur[1] + dx[k]; //세로

	                    if (ny < 0 || nx < 0 || ny >= fieldCntHorizantal || nx >= fieldCntVertical || graph[ny][nx] != '.')
	                        continue;
	                               
	                    graph[ny][nx] = 'X';
	                    //익은 토마토 큐에 저장
	                    que.add(new int[] { ny, nx });
	                }
	            }
	        }
		 
		 

		for (int i = 0; i < fieldCntHorizantal; i++) {
			for (int j = 0; j < fieldCntVertical; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
