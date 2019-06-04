package com.ji.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prime_1929 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String inputNumber = br.readLine();
		String[] inputNumberSplite = inputNumber.split(" ");
		Integer startNumber = Integer.parseInt(inputNumberSplite[0]);
		Integer endNumber = Integer.parseInt(inputNumberSplite[1]);
		
		checkPrimeNumber(startNumber, endNumber, endNumber-1);

		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static boolean checkPrimeNumber(int start, int end, int end2){
		
		int num = end;
		int num2 = end2;
		
		if (num % num2 == 0 && num2 > 1 ){
			return false;
		}else if(num % num2 != 0 && num2 > 1 ){
			return checkPrimeNumber(start,num, num2 - 1);
		}else{
			return true;
		}
			
			
	}


}
