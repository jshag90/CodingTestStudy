package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LostBracket {

	static List<Integer> sumNumArr = new ArrayList<Integer>();
	static Integer minVal = 0;
	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		
		String calcuFormula = String.valueOf(br.readLine());
		char[] calcu = calcuFormula.toCharArray();
		
		List<String> formulaList = new ArrayList<>();
		for(int i=0; i<calcu.length; i++) {
			String calcuStr = String.valueOf(calcu[i]);
			boolean regex = Pattern.matches("[+]|[-]", calcuStr);
			if(regex) 
				formulaList.add(calcuStr);
		}

		String[] numbers = calcuFormula.split("[+]|[-]");
		
		
		int inputLen = numbers.length;
		
		int[] inputNumbers = new int[inputLen];
		for (int i = 0; i < inputLen; i++) {
			inputNumbers[i] = Integer.valueOf(numbers[i]);
		}

		int[] output = new int[inputLen];
		boolean[] visited = new boolean[inputLen];
		List<int[]> makeNumber = new ArrayList<int[]>();
		dfs(0, initNodeValue(inputNumbers, inputLen), new int[inputLen], new boolean[inputLen], formulaList, engine);

//		for(int[] arr : makeNumber) {
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//		}

//		bw.write("result : " + engine.eval(calcuFormula));
		bw.write("result : " + minVal);

		br.close();
		bw.flush();
		bw.close();
	}

	public static int[] initNodeValue(int[] numToArr, Integer numLength) {
		int[] result = new int[numLength];
		for (int i = 0; i < numLength; i++) {
			String numStr = String.valueOf(numToArr[i]);
			result[i] = Integer.valueOf(numStr);
		}
		return result;
	}

	public static void dfs(int n, int[] arr, int[] result, boolean[] visit, List<String> formulaList , ScriptEngine engine) throws ScriptException {
		if (n == arr.length) {// 입력된 숫자 길이 만큼의 경우의 숫자들
			
			String formulaStr = "";
			for(int i = 0; i< result.length-1 ;i++) {
				formulaStr += result[i]+formulaList.get(i);
			}
			formulaStr+=result[result.length-1];
			System.out.println(formulaStr);
			int calcu = (int)engine.eval(formulaStr);
			System.out.println(calcu);
			if( minVal >= (int)engine.eval(formulaStr))
				minVal = (int)engine.eval(formulaStr);

		} else {

			for (int i = 0; i < arr.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[n] = arr[i];
					dfs(n + 1, arr, result, visit, formulaList, engine);
					visit[i] = false;
				}
			}

		}
	}

}
