package algorithm_20170709;

import java.util.ArrayList;
import java.util.List;
/*
 *  한글 획수 로직은 제외합니다. 죄송합니다.
 * 
 * */
public class Problem_2_mkkim_20170709 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(6);
		numList.add(5);
		numList.add(4);
		numList.add(3);
		numList.add(2);
		numList.add(1);
		List<Integer> resultList = getLoveMatchingPercent(numList);
		System.out.println(resultList);
	}

	private static List<Integer> getLoveMatchingPercent(List<Integer> numList) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numList.size()-1; i++) {
			list.add(sumCount(numList.get(i),numList.get(i+1)));
		}
		
		if(list.size() > 2) {
			list = getLoveMatchingPercent(list);
		}
		
		return list;
	}
	
	private static int sumCount(int preNum, int nextNum) {
		
		return (preNum + nextNum) % 10;
	}
}





