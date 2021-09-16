package com.ji.beakjoon.bfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato7569 {

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Scanner sc = new Scanner(System.in);
		int[] dy = { -1, 1, 0, 0};// 상하좌우위아래
		int[] dx = { 0, 0, -1, 1};
		int[] dh = {1, 0};
		int M = sc.nextInt(), N = sc.nextInt(), H = sc.nextInt();
		int[][][] tomato = new int[N][M][H];
		int cnt = 0, days = 0;
		Queue<int[]> que = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
						
						tomato[n][m][h] = sc.nextInt();
						if (tomato[n][m][h] == 1) {
							que.add(new int[] { n, m, h });
						} else if (tomato[n][m][h] == 0) {
							cnt++;
						}
						
					}
				}
		}
		
		

		// 익지 않은 토마토 가 있고, 큐에 노드가 있으면
		while (cnt > 0 && !que.isEmpty()) {
			
			for (int s = que.size(); s > 0; s--) {
				int[] cur = que.poll();// 익은 토마토 위치

					
					
				for(int h = 0; h < 2; h++) {
					int nh = cur[2] + dh[h]; // 세로
					
					for (int k = 0; k < 4; k++) {
						int ny = cur[0] + dy[k]; // 가로
						int nx = cur[1] + dx[k]; // 세로
	
							if (ny < 0 || nx < 0 || nh <0 || ny >= N || nx >= M || nh >= H|| tomato[ny][nx][nh] != 0)
								continue;
							if(tomato[ny][nx][nh] == -1)
								continue;
		
							cnt--;
							tomato[ny][nx][nh] = 1;
							
							que.add(new int[] { ny, nx, nh });
						}
					}
				
			}
			// 날짜 증가
			days++;
		}

		String result = String.valueOf(cnt == 0 ? days : -1);
		bw.write(String.valueOf(result) + "\n");
		bw.flush();
		bw.close();

	}

}
