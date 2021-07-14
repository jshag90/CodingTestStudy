package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConsecutiveSum {

	static Integer[] dp;
	static int[] numbersArr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer numberCount = Integer.valueOf(br.readLine());

		dp = new Integer[numberCount + 1];
		numbersArr = new int[numberCount + 1];

		String[] inputNumbers = br.readLine().split(" ");
		for (int i = 1; i < numberCount + 1; i++)
			numbersArr[i] = Integer.valueOf(inputNumbers[i-1]);
		
		dp[0] = 1;
		dp[1] = numbersArr[1] + numbersArr[2];
		
		for(int i =1 ; i<numberCount+1; i++ ) {
				dp[i] = Math.max(dp[i-1], dp[i - 2] + numbersArr[i]);
		}

		bw.write(String.valueOf(dp[numberCount]));

		br.close();
		bw.flush();
		bw.close();
	}

//	public static int recur(int N) {
//		
//		if(dp[N] == null) {
//			
//		}
//		
//		return dp[N];
//	}

}
