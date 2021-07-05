package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CrossingBridge {
	
	static Integer[] dp;
	static int maxEnergy = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int stoneCount = Integer.valueOf(br.readLine());
		dp = new Integer[stoneCount+1];
		dp[0] = dp[1] = 0;
		
		List<Integer[]> energyList = new ArrayList<>();
		for(int i=0; i<stoneCount-1; i++) {
			String[] stepEnergy = br.readLine().split(" ");
			Integer[] energyArr = new Integer[stepEnergy.length];
			energyArr[0] = Integer.valueOf(stepEnergy[0]);
			energyArr[1] = Integer.valueOf(stepEnergy[1]);
			energyList.add(energyArr);
		}
		maxEnergy = Integer.valueOf(br.readLine());
		
		int result = 0;
		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static int recur(int N, int number, List<Integer[]> energyList) {
		
		if(dp[N] == null) {
			
//			dp[N] = Math.min(recur(N-1, energy[0], energyList), recur(N-1, energy[1], energyList));
			
		}
		
		return dp[N];
	}

}
