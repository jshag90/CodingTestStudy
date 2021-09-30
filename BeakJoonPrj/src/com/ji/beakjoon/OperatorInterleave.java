package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OperatorInterleave {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer numberCount = Integer.parseInt(br.readLine());
		int[] numbersArr = new int[numberCount];
		int[] operatorArr = new int[4];
		
		String[] readNumbers = br.readLine().split(" ");
		for(int i=0; i<numberCount; i++) {
			numbersArr[i] = Integer.parseInt(readNumbers[i]);
		}
		
		// +, - , x , / 순서
		String[] readOperatorArr = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			operatorArr[i] = Integer.parseInt(readOperatorArr[i]);
		}
		//최대는 -, /를 먼저한다.
		int maxSum = numbersArr[0]; 
		for(int i=1; i<numberCount; i++) {
			
			if(operatorArr[1] > 0) { 
				maxSum =maxSum-numbersArr[i];
				operatorArr[1] = operatorArr[1]-1;
				continue;
			}
			
			if(operatorArr[3] > 0) {
				maxSum =maxSum/numbersArr[i];
				operatorArr[3] = operatorArr[3]-1;
				continue;
			}
			
			if(operatorArr[0] > 0) { 
				maxSum =maxSum+numbersArr[i];
				operatorArr[0] = operatorArr[0]-1;
				continue;
			}
			
			if(operatorArr[2] > 0) { 
				maxSum =maxSum*numbersArr[i];
				operatorArr[2] = operatorArr[2]-1;
				continue;
			}
			
		}
		
		for(int i=0; i<4; i++) {
			operatorArr[i] = Integer.parseInt(readOperatorArr[i]);
		}
		
		int minSum = numbersArr[0]; 
		for(int i=1; i<numberCount; i++) {
			
			if(operatorArr[0] > 0) { 
				minSum =minSum+numbersArr[i];
				operatorArr[0] = operatorArr[0]-1;
				continue;
			}
			
			if(operatorArr[3] > 0) {
				minSum =minSum/numbersArr[i];
				operatorArr[3] = operatorArr[3]-1;
				continue;
			}
			
			if(operatorArr[1] > 0) { 
				minSum =minSum-numbersArr[i];
				operatorArr[1] = operatorArr[1]-1;
				continue;
			}
			
			if(operatorArr[2] > 0) { 
				minSum =minSum*numbersArr[i];
				operatorArr[2] = operatorArr[2]-1;
				continue;
			}
			
		}
		
		System.out.println(maxSum);
		System.out.println(minSum);
		
	}

}
