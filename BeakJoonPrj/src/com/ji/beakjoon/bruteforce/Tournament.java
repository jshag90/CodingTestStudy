package com.ji.beakjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] personInfos = br.readLine().split(" ");
		int N = Integer.parseInt(personInfos[0]);
		int kimNumber = Integer.parseInt(personInfos[1]);
		int imNumber = Integer.parseInt(personInfos[2]);
		
		List<Integer> personNumList = new ArrayList<>();
		for(int i=1; i<N+1; i++)
			personNumList.add(i);
		
		while(personNumList.size() > 0) {

			for(int i=0; i< personNumList.size(); i++) {
				
				if(personNumList.get(i)%2 == 0 ) {
					
					
				}
				
				
			}
			
		}
		
	}

}
