package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준1261 - 알고스팟
 * 
 * @author seonhak
 * @date 2021. 10. 5.
 */
public class AlgoSpot {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dy = { -1, 1, 0, 0 };// 상하좌우위아래
		int[] dx = { 0, 0, -1, 1 };
		String[] mapSize = br.readLine().split(" ");
		int M = Integer.parseInt(mapSize[0]), N = Integer.parseInt(mapSize[1]);

		int[][] map = new int[N][M];
		int cnt = 0;
		Queue<int[]> que = new LinkedList<>();

		// 행렬값 초기화
		int wallCnt = 0;
		for (int n = 0; n < N; n++) {
			String[] mapInfo = br.readLine().split("");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(mapInfo[m]);
				if(map[n][m] == 1) {
					wallCnt++;
				}else {
					que.add(new int[] { n, m });
				}
			}
		}


		while (wallCnt > 0 && !que.isEmpty()) {

			for (int s = que.size(); s > 0; s--) {
				
				int[] cur = que.poll();
				// 상하좌우아래 검사
				for (int k = 0; k < 4; k++) {
					int ny = cur[0] + dy[k]; // 가로
					int nx = cur[1] + dx[k]; // 세로

					if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 1)
						continue;

					wallCnt--;
					map[ny][nx] = 0;
					que.add(new int[] { ny, nx });
				}

			}
			cnt++;
		}

		bw.write(String.valueOf(wallCnt == 0 ? cnt:0) + "\n");
		bw.flush();
		bw.close();
	}

}
