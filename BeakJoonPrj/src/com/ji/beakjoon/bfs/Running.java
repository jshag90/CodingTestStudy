package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Running {

	static int N, M, maxMoveSize;
	static char map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	static boolean[][] visited;
	static int ret;
	static class Points {
		int x, y;

		public Points(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] mapInfo = br.readLine().split(" ");
		N = Integer.valueOf(mapInfo[0]);
		M = Integer.valueOf(mapInfo[1]);
		maxMoveSize = Integer.valueOf(mapInfo[2]);
		map = new char[N][M];
		visited = new boolean[N][M];
		ret = 0;
		for (int i = 0; i < N; i++) {
			char[] gymInfo =br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = gymInfo[j];
			}
		}
		
		Queue<Points> que = new LinkedList<>();
		String[] startEndPoints = br.readLine().split(" ");
		int x1 = Integer.parseInt(startEndPoints[0])-1;
		int y1 = Integer.parseInt(startEndPoints[1])-1;
		int x2 = Integer.parseInt(startEndPoints[2])-1;
		int y2 = Integer.parseInt(startEndPoints[3])-1;
		Points startPoint = new Points(x1, y1);
		Points endPoint = new Points(x2, y2);
		
		que.add(startPoint);
		visited[x1][y1] = true;
		boolean isMoveSuccess = false;
		while(!que.isEmpty()) {
			Points cur = que.poll();
			if(cur.x == endPoint.x && cur.y == endPoint.y) {
				isMoveSuccess = true;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nr = cur.x + dr[i];
				int nc = cur.y + dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M||visited[nr][nc]|| map[nr][nc] == '#') continue;
				
				visited[nr][nc] = true;
				ret++;
				
			}
			
		}
		
		System.out.println(ret);

	}
}
