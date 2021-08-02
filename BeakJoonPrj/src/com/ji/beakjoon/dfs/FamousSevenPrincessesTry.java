package com.ji.beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FamousSevenPrincessesTry {

	static int[] dx = { 1, -1, 0, 0 }; // 상하좌우위아래
	static int[] dy = { 0, 0, 1, -1 };
	static int fixedSize = 5;
	static char[] map = new char[(fixedSize * fixedSize)];

	public static List<char[]> outputList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int index = 0;
		for (int i = 0; i < fixedSize; i++) {
			String studentInfo = String.valueOf(br.readLine());
			for (int j = 0; j < fixedSize; j++) {
				map[index++] = studentInfo.charAt(j);
			}
		}

		per1(map, 0, map.length, 7);

	}

	// 순열을 이용한 경우의 수
	static void per1(char[] arr, int depth, int n, int r) {
		if (depth == r) {

			int sCnt = 0;
			for (int i = 0; i < r; i++) {
				if (arr[i] == 'S')
					sCnt++;
			}

			if (sCnt >= 4) {
				for (int i = 0; i < r; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}

			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(char[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		char temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
