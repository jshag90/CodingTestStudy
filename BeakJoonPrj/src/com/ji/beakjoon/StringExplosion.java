package com.ji.beakjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문자열 폭발
 * 
 * @author ji
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringExplosion {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		String answer = solution(str, bomb);
		System.out.println((answer.length() == 0) ? "FRULA" : answer);
		
	}

	private static String solution(String str, String bomb) {
		char[] result = new char[str.length()];
		int idx = 0;
		for (int i = 0; i < str.length(); i++) {
			result[idx] = str.charAt(i);
			//폭발할 문자열이 나타나면 하나씩 증가하면 인덱스를 
			//검증할 문자열 길이 만큼 감소 시켜 감을 넣게된다.
			if (isBomb(result, idx, bomb))
				idx -= bomb.length();
			idx++;
		}
		return String.valueOf(result, 0, idx);
	}

	private static boolean isBomb(char[] result, int idx, String bomb) {
		if (idx < bomb.length() - 1)
			return false;
		for (int i = 0; i < bomb.length(); i++) {
			int resultIndex = idx - bomb.length() + 1 + i;
			//검증할 문자열 길이 만큼의 index와 result의 저장된 문자열이 같은지 검사
			//첫번째 문자열이 다르면 loop탈출
			if (bomb.charAt(i) != result[resultIndex])
				return false;
		}
		return true;
	}

}
