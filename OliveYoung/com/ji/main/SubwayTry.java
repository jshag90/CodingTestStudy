package com.ji.main;

import java.util.ArrayList;
import java.util.List;

public class SubwayTry {

	//bfs 를 사용해야할꺼 같음
	static List<SubwayVO> subwayList = new ArrayList<SubwayVO>();
	static int count = 0;

	public static void main(String[] args) {
		String[] subway = { "1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21" };
		int start = 1;
		int end = 9;

		System.out.println(solution(subway, 1, 9));

	}

	public static int solution(String[] subway, int start, int end) {

		int result = 0;

		int lineIndex = 1;
		for (String subwayNumStr : subway) {
			SubwayVO subwayVO = new SubwayVO();
			subwayVO.setLineNum(lineIndex);
			List<Integer> subwayNumbers = new ArrayList<Integer>();
			for (String num : subwayNumStr.split(" "))
				subwayNumbers.add(Integer.parseInt(num));
			subwayVO.setSubwayNumbers(subwayNumbers);
			subwayVO.setVisit(false);
			subwayList.add(subwayVO);
		}

		for (SubwayVO vo : subwayList) {
			if(vo.isVisit == false) {
				if(vo.getSubwayNumbers().contains(start)) {
					
//					recursiveChk(subwayList, start, end);
				
				}
				
			}
		}
		result = count;
		return result;

	}

	public static void recursiveChk(SubwayVO vo, int start, int end) {

				
//				if(vo.getSubwayNumbers().contains(end)) 
				
				if(vo.getSubwayNumbers().contains(start)) {
					vo.setVisit(true);
					count++;
					for(int num : vo.getSubwayNumbers()) {
//						recursiveChk(subwayList, num, end);
					}
				}


	}

}

class SubwayVO {
	int lineNum; // 지하철 노선 번호
	List<Integer> subwayNumbers; // 지하철
	boolean isVisit;

	public boolean isVisit() {
		return isVisit;
	}

	public void setVisit(boolean isVisit) {
		this.isVisit = isVisit;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public List<Integer> getSubwayNumbers() {
		return subwayNumbers;
	}

	public void setSubwayNumbers(List<Integer> subwayNumbers) {
		this.subwayNumbers = subwayNumbers;
	}

}
