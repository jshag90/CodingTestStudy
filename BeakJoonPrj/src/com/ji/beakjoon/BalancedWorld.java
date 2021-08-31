package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
			for (String str : readLineArr) {
				if (str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]")) {
					brakectList.add(str);
				}
			}
			
			Stack<String> stack = new Stack<>();
			for (int i = 0; i < brakectList.size(); i++) {

				if(brakectList.get(i).equals("(") || brakectList.get(i).equals("["))
					stack.push(brakectList.get(i));
				else if(brakectList.get(i).equals(")")) {
					if(stack.empty() || stack.peek() != "(" ) {
						bw.write("no\n");
						return;
					}else {
						stack.pop();
					}
				}
				else if(brakectList.get(i).equals("]")) {
					if(stack.empty() || stack.peek() != "[" ) {
						bw.write("no\n");
						return;
					}else {
						stack.pop();
					}
					
				}

			}

			if (stack.empty())
				bw.write("yes\n");
			else
				bw.write("no\n");

		}

		br.close();
		bw.flush();
		bw.close();

	}

}
