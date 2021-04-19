package com.ji.beakjoon.refer;

import java.util.Scanner;

public class DfsAlgo_Array {
	
	static int nE;
	static int nV;
	static int[][] ad;
	static boolean[] visit;
	
	public static void dfs(int i){
		visit[i] = true;
		System.out.println(i+ " ");
		
		for(int j = 1; j < nV+1; j++){
			if(ad[i][j] == 1 && visit[j] == false){
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		nV = scan.nextInt();
		nE = scan.nextInt();
		ad = new int[nV+1][nV+1];
		visit = new boolean[nV+1];
		  
		
		for(int i=0; i< nE; i++){
			int t1 = scan.nextInt();
			int t2 = scan.nextInt();
			
			ad[t1][t2] = ad[t2][t1] = 1;
		}
		
		dfs(1);
	}

}
