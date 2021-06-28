package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SafeZone {

	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int[] dy = { -1, 1, 0, 0 };//상하좌우위아래
        int[] dx = { 0, 0, -1, 1 };
        int M = sc.nextInt();
        int N = M;

        int[][] zoneMap = new int[N][M];
        int cnt = 0, days = 0;
        Queue<int[]> que = new LinkedList<>();

        //행렬값 초기화
        for (int n = 0; n < N; n++) {
        	String[] locationInfo = br.readLine().split(" ");
            for (int m = 0; m < M; m++) {
            	int location = Integer.valueOf(locationInfo[m]);
            	zoneMap[n][m] = location;
            	if(location > 4)
            		que.add(new int[] { n, m });
            }
        }

//        while (cnt > 0 && !que.isEmpty()) {
//            for (int s = que.size(); s > 0; s--) {
//                int[] cur = que.poll();//익은 토마토 위치
//
//                //상하좌우아래 검사
//                for (int k = 0; k < 4; k++) {
//                    int ny = cur[0] + dy[k]; //가로
//                    int nx = cur[1] + dx[k]; //세로
//
//                    //익은 토마토만 통과
//                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || zoneMap[ny][nx] > 4)
//                        continue;
//                               
//                    cnt--;
//                    zoneMap[ny][nx] = -1;
//                    //익은 토마토 큐에 저장
//                    que.add(new int[] { ny, nx });
//                }
//            }
//            
//        }
        
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
            	System.out.print(zoneMap[n][m]+" ");
            }
            System.out.println();
        }
        
//        bw.write(String.valueOf(result) + "\n");
        bw.flush();
		bw.close();
	}
	
	
}
