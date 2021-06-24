package com.ji.beakjoon.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci2_1003 {

	public static List<Integer> countArr = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner scan = new Scanner(System.in);
		List<Integer> inputNumbers = new ArrayList<Integer>();

		while (scan.hasNextLine()) {
			Integer word = Integer.valueOf(scan.nextLine());
			inputNumbers.add(word);
			if (inputNumbers.size() > inputNumbers.get(0))
				break;
		}
		scan.close();

		for (int i = 1; i < inputNumbers.size(); i++) {

			fibonacci(inputNumbers.get(i));
			
			int countOne = 0,countZero = 0;
			for(Integer num : countArr){
				if(num == 1)
					countOne++;
				else
					countZero++;
			}
			
			System.out.println(countZero +" " +countOne);
			countArr.clear();
			countArr = new ArrayList<Integer>(); 

		}

	}

	public static int fibonacci(int n) {

		if (n == 0) {
			countArr.add(0);
			return 0;
		} else if (n == 1) {
			countArr.add(1);
			return 1;
		} else {
			int num1 = n - 1, num2 = n - 2;
			return fibonacci(num1) + fibonacci(num2);
		}
		
	}

}
