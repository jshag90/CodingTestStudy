package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WolfSheep {

	static char map[][];
	static Queue<WolfVO> que = new LinkedList<WolfVO>();
	static List<SheepVO> sheepPositionList = new ArrayList<SheepVO>();
	static int[] dy = { -1, 1, 0, 0 };//상하좌우위아래
    static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mapSizeInfo = br.readLine().split(" ");
		int rowSize = Integer.valueOf(mapSizeInfo[0]);
		int colSize = Integer.valueOf(mapSizeInfo[1]);
		map = new char[rowSize][colSize];
		
		boolean[][] visit = new boolean[rowSize][colSize];
		
		for(int i=0; i<rowSize; i++) {
			String wolfSeepInfo = String.valueOf(br.readLine());
			for(int j=0; j<colSize; j++) {
				map[i][j] = wolfSeepInfo.charAt(j);
				if(map[i][j] == 'W') {
					que.add(new WolfVO(i,j));
					visit[i][j] = true;
				}else if(map[i][j] == 'S') {
					sheepPositionList.add(new SheepVO(i, j));
				}
			}
		}
		  
		while(!que.isEmpty()) {
			
			for(int s = que.size(); s> 0 ; s --) {
				WolfVO cur = que.poll();
				
				for(int k=0; k<4; k++) {
					int ny = cur.y + dy[k];
					int nx = cur.x + dx[k];
					
				    if (ny < 0 || nx < 0 || ny >= colSize || nx >= rowSize || visit[ny][nx] )
				    	continue;
			        
				    if(map[ny][nx] == 'S') {
				    	map[ny][nx] = 'D';
				    }
				    
				    visit[ny][nx] = true;
				    que.add(new WolfVO(nx, ny));
				    
				}
				
				
			}
			
		}
		
		for(int i=0; i<rowSize; i++) {
			for(int j=0; j<colSize; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
}

class WolfVO {
	int x, y;
	
	WolfVO(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

class SheepVO {
	int x, y;
	
	SheepVO(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}


