package com.sundayalgo.solution;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TwoDayWorkerThread implements Runnable {
	private String[] args;
	private String textLine;
	private int lineIndex;
	private BufferedReader in;

	public TwoDayWorkerThread(String[] args, String textLine, int lineIndex, BufferedReader in) {
		this.args = args;
		this.textLine = textLine;
		this.lineIndex = lineIndex;
		this.in= in;
	}

	@Override
	public void run() {

		stringPrasing(args, textLine, lineIndex);

	}

	private void stringPrasing(String[] args, String textLine, int lineIndex) {

		Map<String, Object> keyMap = new HashMap<String, Object>();
		Map<String, Object> valueMap = new HashMap<String, Object>();

		List<String> listStr = new ArrayList<String>();

		String searchWord = args[0];
		String regex = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";

		String[] dataArr = textLine.split(regex);
		int count = 0;

		int point = 0;

		for (int i = 0; i < dataArr.length; i++) {

			point += dataArr[i].length() - 1;
			if (dataArr[i].toString().trim().equals(searchWord)) {
				count++;
				valueMap.put(lineIndex + "��° Ƚ��:", count);
				valueMap.put("point_", point + i); // trim���� ���ؼ� ���ܵ� Ư��
													// ���� �߰�
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
