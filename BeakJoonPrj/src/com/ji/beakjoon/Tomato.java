package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tomato {

	static int[][] field;
	static boolean[] BFSisVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] fieldSize = br.readLine().split(" ");
		int horizontal = Integer.valueOf(fieldSize[0]);
		int vertical = Integer.valueOf(fieldSize[1]);
		field = new int[vertical][horizontal];

		for (int i = 0; i < vertical; i++) {
			String[] tomcatStatus = br.readLine().split(" ");
			for (int j = 0; j < horizontal; j++) {
				field[i][j] = Integer.valueOf(tomcatStatus[j]);
			}
		}

		int count = 0;
		for (int i = 0; i < vertical; i++) {
			for (int j = 0; j < horizontal; j++) {
				if (field[i][j] == 1) {
					count++;
					dfs(field, i, j);
				}
			}
		}
		
		bw.write(String.valueOf(count)+"\n");

		br.close();
		bw.flush();
		bw.close();

	}
	
	static void dfs(int[][] graph, int i, int j) {
		int m = graph.length; //가로 행렬 크기
		int n = graph[0].length; // 세로 행렬 크기
		
		//행렬에서 0이거나 마지막에 있는 값일 경우 재귀 탈출
		if (i < 0 || i >= m || j < 0 || j >= n || graph[i][j] != 1)
			return;
		
		//처음 1이 나오고 근처에 있는 1일 경우 -1로 바꿈
		graph[i][j] = 1;

		dfs(graph, i - 1, j);// 위
		dfs(graph, i + 1, j);// 아래
		dfs(graph, i, j - 1);// 왼쪽
		dfs(graph, i, j + 1);// 오른쪽
	}

}
