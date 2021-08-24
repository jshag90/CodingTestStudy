package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 - 균형잡힌 세상
 * 
 * @author ji
 *
 */
public class BalancedWorld {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String readLine = br.readLine();
			if (readLine.substring(0).equals("."))
				break;

			String[] readLineArr = readLine.split("");
			List<String> brakectList = new ArrayList<String>();
			for(String str : readLineArr) {
				if(str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]")) {
					brakectList.add(str);
				}
			}
			System.out.println(brakectList.toString());
			for(int i=0; i<brakectList.size();i++) {
				System.out.println(brakectList.get(i));
				if(brakectList.get(i).equals("(")) {
					
					for(int j=i+1; j<brakectList.size();j++) {
						if(brakectList.get(j).equals(")")) {
							brakectList.remove(j);
							brakectList.remove(i);
						}
					}
				}
				
				if(brakectList.get(i).equals("[")) {
					
					for(int j=i+1; j<brakectList.size();j++) {
						if(brakectList.get(j).equals("]")) {
							brakectList.remove(j);
							brakectList.remove(i);
						}
					}
				}
					
			}
			System.out.println("test : "+brakectList.size());

//			if (leftSmallBraketCnt == rightSmallBraketCnt && leftBigBraketCnt == rightBigBraketCnt)
//				bw.write("yes\n");
//			else
//				bw.write("no\n");

		}

		br.close();
		bw.flush();
		bw.close();

	}

}
