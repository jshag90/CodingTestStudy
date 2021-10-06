package com.ji.beakjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DiameterTree {

	static ArrayList<dEdge> list[];
	static int nodeCnt;
	static int max = 0;
	static boolean visited[];
	static int max_idx = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		nodeCnt = Integer.parseInt(br.readLine());

		list = new ArrayList[nodeCnt + 1];
		for (int i = 0; i <= nodeCnt; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < nodeCnt - 1; i++) {
			String[] nodeInfoRead = br.readLine().split(" ");
			int parent = Integer.parseInt(nodeInfoRead[0]);
			int child = Integer.parseInt(nodeInfoRead[1]);
			int weight = Integer.parseInt(nodeInfoRead[2]);

			// 각 리스트 index에 노드 정보를 저장
			// parent와 child가 가으면 서로 연결 된 상태
			list[parent].add(new dEdge(child, weight));
			list[child].add(new dEdge(parent, weight));
		}

		// 루트 노드 부터 dfs를 돌아서 가중치가 큰 노드를 찾음
		visited = new boolean[nodeCnt + 1];
		visited[1] = true;
		dfs(1, 0);

		// 가중치가 가장 큰 노드를 중심으로 가중치의 합을 저장함
		visited = new boolean[nodeCnt + 1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		System.out.println(max);

	}

	private static void dfs(int idx, int cnt) {

		if (max < cnt) {
			max = cnt;
			max_idx = idx;
		}

		for (dEdge edge : list[idx]) {
			if (!visited[edge.idx]) {
				visited[edge.idx] = true;
				dfs(edge.idx, cnt + edge.cnt);
			}
		}

	}

}

class dEdge {
	int idx;
	int cnt;

	public dEdge(int idx, int cnt) {
		super();
		this.idx = idx;
		this.cnt = cnt;
	}

}