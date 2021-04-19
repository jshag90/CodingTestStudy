package com.sundayalgo.threeday;

import java.util.ArrayList;
import java.util.List;

public class NameMatching {
	
		
		static String result = "";
		
	
	public static void main(String[] args) {
		
		String name1 = "김민";
		String name2 = "남준호";
		String name = switchName(name1,name2);//이름 길이가 다른 경우가 들어왔을 경우의 예외 처리

		List<Integer> segmentCalList = new ArrayList<Integer>();
		
		SegementCalculate sc = new SegementCalculate();
		
		segmentCalList = sc.ln(name);
		
		for(int i=0; i<segmentCalList.size(); i++){
			
			System.out.print(segmentCalList.get(i)+" ");
		}
		System.out.println();
		String MathcinRateResult = calculMatchingRate(segmentCalList);

		System.out.println("최종 매칭률 : " + MathcinRateResult);
	}

	private static String switchName(String name1, String name2) {
		String nameResult = "";
		
		if(name1.length()==name2.length()){
			for(int i=0; i<name1.length(); i++){
						
						char str = name1.charAt(i);
						char str2 = name2.charAt(i);
						nameResult += String.valueOf(str)+String.valueOf(str2);
						System.out.println(nameResult);
						
			}
		
		}else if(name1.length()<name2.length()){
			
			String temp =" ";
			for(int i=0; i<name2.length(); i++){
				name1 +=temp;
				char str = name1.charAt(i);
				char str2 = name2.charAt(i);
				nameResult += String.valueOf(str)+String.valueOf(str2);
				
				System.out.println(nameResult);
				
			}
			
			
		}else if(name1.length()<name2.length()){
			
			String temp =" ";
			for(int i=0; i<name1.length(); i++){
				name2 +=temp;
				char str = name1.charAt(i);
				char str2 = name2.charAt(i);
				nameResult += String.valueOf(str)+String.valueOf(str2);
				
				System.out.println(nameResult);
				
			}
		}
		
			
		return nameResult.replace(" ", "");
	}

	private static String calculMatchingRate(List<Integer> segmentCalList) {
		
		
		List<Integer> resultList = new ArrayList<Integer>();
		
		
		for(int i=0; i<segmentCalList.size()-1; i++){
			
			resultList.add(calcuMatchingProcess(segmentCalList.get(i),segmentCalList.get(i+1)));
		}

		
		for(int i=0; i<resultList.size(); i++){
			System.out.print(resultList.get(i)+" ");
		}
		
		System.out.println();
		if(resultList.size()>2){
			
			calculMatchingRate(resultList);
			
		}else{
			
			for(int i=0; i<resultList.size(); i++){
				result += resultList.get(i).toString();
			}
			result += "%";
		}
		
		return result;
	}

	private static Integer calcuMatchingProcess(Integer num, Integer num2) {
		// TODO Auto-generated method stub
		
		int firstPositionNum=0;
		firstPositionNum = (num+num2)%10;
		
		return firstPositionNum;
	}

	


}
