package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringRepeat {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < testCase; t++) {
			String[] readLine = br.readLine().split(" ");
			StringBuilder fullText = new StringBuilder();
			char[] charArr = readLine[1].toCharArray();
			for(char ch : charArr) {
				for(int j=0;j<Integer.parseInt(readLine[0]); j++) {
					fullText.append(ch);
				}
			}
			bw.write(String.valueOf(fullText)+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
