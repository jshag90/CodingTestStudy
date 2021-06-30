package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Coin1 {

	static Integer[] dp;
	static int[] coinTypes;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] condition = br.readLine().split(" ");
		int coinType = Integer.valueOf(condition[0]);
		int targetNum = Integer.valueOf(condition[1]);
		
		coinTypes = new int[coinType];
		for(int i=0; i < coinType; i++) {
			coinTypes[i] = Integer.valueOf(br.readLine());
		}
		
		dp = new Integer[targetNum + 1];
		dp[0] = dp[1] =0;
		
		int result = recur(targetNum);
		bw.write(String.valueOf(result));
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static int recur(int targetNum) {
		 
		if (dp[targetNum] == null) {
			
			for(int i=0; i< coinTypes.length; i++) {
					dp[targetNum] = recur(targetNum-coinTypes[i]*i);
			}
			
		}
		
		return dp[targetNum];
	}
}
