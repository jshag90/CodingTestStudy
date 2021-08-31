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
public class BalancedWorldTry {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String readLine = br.readLine();
			if (readLine.substring(0).equals("."))
				break;

			String[] readLineArr = readLine.split("");
			List<String> brakectList = new ArrayList<String>();
			for (String str : readLineArr) {
				if (str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]")) {
					brakectList.add(str);
				}
			}
			
			while (brakectList.get(0).equals("(") || brakectList.get(0).equals("]")) {
				if (brakectList.size() < 1)
					break;
				boolean isExistClose = false;
				if (brakectList.get(0).equals("(")) {

					for (int j = 1; j < brakectList.size(); j++) {
						if (brakectList.get(j).equals(")")) {
							brakectList.remove(j);
							brakectList.remove(0);
							isExistClose = true;
						}
					}
				}

				if (!isExistClose)
					break;

				if (brakectList.size() < 1)
					break;

				if (brakectList.get(0).equals("[")) {

					for (int j = 1; j < brakectList.size(); j++) {
						if (brakectList.get(j).equals("]")) {
							brakectList.remove(j);
							brakectList.remove(0);
							isExistClose = true;
						}
					}
				}
				
				if (brakectList.size() < 1)
					break;

				if (!isExistClose)
					break;

			}

			if (brakectList.size() == 0)
				bw.write("yes\n");
			else
				bw.write("no\n");

		}

		br.close();
		bw.flush();
		bw.close();

	}

}
