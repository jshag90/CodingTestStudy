package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LaserCommunication {

	static int N, M;
	static char[][] map;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	
	static List<Pair> startEnd = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Scanner sc = new Scanner(System.in);
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		M = sc.nextInt();
		N = sc.nextInt();

		map = new char[N][M];
		int cnt = 0;

		Queue<int[]> que = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			String readLine = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = readLine.charAt(m);
				if(map[n][m] == 'C') {
					startEnd.add(new Pair(n, m));
				}
			}
		}

		bfs();
//        bw.write(String.valueOf(result) + "\n");
		bw.flush();
		bw.close();

	}

	private static void bfs() {
		boolean visit[][] = new boolean[N][M];
		Queue<Pair> que = new LinkedList<>();
		que.add(startEnd.get(0));
		visit[startEnd.get(0).r][startEnd.get(0).c] = true;
		while(!que.isEmpty()) {
			Pair cur = que.poll();
			if(cur.r == startEnd.get(1).r && cur.c ==  startEnd.get(1).c) {
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M||visit[nr][nc] || map[nr][nc] == '*') continue;
				
				
				visit[nr][nc] = true;
				que.add(new Pair(nr, nc));
				
			}
			
		}
		
	}

}
