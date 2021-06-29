package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IntervalSum5 {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sizeSumCountStr = br.readLine().split(" ");
		int gridSize = Integer.valueOf(sizeSumCountStr[0]);
		int sumCount = Integer.valueOf(sizeSumCountStr[1]);

		int[][] numbersMap = new int[gridSize][gridSize];

		for (int i = 0; i < gridSize; i++) {
			String[] points = br.readLine().split(" ");
			for (int j = 0; j < gridSize; j++) {
				numbersMap[i][j] = Integer.valueOf(points[j]);
			}
		}

		dp = new int[sumCount];
		
		for (int k = 0; k < sumCount; k++) {
			String[] points = br.readLine().split(" ");
			int x1 = Integer.valueOf(points[0]);
			int y1 = Integer.valueOf(points[1]);
			int x2 = Integer.valueOf(points[2]);
			int y2 = Integer.valueOf(points[3]);


			int sum = 0;
			for (int i = 0; i < gridSize; i++) {
				for (int j = 0; j < gridSize; j++) {

					if ((x1 - 1) <= i && (x2 - 1) >= i && (y1 - 1) <= j && (y2 - 1) >= j) {
//						sum += numbersMap[i][j];
						dp[k] +=numbersMap[i][j];
					}
				}
			}
			bw.write(String.valueOf(sum) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}

