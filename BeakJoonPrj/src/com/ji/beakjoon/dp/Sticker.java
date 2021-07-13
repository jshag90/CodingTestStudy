package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sticker {
	
	static Integer[] dp;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int numberCount = Integer.valueOf(br.readLine());
		map = new int[2][numberCount];
		for(int i=0; i<2; i++) {
			String[] stickerScores = br.readLine().split(" ");
			int max = Integer.MIN_VALUE;
			for(int j=0; j < numberCount; j++) {
				map[i][j] = Integer.parseInt(stickerScores[j]);
				if(max < map[i][j])
					max = map[i][j];
			}
			System.out.println();
			System.out.println(max);
		}
		
		for(int i=0; i<2; i++) {
			for(int j=0; j < numberCount; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
