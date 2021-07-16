package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 아기 상어
 * @author ji
 *
 */
public class BabySharkTry {
	static int map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static class Shark{
		int r,c,size;
		int time;
		
		public Shark(int r, int c,  int size, int time) {
			super();
			this.r = r;
			this.c = c;
			this.size = time;
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine()); //공간의 크기
		map = new int[N][N];
		
		Queue<Shark> que = new LinkedList<>();
		boolean visit[][] = new boolean[N][N];
		int emptyCnt = 0;
		for(int i=0; i<N;i++) {
			String[] fishInfo =br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.valueOf(fishInfo[j]);
				if(map[i][j] == 9) {
					visit[i][j] = true;
					que.add(new Shark(i, j, 2, 0));
				}else if(map[i][j] == 0) {
					emptyCnt++;
				}
					
			}
		}
		
		
		
		if(emptyCnt == (N*N) - 1) { 
			System.out.println(0);
		}else {
		
			while(!que.isEmpty()) {
				
				  for (int s = que.size(); s > 0; s--) {
					  Shark cur = que.poll();
					  
					  for(int i=0; i<4; i++) {
						  int nr = cur.r+dr[i];
						  int nc = cur.c+dc[i];
						  
						  if(nr<0||nc<0||nr>=N||nc>=N||visit[nr][nc]) continue;
							
					  }
					  
					  
					  
				  }
				
				
			}
			
			
		}
			
		
	}
}
