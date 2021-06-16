package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SearchParentsTree {

	static int nodeNum, edgeNum, startNode;
	static int[][] graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodeNum = Integer.valueOf(br.readLine());
		startNode = 1;// 시작 노드는 고정
		graph = new int[nodeNum + 1][nodeNum + 1];

		for (int i = 0; i < nodeNum - 1; i++) {
			String[] edgeNumbers = br.readLine().split(" ");
			int a = Integer.valueOf(edgeNumbers[0]);
			int b = Integer.valueOf(edgeNumbers[1]);
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		for (int j = 2; j <= nodeNum; j++) {
			System.out.println("son : " + j);
			for (int i = 1; i < nodeNum; i++) {
				if (graph[j][i] == 1) {

					System.out.println("x axios : " + i);

				}

			}

		}

	}

	public static boolean checkParentsNode(int startNode) {
		boolean result = false;
		if (graph[startNode][1] == 1 || graph[1][startNode] == 1) {
			result = true;
		}
		return result;
	}

}
