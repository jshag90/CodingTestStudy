package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ATM_Try {

	//각 사람이 돈을 인출하는 시간의 합의 최소값을 구하는 문제이니
	// BFS 활용을 하여 풀면 될듯 하다.
	// 입력된 각 사람이 돈을 인출하는 시간을 조합해서 최소값이 나오는 경우를 이용
	// 숫자을 조합해서 나올수 있는 경우의 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int personCount = Integer.valueOf(br.readLine());
		String[] delayTime = br.readLine().split(" ");
		
		int[] personNumber = new int[personCount];
		for(int i=0; i<personCount; i++ )
			personNumber[i] = i;
		
		System.out.println(personNumber.length);
		
		List<String> makeOrderNumber = new ArrayList<String>();
		Integer len = personCount;

		// dfs를 이용한 입력된 숫자가 조합할 수 있는 모든 경우의 수 저장
		dfs(0, personNumber, new int[len], new boolean[len], makeOrderNumber);
		
		int minNum = Integer.MAX_VALUE;
		for(String numArr : makeOrderNumber){
			
			System.out.println(numArr);
			int sum = 0;
			for(char num : numArr.toCharArray()) {
				String numStr = String.valueOf(num);
				int orderNum = Integer.valueOf(numStr);
				 sum+=Integer.parseInt(delayTime[orderNum]);
			}
			if(sum < minNum)
				minNum = sum;
		}
			System.out.println(minNum);

		br.close();
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, List<String> makeOrderNumber) {
		if (n == arr.length) {// 입력된 숫자 길이 만큼의 경우의 숫자들

			String str = "";
			for(int res : result)
				str+=res;
				makeOrderNumber.add(str);

		} else {

			for (int i = 0; i < arr.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[n] = arr[i];
					dfs(n + 1, arr, result, visit, makeOrderNumber);
					visit[i] = false;
				}
			}

		}
	}
	
	
}
