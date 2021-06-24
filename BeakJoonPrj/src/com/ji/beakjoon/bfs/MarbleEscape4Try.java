package com.ji.beakjoon.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MarbleEscape4Try {
	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int[] dy = { -1, 1, 0, 0 };//상하좌우위아래
        int[] dx = { 0, 0, -1, 1 };
        int M = sc.nextInt(), N = sc.nextInt();

        char[][] board = new char[N][M];
        int cnt = 0, days = 0;
        Queue<int[]> redQue = new LinkedList<>();
        Queue<int[]> blueQue = new LinkedList<>();
        int[] holePosition = new int[1];

        //행렬값 초기화
//        List<char[]> readLineList = new ArrayList<char[]>();
        for(int i=0; i<N+1 ; i++) {
        	String[] stockPricesStr = br.readLine().split(" ");
//        	for (int j = 0; j < _companyCnt; j++)
//				stockPrices[i][j] = Integer.parseInt(stockPricesStr[j]);
        }
        
        for (int n = 0; n < N; n++) {
//        	char[] lineInfo = readLineList.get(n);
            for (int m = 0; m < M; m++) {
//            	System.out.print( lineInfo[m]+" ");
//            	board[n][m] = lineInfo[m];
            	
            	if(board[n][m] == 'R') {
            		redQue.add(new int[] {n, m});
            	}
            	if(board[n][m] == 'B') {
            		blueQue.add(new int[] {n, m});
            	}
            	
            	if(board[n][m] == 'O') {
            		holePosition[0] = n;
            		holePosition[1] = m;
            	}
            	
            }
            
        }
        
//        for (int n = 0; n < N; n++) {
//            for (int m = 0; m < M; m++) {
//            	System.out.print(board[n][m] + "");
//            }
//            System.out.println();
//        }
        
//        //익지 않은 토마토 가 있고, 큐에 노드가 있으면
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
//                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || tomato[ny][nx] != 0)
//                        continue;
//                               
//                    cnt--;
//                    tomato[ny][nx] = 1;
//                    //익은 토마토 큐에 저장
//                    que.add(new int[] { ny, nx });
//                }
//            }
//            //날짜 증가
//            days++;
//        }
        
        String result = String.valueOf(cnt == 0 ? days : -1);
        bw.write(String.valueOf(result) + "\n");
        bw.flush();
		bw.close();
		
	}

}
