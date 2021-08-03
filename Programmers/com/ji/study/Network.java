package com.ji.study;

public class Network {
	
	public static void main(String[] args) {
		int n = 3;
		int[][] com = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution(n, com));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(computers[i][j] == 1) {
					answer++;
					dfs(computers, i, j);
				}
				
			}
		}
		
		return answer;
	}
	
	static void dfs(int[][] graph, int i, int j) {
		int m = graph.length; //가로 행렬 크기
		int n = graph[0].length; // 세로 행렬 크기
		
		//행렬에서 0이거나 마지막에 있는 값일 경우 재귀 탈출
		if (i < 0 || i >= m || j < 0 || j >= n || graph[i][j] != 1)
			return;
		
		//처음 1이 나오고 근처에 있는 1일 경우 -1로 바꿈
		graph[i][j] = -1;

		dfs(graph, i - 1, j);// 위
		dfs(graph, i + 1, j);// 아래
		dfs(graph, i, j - 1);// 왼쪽
		dfs(graph, i, j + 1);// 오른쪽
	}

}
