package com.ji.beakjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidFood {

	static char map[][];
	static int fieldHorizantal, fieldVertical;
	static int foodCnt;
	static int foodSize = 0;
	static List<Integer> foodSizeList = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mapInfo = br.readLine().split(" ");
		fieldVertical = Integer.parseInt(mapInfo[0]); // 세로길이
		fieldHorizantal = Integer.parseInt(mapInfo[1]); // 가로길이
		foodCnt = Integer.parseInt(mapInfo[2]);

		map = new char[fieldHorizantal + 1][fieldVertical + 1];
		for (int i = 0; i < fieldVertical; i++) {
			for (int j = 0; j < fieldHorizantal; j++) {
				map[i][j] = '.';
			}
		}

		for (int i = 0; i < foodCnt; i++) {
			String[] points = br.readLine().split(" ");
			int xaivs = Integer.parseInt(points[0]);
			int yaivs = Integer.parseInt(points[1]);
			map[xaivs-1][yaivs-1] = '#';
		}

		for (int i = 0; i < fieldVertical; i++) {
			for (int j = 0; j < fieldHorizantal; j++) {
				if (map[i][j] == '#') {
					foodSize = 0;
					dfs(map, i, j);
					foodSizeList.add(foodSize);
				}
			}
		}
		
		for (int i = 0; i < fieldVertical; i++) {
			for (int j = 0; j < fieldHorizantal; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

		Collections.reverse(foodSizeList);
		bw.write(String.valueOf(foodSizeList.get(0)));
		bw.close();
		br.close();

	}

	static void dfs(char[][] graph, int i, int j) {
		int m = fieldHorizantal + 1, n = fieldVertical + 1;

		if (i < 0 || i >= m || j < 0 || j >= n || graph[i][j] != '#')
			return;

		graph[i][j] = '-';
		foodSize++;

		dfs(graph, i - 1, j);// 위
		dfs(graph, i + 1, j);// 아래
		dfs(graph, i, j - 1);// 왼쪽
		dfs(graph, i, j + 1);// 오른쪽
	}

}
