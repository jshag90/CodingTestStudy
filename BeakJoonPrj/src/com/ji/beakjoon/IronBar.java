package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IronBar {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cutIronCount = 0;

		String bracketStr = String.valueOf(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < bracketStr.length(); i++) {
			if (bracketStr.substring(i, i + 1).equals("("))
				stack.push(i); //'('경우만 저장
			else { 
				// ')'을 만났을 경우
				//stack의 index번호가 바로 전 index와 같으면 레이저('()')를 의미
				if (stack.peek() == i - 1) { 
					stack.pop();
					cutIronCount += stack.size();
				} else {
					// ')'')' 일경우는 단순 증가
					stack.pop();
					cutIronCount++;
				}
			}
		}

		bw.write(String.valueOf(cutIronCount));

		br.close();
		bw.flush();
		bw.close();
	}

}
