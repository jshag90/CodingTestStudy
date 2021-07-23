package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RoboticVaccum2 {
	static int R;//행
	static int C;//열
	static int graph[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char map[][];
	static int result = Integer.MAX_VALUE;
	static ArrayList<coordinate> dust;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] roomSize = br.readLine().split(" ");
		C = Integer.valueOf(roomSize[0]);//열
		R= Integer.valueOf(roomSize[1]);//행
			while( C != 0 && R != 0) {
				dust = new ArrayList<>();
				map = new char[R][C];
				result = Integer.MAX_VALUE;
				
				for(int i=0; i < R; i++) {
					char str[] = br.readLine().toCharArray();
					for(int j=0; j < C; j++) {
							if(str[j] == 'o') { //청소기 위치
								dust.add(0, new coordinate(i, j));
							}else if(str[j] == '*') {//더러운 칸 위치
								dust.add(new coordinate(i, j));
							}
							
							//가구 칸 일 경우
							if(str[j] == 'x') {
								map[i][j] = 'x';
							}else {
								map[i][j] = '.';
							}
					}
					
				}
				
				graph = new int[dust.size()][dust.size()];
				
				for(int i=0; i<dust.size(); i++) {
					
					for(int j=i+1; j < dust.size(); j++) {
						int len= bfs(dust.get(i), dust.get(j));
						graph[i][j] = graph[j][i] = len;
						
						//로봇 청소기가 더러운 곳으로 도착할 수 없는 경우
						if(i == 0 && len == -1) {
							result = -1;
							break;
						}
						
					}
					
					if(result == -1) {
						break; 
					}
					
				}
				
				if(result != -1) {
					boolean[] visited = new boolean[dust.size()+1];
					//방문한 더러운 곳의 순열
					dfs("", visited,0);
				}
				
				bw.write(String.valueOf(result)+"\n");
				//다음 테스트 케이스 초기화
				roomSize = br.readLine().split(" ");
				C = Integer.valueOf(roomSize[0]);//열
				R= Integer.valueOf(roomSize[1]);//행
			}
			
			br.close();
			bw.flush();
			bw.close();
	}
	
	private static void dfs(String output, boolean[] visited, int depth) {
		if(depth == dust.size()-1) {
			searchMinPath(output);
		}
		
		if(result == -1) {
			return;
		}
		
		for(int i=1; i<dust.size(); i++) {
			if(visited[i] != true) {
				visited[i] = true;
				dfs(output+i+" ", visited, depth+1 );
				visited[i] = false;
			}
		}
		
	}

	private static void searchMinPath(String path) {
		String str[] = path.split(" ");
		int temp = 0;
		int index = 0;
		
		for(int i=0; i<str.length; i++) {
			if(graph[index][Integer.parseInt(str[i])] != -1) {
				temp += graph[index][Integer.parseInt(str[i])];
				index = Integer.parseInt(str[i]);
			}else if(graph[index][Integer.parseInt(str[i])] == -1) {
				result = -1;
				return;
			}
		}
		
		if(temp < result) {
			result = temp;
		}
		
	}

	//로봇 청소기와 각각의 더러운 곳 사이의 거리를 구함
	private static int bfs(coordinate start, coordinate end) {
		Queue<coordinate> que = new LinkedList<>();
		que.offer(start);
		int visited[][] = new int[R][C];
		
		for(int i=0; i<R; i++) {
			Arrays.fill(visited[i], -1);
		}
		
		visited[start.x][start.y] = 0;
		
		while (!que.isEmpty()) {
			coordinate cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if(x < 0 || R <= x || y < 0 || C <= y) 
					continue;
				
				if(visited[x][y] != -1 || map[x][y] == 'x')
					continue;
				
				if(x == end.x && y == end.y)
					return visited[cur.x][cur.y]+1;
				
				visited[x][y] = visited[cur.x][cur.y]+1;
				que.offer(new coordinate(x, y));
				
			}
			
		}
		
		return -1;
		
	}

	static class edge implements Comparable<edge>{
		int node ;
		int len;
		
		public edge(int node, int len) {
			super();
			this.node = node;
			this.len = len;
		}
		
		@Override
		public int compareTo(edge o) {
			return len - o.len;
		} 
		
	}

	static class coordinate {
		int x; 
		int y;
		
		public coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
}
