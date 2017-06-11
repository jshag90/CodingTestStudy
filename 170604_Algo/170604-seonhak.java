package com.sundayalgo.oneday;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oneday {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		try {
			BufferedReader in = new BufferedReader(new FileReader("170604 - 알고리즘 sample01.txt"));
			String textLine;
			int lineIndex = 0;

			System.out.println("입력값 :" + args[0].toString());
			while ((textLine = in.readLine()) != null) {
				lineIndex++;
				stringPrasing(args, textLine, lineIndex);
			}

			in.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );




	}

	public static void stringPrasing(String[] args, String textLine, int lineIndex) {

		Map<String, Object> keyMap = new HashMap<String, Object>();
		Map<String, Object> valueMap = new HashMap<String, Object>();

		List<String> listStr = new ArrayList<String>();

		String searchWord = args[0];
		String regex = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";

		String[] dataArr = textLine.split(regex);
		int count = 0;
		
		int point = 0;

		for (int i = 0; i < dataArr.length; i++) {

			point +=dataArr[i].length()-1;
			if (dataArr[i].toString().trim().equals(searchWord)) {
				count++;
				valueMap.put(lineIndex + "번째 횟수:", count);
				valueMap.put("point_", point+i); //trim으로 인해서 제외된 특수 문자 추가
				keyMap.put("Line_" + lineIndex, valueMap);

			}

		}

		Iterator<String> iterator = keyMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			listStr.add(key + "," + "value" + keyMap.get(key));
		}

		for (int i = 0; i < listStr.size(); i++) {
			System.out.println(listStr.get(i));
		}

		keyMap.clear();
		valueMap.clear();
		dataArr = null;
		textLine = null;
		count = 0;

	}

}
