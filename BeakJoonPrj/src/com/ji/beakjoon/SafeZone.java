package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SafeZone {

	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dy = { -1, 1, 0, 0 };//상하좌우위아래
        int[] dx = { 0, 0, -1, 1 };
        int M = Integer.valueOf(br.readLine());
        int N = M;

        int[][] zoneMap = new int[N][M];
        int[][] zoneMapOrg = new int[N][M];
        int cnt = 0, days = 0;

        //행렬값 초기화
        int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
        for (int n = 0; n < N; n++) {
        	String[] locationInfo = br.readLine().split(" ");
            for (int m = 0; m < M; m++) {
            	int location = Integer.valueOf(locationInfo[m]);
            	zoneMap[n][m] = location;
            	if(max < location) 
					max = location;
				if(min > location)
					min =  location;
            }
        }

        zoneMapOrg = zoneMap;
		List<Integer> cntList = new ArrayList<>();
		for(int h = min; h<=max; h++ ) {
			
			int count = 0;
			zoneMap =  new int[N][M];
			zoneMap = zoneMapOrg;
			for (int j = 0; j < N ; j++) {
				for (int i = 0; i < M ; i++) {
					
					if (zoneMap[i][j] > h) {
						count++;
						dfs(zoneMap, i, j, h);
					}
				}
			}
			System.out.println(count);
//			cntList.add(count);
		}
        
//        for (int n = 0; n < N; n++) {
//            for (int m = 0; m < M; m++) {
//            	System.out.print(zoneMap[n][m]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(Collections.max(cntList));
        
    	br.close();
        bw.flush();
		bw.close();
	}
	
	static void dfs(int[][] zoneMap, int i, int j, int height) {
		int m = zoneMap.length; //가로 행렬 크기
		int n = zoneMap[0].length; // 세로 행렬 크기
		
		//행렬에서 0이거나 마지막에 있는 값일 경우 재귀 탈출
		if (i < 0 || i >= m || j < 0 || j >= n || zoneMap[i][j] <= height)
			return;
		
		//처음 1이 나오고 근처에 있는 1일 경우 -1로 바꿈
		zoneMap[i][j] = -1;

		dfs(zoneMap, i - 1, j, height);// 위
		dfs(zoneMap, i + 1, j, height);// 아래
		dfs(zoneMap, i, j - 1, height);// 왼쪽
		dfs(zoneMap, i, j + 1, height);// 오른쪽
	}
	
	
}
