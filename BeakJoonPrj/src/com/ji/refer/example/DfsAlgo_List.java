package com.ji.refer.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DfsAlgo_List {
	
	static int Nv;
	static int Ne;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> ad;
	
	public static void dfs(int i){
		visit[i] = true;
		System.out.println(i);
		
		for(int j : ad.get(i)){
			if(visit[j] == false){
				dfs(j);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Nv = scan.nextInt();
		Ne = scan.nextInt();
		ad = new ArrayList();
		visit = new boolean[Nv+1];
		
		for(int i=0; i< Nv +1; i++){
			ad.add(new ArrayList());
		}
		
		
		for(int i=0; i< Ne; i++){
			int t1 = scan.nextInt();
			int t2 = scan.nextInt();
			
			ad.get(t1).add(t2);
			ad.get(t2).add(t1);
		}
		
		dfs(1);
		
	}

}
