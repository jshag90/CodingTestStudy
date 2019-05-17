package com.ji.mailprogramming;

import java.util.ArrayList;
import java.util.List;

public class Question02 {

	public static void main(String[] args) {
		
		int input = 12;
		List<Integer> fiboArr = new ArrayList<Integer>();
		System.out.println("INPUT : "+ input);

		int result = 0;

		fiboArr.add(0);
		fiboArr.add(1);
		fiboArr.add(1);

		int sum = 0;
		for (int j = 2; j < input; j++) {
			sum = fiboArr.get(j - 1) + fiboArr.get(j);
			if (sum > input)
				break;

			fiboArr.add(sum);
		}

		fiboArr.remove(2);

		for (int k = 0; k < fiboArr.size(); k++) {
			if (fiboArr.get(k) % 2 == 0) {
				result += fiboArr.get(k);
			}
		}

		System.out.println("OUTPUT : "+result);

	}

}
