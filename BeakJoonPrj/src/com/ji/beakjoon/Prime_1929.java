package com.ji.beakjoon;

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
		
		checkPrimeNumber( startNumber, endNumber, endNumber-1);

		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static void checkPrimeNumber(int start, int end, int end2) throws IOException{
		
		int num = end;
		int num2 = end2;
		
		if (num % num2 == 0 && num2 > 1 && end >= start){//?†Œ?ˆ˜?•„?‹˜
			checkPrimeNumber(start,num-1, num - 2);
		}else if(num % num2 != 0 && num2 > 1 && end >= start ){ //?†Œ?ˆ˜
			if(num2 == 2){
				Integer prime = num;
				System.out.println(prime);
				checkPrimeNumber(start,num-1, num - 2);
			}else{
				checkPrimeNumber(start,num, num2 - 1);
			}
		}else{
			
		}
			
	}


}
