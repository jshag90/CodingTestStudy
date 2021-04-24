package com.ji.kakao2019;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	static Integer chkCnt = 0;
	static Integer dupuliCnt = 0;

	public static boolean arrayDupulicate(List<String> data, String num) {

		boolean result = false;

		for (int i = 0; i < data.size(); i++) {

			if (data.get(i).equals(num)) {
				dupuliCnt++;

				if (dupuliCnt >= 2) {
					result = false; // 중복데이터 존재
					break;
				}

			} else {
				if (chkCnt == data.size()) {
					result = true;
					break;
				}
				arrayDupulicate(data, data.get(chkCnt++));
			}

		}

		return result;
	}

	public static void main(String[] args) {

		Integer resultCnt = 0;

		List<Object> relationList = getParseData();

		List<Object> relationListChange = new ArrayList<Object>();
		relationListChange = changeRelation(relationList);

		List<Object> newRelactionList = new ArrayList<Object>();
		for (int i = 0; i < relationListChange.size(); i++) {
			List<String> rowData = (List<String>) relationListChange.get(i);
			
			if (arrayDupulicate(rowData, rowData.get(0))) {
				resultCnt++;
			} else {
				newRelactionList.add(rowData);
			}
		}
		
		List<Object> remainList = changeRelation(newRelactionList);
		List<String> mergeList = new ArrayList<String>();
		for(int i=0; i<remainList.size(); i++){
			List<String> list = (List<String>) remainList.get(i);
			String merge = list.get(0)+list.get(1); //HOW ?? 
			mergeList.add(merge);
		}
		
		chkCnt = 0;
		dupuliCnt = 0;
		
		if(arrayDupulicate(mergeList, mergeList.get(0))){
			resultCnt++;
		}
		
		System.out.println(resultCnt);

	}

	public static List<Object> changeRelation(List<Object> relationList) {

		List<Object> relationListChange = new ArrayList<Object>();

		List<String> cycleList = (List<String>) relationList.get(0);
		// 가로 List -> 세로 list
		Integer rowCnt = 0;
		for (int j = 0; j < cycleList.size(); j++) {
			List<String> columDataList = new ArrayList<String>();
			for (int i = 0; i < relationList.size(); i++) {

				List<String> dataStr = (List<String>) relationList.get(i);
				columDataList.add(dataStr.get(rowCnt));
			}
			relationListChange.add(columDataList);
			rowCnt++;
		}

		return relationListChange;
	}

	private static List<Object> getParseData() {

		String input = "[[“100”,”ryan”,”music”,”2”],[“200”,”apeach”,”math”,”2”],[“300”,”tube”,”computer”,”3”],[“400”,”con”,”computer”,”4”],[“500”,”muzi”,”music”,”3”],[“600”,”apeach”,”music”,”2”]]";
		input = input.replace("[[", "[");
		input = input.replace("]]", "]");
		String[] inputArr = input.split("],");

		List<Object> relationList = new ArrayList<Object>();
		for (String data : inputArr) {
			data = data.replace("“", "");
			data = data.replace("”", "");
			data = data.replace("[", "");
			data = data.replace("]", "");
			String[] relValue = data.split(",");
			List<String> strList = new ArrayList<>();
			for(String str: relValue){
				strList.add(str);
			}
			relationList.add(strList);
		}
		return relationList;
	}

}
