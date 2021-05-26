package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeNumberOne {

	public static int calcuCount = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int inputNumber = Integer.valueOf(br.readLine());
		List<Integer> resultList = new ArrayList<Integer>();
		makeNumberOne(inputNumber);
		resultList.add(calcuCount);
		calcuCount = 0;
		makeNumberOne(inputNumber-1);
		resultList.add(calcuCount);
		
		bw.write("result : " + Collections.min(resultList));

		br.close();
		bw.flush();
		bw.close();

	}

	public static void makeNumberOne(int inputNumber) {
		System.out.println(inputNumber);

		if (inputNumber % 3 == 0) {
			inputNumber = inputNumber / 3;
			calcuCount++;
			if (inputNumber != 1)
				makeNumberOne(inputNumber);
		} else if (inputNumber % 2 == 0) {
			inputNumber = inputNumber / 2;
			calcuCount++;
			if (inputNumber != 1)
				makeNumberOne(inputNumber);
		}

	}

}
