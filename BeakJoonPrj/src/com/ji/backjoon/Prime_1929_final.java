package com.ji.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Prime_1930_final {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inputNumber = br.readLine();
		String[] inputNumberSplite = inputNumber.split(" ");
		Integer startNumber = Integer.parseInt(inputNumberSplite[0]);
		Integer endNumber = Integer.parseInt(inputNumberSplite[1]);

		ArrayList<Integer> primeList = new ArrayList<Integer>();
        boolean isPrime[] = new boolean[endNumber + 1];
        for(int i = 2; i <= endNumber; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i <= endNumber; i++) {
            if(!isPrime[i]) continue;
            else {
            	if(i>=startNumber)
            	primeList.add(i);
            };
            for(int j = i*2; j <= endNumber; j += i) {
                isPrime[j] = false;
            }
        }
        for(Integer num : primeList) {
        	 bw.write(num + "\n");
        }
        

		br.close();
		bw.flush();
		bw.close();

	}


}
