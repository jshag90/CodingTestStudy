package com.ji.beakjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class AttendanceCheck {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] studentInfo = br.readLine().split(" ");
		int N = Integer.valueOf(studentInfo[0]); //학생의 수
		int K = Integer.valueOf(studentInfo[1]); //졸고 있는 학생의 수 
		int Q = Integer.valueOf(studentInfo[2]); //출석 코드를 보낼 학생의 수
		int M = Integer.valueOf(studentInfo[3]); //주어질 구간의 수
		
		int[] dp = new int[N+3];
		for(int i=3; i<= N+2; i++) {
			dp[i] = i;
		}
		
		List<Integer> kArr = new ArrayList<Integer>(); //졸고 있는 학생 번호 배열
		String[] sleepStudent = br.readLine().split(" ");
		for(int i=0;i<K;i++)
			kArr.add(Integer.valueOf(sleepStudent[i]));
		
		List<Integer> qArr = new ArrayList<Integer>(); //출석 코드를 받을 학생의 입장 번호
		String[] rcvStudent = br.readLine().split(" ");
		for(int j=0; j<Q; j++) {
			int recStudentNum = Integer.valueOf(rcvStudent[j]);
			if(!kArr.contains(recStudentNum))
				qArr.add(recStudentNum);
		}
		
		for(int i=3; i<= N+2; i++) {
			int a;
			if(!qArr.contains(i)) {
				a = 1;
			}else {
				a = 0;
			}
			dp[i] = dp[i -1] + a;
		}
		
		String[] MInfo = br.readLine().split(" ");
		for(int i=0; i < M-1; i++) {
			int s = Integer.parseInt(MInfo[i]);
			int e = Integer.parseInt(MInfo[i+1]);
			System.out.println(dp[e] - dp[s-1]);
		}
		
		
//		bw.write();
		br.close();
		bw.flush();
		bw.close();
		
	}

}
