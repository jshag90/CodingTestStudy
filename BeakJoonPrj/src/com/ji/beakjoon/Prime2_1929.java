package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Prime2_1929 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inputNumber = br.readLine();
		String[] inputNumberSplite = inputNumber.split(" ");
		Integer startNumber = Integer.parseInt(inputNumberSplite[0]);
		Integer endNumber = Integer.parseInt(inputNumberSplite[1]);

		boolean[] chkArray =  getPrime(endNumber);
		for (int i = startNumber; i < endNumber; i++) {
			if (chkArray[i])
				bw.write(i + "\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

	public static boolean[] getPrime(int num) throws IOException {

		boolean[] chkArray = new boolean[num];
		for (int i = 2; i < num; i++)
			chkArray[i] = true;

		for (int i = 2; i*i < num; i++) {
			if (chkArray[i] == true) {
				for (int j = i; j * i < num; j++)
					chkArray[i * j] = false;
			}
		}

		return chkArray;

	}

}
