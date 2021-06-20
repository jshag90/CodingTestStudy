package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchParentsTreeTry2 {

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
		}

		for (int j = 2; j <= nodeNum; j++) {

		}

	}

	class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	class Tree {
		
		Node root; //루트 노드 처음엔 null 상태 
		public void createNode(char data, char leftData, char rightData) {
			if(root == null) { //아무것도 없는 초기 상태 - A 루트 노드 생성 
				root = new Node(data);
				
				//좌우 값이 있는 경우에만 노드 생성 
				if(leftData != '.') { 
					root.left = new Node(leftData);
				}
				if(rightData != '.') {
					root.right = new Node(rightData);
				}
			} else {
				
			}
		}
	}

}


