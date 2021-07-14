package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// 설치 가능한 경우에 수
// 3개가 주어지면 좌표에서 설치 가능한 경우의 수
public class InstallWifi {
	
	static boolean installed = true;
	static ArrayList<int[]> DFSvisitArr;
	static int wifiCount = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] info = br.readLine().split(" ");
		int homeCount = Integer.valueOf(info[0]);
		wifiCount = Integer.valueOf(info[1]);
		DFSvisitArr = new ArrayList();
		boolean[] visited = new boolean[homeCount];
		int[] homePoints = new int[homeCount];
		for (int i = 0; i < homeCount; i++) {
			homePoints[i] = Integer.valueOf(br.readLine());
		}
		comb1(homePoints, visited, 0, wifiCount, DFSvisitArr);
		
		for(int[] numArr : DFSvisitArr) {
			for(int i=0; i<wifiCount; i++)
				System.out.print(numArr[i]+" ");
			System.out.println();
		}
		
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	 static void comb1(int[] arr, boolean[] visited, int start, int r, ArrayList<int[]> DFSvisitArr) {
	        if(r == 0) {
	        	
	        	 for(int i = 0; i < arr.length; i++) {
	 	            if(visited[i] == true ) {
	 	            	int[] indexArr = new int[wifiCount];
	 	            	indexArr[i] = arr[i];
//	 	                System.out.print(arr[i] + " ");
	 	            	DFSvisitArr.add(indexArr);
	 	            }
	 	        }
//	        	  System.out.println();
	        	
	            return;
	        } else {
	            for(int i = start; i < arr.length; i++) {
            		visited[i] = true;
	                comb1(arr, visited, i + 1, r - 1, DFSvisitArr);
	                visited[i] = false;
	            }
	        }
	    }
	

}
