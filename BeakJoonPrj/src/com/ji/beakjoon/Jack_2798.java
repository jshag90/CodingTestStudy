package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Jack_2798 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String cardCounts = br.readLine();
		String[] inputCountSplite = cardCounts.split(" ");
		Integer cardCount = Integer.parseInt(inputCountSplite[0]);
		Integer cardMaxValue = Integer.parseInt(inputCountSplite[1]);
		
		System.out.println(cardCount);
		System.out.println(cardMaxValue);
		
		String cardNumbers = br.readLine();
		String[] inputNumbersSplite = cardCounts.split(" ");
		
		for(String number : inputNumbersSplite) {
		System.out.println(number);
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
