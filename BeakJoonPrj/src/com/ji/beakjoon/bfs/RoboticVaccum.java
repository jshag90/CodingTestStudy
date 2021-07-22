package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class RoboticVaccum {
	
	static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
	static char roomMap[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		String[] roomSize = br.readLine().split(" ");
		int w = Integer.valueOf(roomSize[0]);
		int h = Integer.valueOf(roomSize[1]);
		roomMap = new char[h][w];
	    Queue<int[]> que = new LinkedList<>();
	    
	    boolean visit[][] = new boolean[h][w];
		for(int i=0; i< h; i++) {
			String roomInfo = String.valueOf(br.readLine());
			for(int j=0; j<w; j++) {
				roomMap[i][j] = roomInfo.charAt(j);
				
				if(roomMap[i][j] == 'o') {
					que.add(new int[] {i, j});
					visit[i][j] = true;
				}
				
			}
		}
		
		int ans = 0;
		while( !que.isEmpty()) {
			for(int s=que.size(); s>0 ; s--) {
				int[] cur = que.poll();
				
				  for (int k = 0; k < 4; k++) {
	                    int ny = cur[0] + dy[k]; //가로
	                    int nx = cur[1] + dx[k]; //세로
	                    
	                    //깨끗한 칸은 통과
	                    if (ny < 0 || nx < 0 || ny >= h || nx >= w || visit[ny][nx]) 
	                        continue;
	                    
//	                    if(roomMap[ny][nx] == 'x') {
//	                    	ans--;
//	                    }
	                    
	                	visit[ny][nx] = true;
	                	que.add(new int[] {ny,nx});
				  }
			}
			ans++;
		}
		
	 	String result = String.valueOf(ans);
        bw.write(String.valueOf(result) + "\n");
        bw.flush();
		bw.close();
	}

}
