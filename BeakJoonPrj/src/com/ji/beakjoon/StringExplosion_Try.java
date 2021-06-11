package com.ji.beakjoon;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 폭발
 * 
 * @author ji
 *
 */
public class StringExplosion {

	static String result = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String originString = br.readLine();
		String explosionString = br.readLine();

		char[] originChar = originString.toCharArray();
		char[] explosionChar = explosionString.toCharArray();

		excuteExplosion(originChar, explosionChar, explosionString);

		bw.write(String.valueOf(result) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

	public static void excuteExplosion(char[] originChar, char[] explosionChar, String explosionString) {

		int[] ignoreIndex = new int[2];
		ignoreIndex[0] = 0;
		ignoreIndex[1] = 0;
		for (int i = 0; i < originChar.length - explosionChar.length; i++) {

			String mergedChar = "";
			int endIndex = i + explosionChar.length;
			for (int j = i; j < endIndex; j++) {
				mergedChar += String.valueOf(originChar[j]);
			}

			if (mergedChar.equals(explosionString)) {
				ignoreIndex[0] = i;
				ignoreIndex[1] = endIndex;
			}

			if (ignoreIndex[1] > 0)
				break;
		}

		String explodedString = "";
		for (int index = 0; index< originChar.length; index++) {
			if (index >= ignoreIndex[0] && index < ignoreIndex[1])
				continue;
			explodedString += originChar[index];
		}

		if (ignoreIndex[0] == 0 && ignoreIndex[1] == explosionChar.length) {
			result = "FRULA";
		} else if (ignoreIndex[1] > 0) {
			excuteExplosion(explodedString.toCharArray(), explosionChar, explosionString);
		} else {
			if(explodedString.substring(explodedString.length() - explosionChar.length) == explosionString)
				explosionString = explosionString.substring(0, explodedString.length() - explosionChar.length);
			result = explodedString;
		}

	}

}
