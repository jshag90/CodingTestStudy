package com.ji.backjoon.problem02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Inequality_2529 {
	
	static List<Integer> minList = new ArrayList<Integer>();

	public static void main(String[] args) {
//BFS 
//각 노드에 넣어가서

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			Integer[] inputNumbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			System.out.println("입력 1 : ");
			 int inqualityCnt = Integer.parseInt(br.readLine()); //부등호갯수
			 System.out.println("입력 2 : ");
			String inqualitys = br.readLine(); //부등호입
			
			String[] strInqulity = new String[inqualityCnt-2];
			strInqulity = inqualitys.split(" ");
			
			Integer[] minArray = new Integer[inqualityCnt+1];
			Integer[] maxArray = new Integer[inqualityCnt+1];
			
		
			for(int i=0; i< strInqulity.length ; i++) {
			
				for(int j=0; j< inputNumbers.length-1; j++) {
					if(strInqulity[i].equals(">")) {
						if(inputNumbers[j]>inputNumbers[j+1]) {
							swap(inputNumbers, inputNumbers[j], inputNumbers[j+1]);
						}
					}else {
						if(inputNumbers[j]<inputNumbers[j+1]) {
							swap(inputNumbers, inputNumbers[j], inputNumbers[j+1]);
						}
						
					}
				}
				
			}
				
				for(Integer num : inputNumbers) {
					System.out.print(num+" ");
				}
			
			
			br.close();
			
			bw.flush();
			bw.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	

    public static void swap(Integer[] array, Integer i1, Integer i2) {
    	Integer temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;        
    }


	
	public static void checkNumbers(String inequlity, Integer num, Integer nextNum) {
		
//			System.out.println(inequlity);
//			System.out.println(num);
//			System.out.println(nextNum);
			
			if(inequlity.equals("<")) {
				
				if(num < nextNum) {
					minList.add(num);
					minList.add(nextNum);
				}else {
					minList.add(nextNum);
					minList.add(num);
				}
				
			}else {
				
				if(num > nextNum) {
					minList.add(num);
					minList.add(nextNum);
				}else {
					minList.add(nextNum);
					minList.add(num);
				}
				
			}
			
			for(int j=0; j < minList.size(); j++) {
				System.out.print(minList.get(j)+" ");
			}
			
		
	}

}
