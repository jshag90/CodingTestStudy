package com.ji.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 여행 경로
 * 
 * @author ji
 *
 */
public class TravelPath {

	public static void main(String[] args) {
//
//		String[] result = solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } });
		String[] result = solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } });
//		for(String res : result)
//			System.out.print(res+" ");
//		System.out.println(solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } }));

	}

	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		
		List<Integer> icnStartIndexList = new ArrayList<Integer>();
		for (int i = 0; i < tickets.length; i++) {
				if (tickets[i][0].equals("ICN")) 
					icnStartIndexList.add(i);
		}
		

		for(int i=0; i<icnStartIndexList.size(); i++) {
			
			List<String> answerList = new ArrayList<>();
			int useTicket = 0;
			String nextTicket = "ICN";
			while (useTicket <= tickets.length) {
				
				for (int j =0; j < tickets.length; j++) {
	
					if (tickets[j][0].equals(nextTicket) ) {
						if(!answerList.contains(tickets[j][0]))
							answerList.add(tickets[j][0]);
						answerList.add(tickets[j][1]);
						nextTicket = tickets[j][1];
						useTicket++;
					}
	
				}
	
			}
			
			answer = answerList.toArray(new String[answerList.size()]);
			for(String res : answer)
				System.out.print(res+" ");
			System.out.println();
		}

		return answer;
	}

}
