package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bomberman {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


//		for (int t = 0; t < testCase; t++) {

			String[] plantCabbageInfo = br.readLine().split(" ");
			int fieldCntHorizantal = Integer.valueOf(plantCabbageInfo[0]); // 행렬 가로 길이
			int fieldCntVertical = Integer.valueOf(plantCabbageInfo[1]);// 행렬 세로 길이
			int time = Integer.valueOf(plantCabbageInfo[2]);//행렬에 1이 있는 위치
			char[][] graph = new char[fieldCntHorizantal + 1][fieldCntVertical + 1];

			for(int i=0; i< fieldCntHorizantal; i++) {
				String comPairNum = String.valueOf(br.readLine());
				for (int j = 0; j < fieldCntVertical; j++) {
					graph[i][j] = comPairNum.toCharArray()[j];
				}
			}
			
			for(int i=0; i< fieldCntHorizantal; i++) {
				for (int j = 0; j < fieldCntVertical; j++) {
//					System.out.print(graph[i][j]+" ");
					if (graph[i][j] == 'O') {
						dfs(graph, i, j);
					}
					
				}
//				System.out.println();
			}

			for(int i=0; i< fieldCntHorizantal; i++) {
				for (int j = 0; j < fieldCntVertical; j++) {
					System.out.print(graph[i][j]+" ");
				}
				System.out.println();
			}
			
//			bw.write(String.valueOf(count)+"\n");
//		}

		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(char[][] graph, int i, int j) {
		int m = graph.length; //가로 행렬 크기
		int n = graph[0].length; // 세로 행렬 크기
		
		//행렬에서 0이거나 마지막에 있는 값일 경우 재귀 탈출
		if (i < 0 || i >= m || j < 0 || j >= n || graph[i][j] != 'O')
			return;
		
		//처음 1이 나오고 근처에 있는 1일 경우 -1로 바꿈
		graph[i][j] = 'O';

		dfs(graph, i - 1, j);// 위
		dfs(graph, i + 1, j);// 아래
		dfs(graph, i, j - 1);// 왼쪽
		dfs(graph, i, j + 1);// 오른쪽
	}

}
